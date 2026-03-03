package com.ricardofrade.tcgdex.feature.pokemonlist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ricardofrade.tcgdex.feature.pokemonlist.domain.usecase.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<PokemonListState>(PokemonListState.Loading())
    val state: StateFlow<PokemonListState> = _state.asStateFlow()

    private val _effects = MutableSharedFlow<PokemonListEffect>()
    val effects: SharedFlow<PokemonListEffect> = _effects.asSharedFlow()

    private var searchJob: Job? = null

    init {
        handleIntent(PokemonListIntent.LoadInitial)
    }

    fun handleIntent(intent: PokemonListIntent) {
        when (intent) {
            is PokemonListIntent.LoadInitial -> loadCards()
            is PokemonListIntent.Search -> onSearch(intent.query)
            is PokemonListIntent.OnCardClicked -> navigateToDetails(intent.cardId)
        }
    }

    private fun loadCards() {
        val currentState = _state.value

        viewModelScope.launch {
            val query = currentState.searchQuery
            val cards = (currentState as? PokemonListState.Success)?.cards ?: emptyList()


            _state.value = PokemonListState.Success(
                cards = cards,
                searchQuery = query
            )

            val filter = query.takeIf { it.isNotBlank() }
            val result = getPokemonListUseCase(nameFilter = filter)

            result.onSuccess { newCards ->
                _state.value = PokemonListState.Success(
                    cards = newCards,
                    searchQuery = query
                )
            }.onFailure { exception ->
                _state.value = PokemonListState.Error(
                    message = exception.message ?: "Unknown error occurred",
                    searchQuery = query
                )
                _effects.emit(
                    PokemonListEffect.ShowToast(
                        exception.message ?: "Failed to load cards"
                    )
                )
            }
        }
    }

    private fun onSearch(query: String) {
        val currentState = _state.value
        _state.value = when (currentState) {
            is PokemonListState.Loading -> currentState.copy(searchQuery = query)
            is PokemonListState.Success -> currentState.copy(searchQuery = query)
            is PokemonListState.Error -> currentState.copy(searchQuery = query)
        }
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(500)
            loadCards()
        }
    }

    private fun navigateToDetails(cardId: String) {
        viewModelScope.launch {
            _effects.emit(PokemonListEffect.NavigateToDetails(cardId))
        }
    }
}
