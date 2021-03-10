package com.myproject.albumlist.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Santosh Lokhande on 08/3/2021
 *
 * Album is Data class
 *
 * All field of this class works as a column name of album_table
 *
 */

@Entity(tableName = "album_table")
data class Album(
        @PrimaryKey
        val id: Int,
        val userId: Int,
        val title: String
)

data class AlbumResponse(
        val results: List<Album>
)