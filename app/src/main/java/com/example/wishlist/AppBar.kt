package com.example.wishlist

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarView(title: String, onBackClicked: @Composable () -> Unit) {
    TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
        containerColor = colorResource(id = R.color.primaryColor),
//        containerColor = Color(0xFFD72E5E),
        titleContentColor = colorResource(id = R.color.white),
    ), title = { Text(title) }, navigationIcon = {
        onBackClicked()
    })
}