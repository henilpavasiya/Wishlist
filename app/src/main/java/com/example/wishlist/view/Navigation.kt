package com.example.wishlist.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wishlist.data.Wish
import com.example.wishlist.viewmodel.WishViewModel


@Composable
fun Navigation(
    viewModel: WishViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavHostController = rememberNavController(),
    wish: Wish
) {
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            WishList(viewModel,navController,wish)
        }
        composable(route=Screen.AddScreen.route){
            AddWish(viewModel,navController)
        }
    }
}


