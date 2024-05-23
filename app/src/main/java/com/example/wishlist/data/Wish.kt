package com.example.wishlist.data

import java.io.Serializable

data class Wish(
    var id: Int = 1,
    var title: String = "",
    var description: String = ""
): Serializable

data class WishList(var wishes: List<Wish>)