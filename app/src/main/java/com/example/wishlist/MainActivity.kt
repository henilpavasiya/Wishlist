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

//Steps to implement Room database:
// 1. Create a data entity class with table name
// 2. Create a DAO class/interface
// 3. Create a database class with database name
// 4. Create a repository class to access the DAO
// 5. Create a ViewModel class to access the repository
// 6. Create a UI class to access the ViewModel