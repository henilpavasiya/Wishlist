package com.example.wishlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddWish(navigateToWishListScreen: (String, String) -> Unit) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFFD72E5E),
                titleContentColor = Color(0xFFFFFFFF)
            ), title = { Text("Add Wish") }, navigationIcon = {
                IconButton(onClick = { navigateToWishListScreen("","") }) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            })

        },
    ) { innerPadding ->
        AddWishTextField(modifier = Modifier.padding((innerPadding)), navigateToWishListScreen)
    }
}

@Composable
fun AddWishTextField(modifier: Modifier,navigateToWishListScreen: (String, String) -> Unit) {
    var title = remember {
        mutableStateOf("")
    }
    var description = remember {
        mutableStateOf("")
    }

    Column(modifier = modifier) {
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(value = title.value, onValueChange = {
            title.value = it
        }, label = {
            Text("Title")
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp, 0.dp)
        )
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(value = description.value, onValueChange = {
            description.value = it
        }, label = {
            Text("Description")
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp, 0.dp)
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 0.dp),
            onClick = {
                navigateToWishListScreen(title.value,description.value)
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD72E5E))
        ) {
            Text("Add Wish", color = Color.White)
        }
    }
}