package com.example.thecatapp.data.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "favorites")
data class Favorite (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: String
) : Parcelable