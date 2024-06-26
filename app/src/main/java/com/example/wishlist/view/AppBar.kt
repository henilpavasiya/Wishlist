package com.example.wishlist.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.wishlist.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarView(title: String, onBackClick: () -> Unit) {
    val navigationIcon : (@Composable ()-> Unit) = {
        if(title.contains("WishList") ){
            null
        }
        else{
            IconButton(onClick = {onBackClick() }) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        }
    }


    TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
        containerColor = colorResource(id = R.color.primaryColor),
//        containerColor = Color(0xFFD72E5E),
        titleContentColor = colorResource(id = R.color.white),
    ), title = { Text(title) }, navigationIcon = navigationIcon)
}