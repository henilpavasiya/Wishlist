package com.example.wishlist.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 1,

    @ColumnInfo(name = "wish-title")
    var title: String = "",

    @ColumnInfo(name = "wish-desc")
    var description: String = "",
//    var isEdited: Boolean = false
)

object DummyWish {
    val wishesList = listOf(
        Wish(id = 1, title = "Wish 1", description = "Description for Wish 1"),
        Wish(id = 2, title = "Wish 2", description = "Description for Wish 2"),
        Wish(id = 3, title = "Wish 3", description = "Description for Wish 3")
    )
}