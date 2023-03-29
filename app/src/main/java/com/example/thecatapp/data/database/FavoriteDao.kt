package com.example.thecatapp.data.database

import androidx.room.*

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavorite(favorite: Favorite)

    @Delete
    suspend fun deleteFavorite(favorite: Favorite)

    @Query("SELECT * FROM favorites")
    fun getFavorites(): List<Favorite>

    @Query("SELECT EXISTS(SELECT * FROM favorites WHERE id = :id)")
    fun isFavorite(id: String) : Boolean
}