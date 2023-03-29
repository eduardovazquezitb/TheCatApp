package com.example.thecatapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Favorite::class)], version = 1, exportSchema = false)
abstract class FavoriteRoomDatabase : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao

    companion object{
        @Volatile
        private var INSTANCE : FavoriteRoomDatabase? = null

        fun getInstance(context: Context): FavoriteRoomDatabase {
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FavoriteRoomDatabase::class.java,
                        "favorite_database"
                    ).fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }
        }
    }
}