package com.example.wishlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wishlist.ui.theme.WishlistTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishList(title: String, description: String, navigateToAddWishScreen: () -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            AppBarView(title = "WishList", onBackClick = {})
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navigateToAddWishScreen()
            }, containerColor = Color(0xFF000000)) {
                Icon(Icons.Default.Add, contentDescription = "Add", tint = Color(0xFFFFFFFF))
            }
        }
    ) { innerPadding ->
        WishListData(
            modifier = Modifier
                .padding(innerPadding)
                .background(colorResource(id = R.color.primaryColor)),
            title = title,
            description = description
        )
    }
}

@Composable
fun WishListData(modifier: Modifier = Modifier, title: String, description: String) {

    val titlesAndSubtitles = listOf(
        "Title 1" to "Subtitle 1",
        "Title 2" to "Subtitle 2",
        "Title 3" to "Subtitle 3"
    )

    Box(
        modifier = Modifier
            .padding(20.dp, 0.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = description, fontSize = 16.sp, color = Color.Gray)
        }
    }

//    LazyColumn(modifier = modifier.fillMaxSize()) {
//        items(titlesAndSubtitles) { item ->
//            Spacer(modifier = Modifier.height(15.dp))
//            CustomBox(item.first, item.second)
//        }
//    }
}


@Composable
fun CustomBox(title: String, subtitle: String) {
    Box(
        modifier = Modifier
            .padding(20.dp, 0.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = subtitle, fontSize = 16.sp, color = Color.Gray)
        }
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    WishlistTheme {
//        WishListData()
//    }
//}