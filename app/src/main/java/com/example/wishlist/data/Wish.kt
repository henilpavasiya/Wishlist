package com.example.wishlist.data

import java.io.Serializable

data class Wish(
    var id: Int = 1,
    var title: String = "",
    var description: String = "",
    var isEdited: Boolean = false
): Serializable

object DummyWish {
    val wishesList = listOf(
        Wish(id = 1, title = "Wish 1", description = "Description for Wish 1"),
        Wish(id = 2, title = "Wish 2", description = "Description for Wish 2"),
        Wish(id = 3, title = "Wish 3", description = "Description for Wish 3")
    )
}