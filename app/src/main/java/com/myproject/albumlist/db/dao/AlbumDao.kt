package com.myproject.albumlist.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.myproject.albumlist.data.Album

/**
 * Created by Santosh Lokhande on 08/3/2021.
 *
 * Here we declare method for Room Db
 *
 * THis interface should annotate with @Dao
 *
 */

@Dao
interface AlbumDao {

    @Insert
    fun insert(users: List<Album>)

    @Query("SELECT * FROM album_table ")
    fun getAllAlbumList(): LiveData<List<Album>>

    @Query("DELETE FROM album_table")
    fun deleteAll()

}