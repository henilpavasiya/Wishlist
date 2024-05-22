package com.example.wishlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wishlist.ui.theme.WishlistTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WishlistTheme {
               Navigation()
            }
        }
    }
}

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "wishListScreen/title/description") {
        composable("wishListScreen/{title}/{description}"){
            val title = it.arguments?.getString("title") ?: "no title"
            val description = it.arguments?.getString("description") ?: "no description"
            WishList(title,description){
                navController.navigate("secondScreen")
            }
        }
        composable("secondScreen"){
            AddWish{title,description ->
                navController.navigate("wishListScreen/$title/$description")
            }
        }
    }
}