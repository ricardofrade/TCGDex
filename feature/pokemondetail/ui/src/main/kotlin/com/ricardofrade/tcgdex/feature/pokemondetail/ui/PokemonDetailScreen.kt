package com.ricardofrade.tcgdex.feature.pokemondetail.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.repeatOnLifecycle
import coil3.compose.AsyncImage
import com.ricardofrade.tcgdex.feature.pokemondetail.domain.model.PokemonCardDetail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailScreen(
    cardId: String,
    viewModel: PokemonDetailViewModel,
    onNavigateBack: () -> Unit,
    onShowToast: (String) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(cardId) {
        viewModel.handleIntent(PokemonDetailIntent.LoadCard(cardId))
    }

    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(viewModel.effects, lifecycleOwner) {
        lifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
            viewModel.effects.collect { effect ->
                when (effect) {
                    is PokemonDetailEffect.NavigateBack -> onNavigateBack()
                    is PokemonDetailEffect.ShowToast -> onShowToast(effect.message)
                }
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    val title = if (state is PokemonDetailState.Success) {
                        (state as PokemonDetailState.Success).card.name
                    } else stringResource(R.string.card_details_title)
                    Text(title)
                },
                navigationIcon = {
                    IconButton(onClick = { viewModel.handleIntent(PokemonDetailIntent.OnBackClicked) }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back_button_content_description)
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()) {
            when (val s = state) {
                is PokemonDetailState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }

                is PokemonDetailState.Success -> {
                    PokemonDetailContent(card = s.card)
                }

                is PokemonDetailState.Error -> {
                    Text(
                        text = s.message,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Composable
fun PokemonDetailContent(card: PokemonCardDetail) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        AsyncImage(
            model = "${card.image}/high.jpg",
            contentDescription = card.name,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(bottom = 16.dp)
        )

        Text(text = card.name, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))

        CardInfoRow(stringResource(R.string.label_hp), card.hp.toString())
        CardInfoRow(stringResource(R.string.label_rarity), card.rarity)
        CardInfoRow(stringResource(R.string.label_illustrator), card.illustrator)
        CardInfoRow(stringResource(R.string.label_types), card.types.joinToString(", "))
    }
}

@Composable
fun CardInfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(text = value, style = MaterialTheme.typography.bodyLarge)
    }
}
