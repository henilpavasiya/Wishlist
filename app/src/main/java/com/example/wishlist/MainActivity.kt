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
import com.example.wishlist.data.DummyWish
import com.example.wishlist.data.Wish
import com.example.wishlist.ui.theme.WishlistTheme
import com.example.wishlist.view.AddWish
import com.example.wishlist.view.Navigation
import com.example.wishlist.view.WishList

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

//@Composable
//fun Navigation2(){
//    val navController = rememberNavController()
//
//    fun getWishById(id: Int?): Wish? {
//        // Your implementation to fetch the Wish object from your data source
//        // For example, you might have a list of wishes or a database query here
//        return DummyWish.wishesList.find { it.id == id } // Replace with your actual data retrieval logic
//    }
//
//    NavHost(navController = navController, startDestination = "wishListScreen/{wishId}") {
//        composable("wishListScreen/{wishId}") { backStackEntry ->
//            val wishId = backStackEntry.arguments?.getInt("wishId") ?:1
//            // Retrieve the Wish object using the ID
//            val wish = getWishById(wishId) // This function should fetch the Wish object based on the ID
//            if (wish != null) {
//                WishList(wish) {
//                    navController.navigate("secondScreen")
//                }
//            } else {
//                // Handle the case where the wish is null
//                // You might want to show an error message or navigate to an error screen
//            }
//        }
//        composable("secondScreen") {
//            AddWish { wish ->
//                navController.navigate("wishListScreen/${wish.id}") // Use wish.id to navigate
//            }
//        }
//    }
//
////    NavHost(navController = navController, startDestination = "secondScreen") {
////        composable("wishListScreen/{wish}"){
////            val wish :Wish= it.arguments?.getSerializable("wish") as Wish
////            WishList(wish){
////                navController.navigate("secondScreen")
////            }
////        }
////        composable("secondScreen"){
////            AddWish{wish ->
////                navController.navigate("wishListScreen/$wish")
////            }
////        }
////    }
//}