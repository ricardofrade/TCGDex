package com.ricardofrade.tcgdex

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ricardofrade.tcgdex.feature.pokemondetail.ui.PokemonDetailScreen
import com.ricardofrade.tcgdex.feature.pokemondetail.ui.PokemonDetailViewModel
import com.ricardofrade.tcgdex.feature.pokemonlist.ui.PokemonListScreen
import com.ricardofrade.tcgdex.feature.pokemonlist.ui.PokemonListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TCGDexAppCoordinator()
                }
            }
        }
    }
}

sealed class Screen(val route: String) {
    object PokemonList : Screen("pokemon_list")
    object PokemonDetail : Screen("pokemon_detail/{cardId}") {
        fun createRoute(cardId: String) = "pokemon_detail/$cardId"
    }
}

@Composable
fun TCGDexAppCoordinator() {
    val navController = rememberNavController()
    val context = LocalContext.current

    val showToast: (String) -> Unit = { message ->
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    NavHost(navController = navController, startDestination = Screen.PokemonList.route) {
        composable(Screen.PokemonList.route) {
            val viewModel: PokemonListViewModel = hiltViewModel()
            PokemonListScreen(
                viewModel = viewModel,
                onNavigateToDetails = { cardId ->
                    navController.navigate(Screen.PokemonDetail.createRoute(cardId))
                },
                onShowToast = showToast
            )
        }

        composable(
            route = Screen.PokemonDetail.route,
            arguments = listOf(navArgument("cardId") { type = NavType.StringType })
        ) { backStackEntry ->
            val cardId = backStackEntry.arguments?.getString("cardId") ?: return@composable
            val viewModel: PokemonDetailViewModel = hiltViewModel()

            PokemonDetailScreen(
                cardId = cardId,
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() },
                onShowToast = showToast
            )
        }
    }
}