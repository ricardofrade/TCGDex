package com.ricardofrade.tcgdex.feature.pokemondetail.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ricardofrade.tcgdex.feature.pokemondetail.domain.usecase.GetPokemonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<PokemonDetailState>(PokemonDetailState.Loading)
    val state: StateFlow<PokemonDetailState> = _state.asStateFlow()

    private val _effects = MutableSharedFlow<PokemonDetailEffect>()
    val effects: SharedFlow<PokemonDetailEffect> = _effects.asSharedFlow()

    fun handleIntent(intent: PokemonDetailIntent) {
        when (intent) {
            is PokemonDetailIntent.LoadCard -> loadCard(intent.cardId)
            is PokemonDetailIntent.OnBackClicked -> navigateBack()
        }
    }

    private fun loadCard(cardId: String) {
        if (_state.value is PokemonDetailState.Loading && cardId.isEmpty()) return

        viewModelScope.launch {
            _state.value = PokemonDetailState.Loading

            val result = getPokemonDetailUseCase(cardId)

            result.onSuccess { card ->
                _state.value = PokemonDetailState.Success(card)
            }.onFailure { exception ->
                _state.value = PokemonDetailState.Error(exception.message ?: "Unknown error")
                _effects.emit(
                    PokemonDetailEffect.ShowToast(
                        exception.message ?: "Failed to load card"
                    )
                )
            }
        }
    }

    private fun navigateBack() {
        viewModelScope.launch {
            _effects.emit(PokemonDetailEffect.NavigateBack)
        }
    }
}
