package com.example.wishlist.data

import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDao: WishDao) {

    suspend fun addWishes(wish: Wish) {
        wishDao.addWish(wish)
    }

    suspend fun updateWishes(wish: Wish) {
        wishDao.updateWish(wish)
    }

    suspend fun deleteWishes(wish: Wish) {
        wishDao.deleteWish(wish)
    }

    fun getWishes(): Flow<List<Wish>> = wishDao.getAllWishes()
    fun getWishesById(id: Long): Flow<Wish> = wishDao.getWishById(id)
}