package com.example.wishlist.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.wishlist.R
import com.example.wishlist.data.Wish
import com.example.wishlist.viewmodel.WishViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddWish(
    id: Long,
    viewModel: ViewModel,
    navController: NavController,
//    navigateToWishListScreen: (Wish) -> Unit
) {

    Scaffold(
//        modifier = Modifier.fillMaxSize(),
        topBar = {
            AppBarView(title = if (id != 0L) "Update Wish" else "Add Wish") {
                navController.navigateUp()
            }
        },
    ) { innerPadding ->
        AddWishTextField(
            modifier = Modifier.padding((innerPadding)),
            id = id,
            viewModel = viewModel,
            navController = navController,
//            navigateToWishListScreen
        )
    }
}

@Composable
fun AddWishTextField(
    modifier: Modifier,
    id: Long,
    viewModel: ViewModel,
    navController: NavController,
//                     navigateToWishListScreen: (Wish) -> Unit
) {
    val viewmodel: WishViewModel = viewModel()

    Column(modifier = modifier) {
        Spacer(modifier = Modifier.padding(10.dp))
        CustomOutlinedTextField(
            value = viewmodel.wishTitle.value,
            label = "Title",
            onValueChanged = {
                viewmodel.onWishTitleChange(it)
            })

        Spacer(modifier = Modifier.padding(10.dp))

        CustomOutlinedTextField(
            value = viewmodel.wishDescription.value,
            label = "Description",
            onValueChanged = {
                viewmodel.onWishDescriptionChange(it)
            })
        Spacer(modifier = Modifier.padding(10.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 0.dp),
            onClick = {

                if (viewmodel.wishTitle.value.isNotEmpty() && viewmodel.wishDescription.value.isNotEmpty()) {
                    //TODO UpdateWish
                } else {
                    //TODO AddWish
                }
//                navigateToWishListScreen(
//                    Wish(
//                        1,
//                        viewmodel.wishTitle.value,
//                        viewmodel.wishDescription.value
//                    )
//                )
            },
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.primaryColor))
        ) {
            if (id != 0L) Text("Update Wish", color = Color.White) else Text(
                "Add Wish",
                color = Color.White
            )

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField(value: String, label: String, onValueChanged: (String) -> Unit) {
    OutlinedTextField(
        value = value, onValueChange = onValueChanged, label = {
            Text(label)
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp, 0.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedTextColor = colorResource(id = R.color.primaryColor),
            unfocusedTextColor = colorResource(id = R.color.black),
            focusedLabelColor = colorResource(id = R.color.primaryColor),
            unfocusedLabelColor = colorResource(id = R.color.black)
        )
    )
}