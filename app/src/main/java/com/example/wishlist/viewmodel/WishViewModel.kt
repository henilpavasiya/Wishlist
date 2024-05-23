package com.example.wishlist.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel

class WishViewModel: ViewModel() {
    var wishTitle = mutableStateOf("")
    var wishDescription = mutableStateOf("")

    fun onWishTitleChange(title:String){
        wishTitle.value = title
    }

    fun onWishDescriptionChange(description:String){
        wishDescription.value = description
    }

}