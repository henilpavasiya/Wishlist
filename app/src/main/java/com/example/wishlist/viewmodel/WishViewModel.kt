package com.example.wishlist.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wishlist.Graph
import com.example.wishlist.data.Wish
import com.example.wishlist.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(private val wishRepository: WishRepository = Graph.wishRepository) :
    ViewModel() {
    var wishTitle = mutableStateOf("")
    var wishDescription = mutableStateOf("")

    fun onWishTitleChange(title: String) {
        wishTitle.value = title
    }

    fun onWishDescriptionChange(description: String) {
        wishDescription.value = description
    }

    fun addWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.addWishes(wish)
        }
    }

    fun updateWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.updateWishes(wish)
        }
    }

    fun deleteWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.deleteWishes(wish)
        }
    }

    lateinit var getAllWishes: Flow<List<Wish>>

    init {
        viewModelScope.launch {
            getAllWishes = wishRepository.getWishes()
        }
    }

    fun getWishesById(id: Long): Flow<Wish> = wishRepository.getWishesById(id)

}