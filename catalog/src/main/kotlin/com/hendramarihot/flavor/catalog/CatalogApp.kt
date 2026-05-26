package com.hendramarihot.flavor.catalog

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hendramarihot.flavor.catalog.screens.BottomSheetCatalogScreen
import com.hendramarihot.flavor.catalog.screens.ButtonCatalogScreen
import com.hendramarihot.flavor.catalog.screens.CardCatalogScreen
import com.hendramarihot.flavor.catalog.screens.CatalogHomeScreen
import com.hendramarihot.flavor.catalog.screens.DialogCatalogScreen
import com.hendramarihot.flavor.catalog.screens.EmptyViewCatalogScreen
import com.hendramarihot.flavor.catalog.screens.ErrorViewCatalogScreen
import com.hendramarihot.flavor.catalog.screens.InputCatalogScreen
import com.hendramarihot.flavor.catalog.screens.ShimmerCatalogScreen
import com.hendramarihot.flavor.catalog.screens.SkeletonCatalogScreen
import com.hendramarihot.flavor.catalog.screens.ThemeCatalogScreen
import kotlinx.serialization.Serializable

@Serializable data object HomeRoute
@Serializable data object ButtonsRoute
@Serializable data object InputsRoute
@Serializable data object CardsRoute
@Serializable data object ShimmerRoute
@Serializable data object SkeletonRoute
@Serializable data object DialogRoute
@Serializable data object BottomSheetRoute
@Serializable data object ErrorViewRoute
@Serializable data object EmptyViewRoute
@Serializable data object ThemeRoute

@Composable
fun CatalogApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeRoute,
    ) {
        composable<HomeRoute> {
            CatalogHomeScreen(
                onNavigateToButtons = { navController.navigate(ButtonsRoute) },
                onNavigateToInputs = { navController.navigate(InputsRoute) },
                onNavigateToCards = { navController.navigate(CardsRoute) },
                onNavigateToShimmer = { navController.navigate(ShimmerRoute) },
                onNavigateToSkeleton = { navController.navigate(SkeletonRoute) },
                onNavigateToDialog = { navController.navigate(DialogRoute) },
                onNavigateToBottomSheet = { navController.navigate(BottomSheetRoute) },
                onNavigateToErrorView = { navController.navigate(ErrorViewRoute) },
                onNavigateToEmptyView = { navController.navigate(EmptyViewRoute) },
                onNavigateToTheme = { navController.navigate(ThemeRoute) },
            )
        }
        composable<ButtonsRoute> {
            ButtonCatalogScreen(onNavigateUp = { navController.navigateUp() })
        }
        composable<InputsRoute> {
            InputCatalogScreen(onNavigateUp = { navController.navigateUp() })
        }
        composable<CardsRoute> {
            CardCatalogScreen(onNavigateUp = { navController.navigateUp() })
        }
        composable<ShimmerRoute> {
            ShimmerCatalogScreen(onNavigateUp = { navController.navigateUp() })
        }
        composable<SkeletonRoute> {
            SkeletonCatalogScreen(onNavigateUp = { navController.navigateUp() })
        }
        composable<DialogRoute> {
            DialogCatalogScreen(onNavigateUp = { navController.navigateUp() })
        }
        composable<BottomSheetRoute> {
            BottomSheetCatalogScreen(onNavigateUp = { navController.navigateUp() })
        }
        composable<ErrorViewRoute> {
            ErrorViewCatalogScreen(onNavigateUp = { navController.navigateUp() })
        }
        composable<EmptyViewRoute> {
            EmptyViewCatalogScreen(onNavigateUp = { navController.navigateUp() })
        }
        composable<ThemeRoute> {
            ThemeCatalogScreen(onNavigateUp = { navController.navigateUp() })
        }
    }
}
