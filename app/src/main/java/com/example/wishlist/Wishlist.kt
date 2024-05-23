package com.example.wishlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.example.wishlist.data.Wish
import java.io.Serializable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishList(wish: Wish, navigateToAddWishScreen: () -> Unit) {
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
            wish=wish
        )
    }
}

@Composable
fun WishListData(modifier: Modifier = Modifier, wish:Wish) {

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
            Text(text = wish.title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = wish.description, fontSize = 16.sp, color = Color.Gray)
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
fun CustomBox(wish: Wish) {
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
            Text(text = wish.title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = wish.description, fontSize = 16.sp, color = Color.Gray)
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