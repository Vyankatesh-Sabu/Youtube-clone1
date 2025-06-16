package com.example.spotifyclone

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.spotifyclone.ui.HomeLayout
import com.example.spotifyclone.ui.playerLayout
import com.example.spotifyclone.ui.searchLayout
import com.example.spotifyclone.viewModel.RoomViewModel
import com.example.spotifyclone.viewModel.searchViewModel
import com.example.spotifyclone.viewModel.sharedViewModel
import kotlinx.serialization.Serializable


@Composable
fun Navigation(
    navController : NavHostController = rememberNavController(),
    roomViewModel : RoomViewModel = viewModel(),
    searchViewModel: searchViewModel = searchViewModel(MainApplication.apiServiceRepository ),
    sharedViewModel: sharedViewModel = viewModel()
){
    NavHost(
        navController = navController,
        startDestination = HomeLayout,
        enterTransition = { fadeIn(animationSpec = tween(700)) + slideIntoContainer(
            AnimatedContentTransitionScope.SlideDirection.Down, tween(700)
        ) },
        popEnterTransition = {
            fadeIn(animationSpec = tween(700)) + slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right, tween(700)
            )
        }
        ) {
        composable<HomeLayout>(){
            HomeLayout(navController)
        }
        composable<SearchLayout>(){
            searchLayout(
                navController,
                roomViewModel = roomViewModel,
                searchViewModel = searchViewModel,
                sharedViewModel = sharedViewModel
            )
        }
        composable<PlayerLayout>{
            playerLayout(
                sharedViewModel = sharedViewModel
            )
        }
    }
}

@Serializable
object SearchLayout

@Serializable
object HomeLayout

@Serializable
object PlayerLayout