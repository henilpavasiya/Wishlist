package com.example.wishlist.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.wishlist.R
import com.example.wishlist.data.DummyWish
import com.example.wishlist.data.Wish

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishList(
    viewModel: ViewModel,
    navController: NavController
    //    navigateToAddWishScreen: () -> Unit
) {
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            AppBarView(title = "WishList", onBackClick = {})
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Screen.AddScreen.route)

//                navigateToAddWishScreen()
            }, containerColor = Color(0xFF000000)) {
                Icon(Icons.Default.Add, contentDescription = "Add", tint = Color(0xFFFFFFFF))
            }
        }
    ) { innerPadding ->
        WishListData(
            modifier = Modifier
                .padding(innerPadding)
                .background(colorResource(id = R.color.primaryColor)),
            viewModel= viewModel,
            navController = navController,
//            navigateToAddWishScreen
        )
    }
}

@Composable
fun WishListData(modifier: Modifier = Modifier,  viewModel: ViewModel,
                 navController: NavController,
//                 navigateToAddWishScreen: () -> Unit
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(DummyWish.wishesList) { item ->
            Spacer(modifier = Modifier.height(15.dp))
            CustomBox(item,
                navController = navController,
//                navigateToAddWishScreen
            )
        }
    }
}


@Composable
fun CustomBox(wish: Wish,
              navController: NavController,
//              navigateToAddWishScreen: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(20.dp, 0.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(Color.White)
            .clickable {
                navController.navigate(Screen.AddScreen.route)
//                navigateToAddWishScreen()
//                wish.isEdited = true

            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(text = wish.title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = wish.description, fontSize = 16.sp, color = Color.Gray)
        }
    }
}
