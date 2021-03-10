package com.myproject.albumlist

import androidx.lifecycle.LiveData
import com.myproject.albumlist.data.Album
import com.myproject.albumlist.db.dao.AlbumDao

class AlbumDaoFake(private val albumDatabaseFake: AlbumDatabaseFake) : AlbumDao {
    override fun insert(list: List<Album>) {
        albumDatabaseFake.album.value = list
    }

    override fun getAllAlbumList(): LiveData<List<Album>> {
        return albumDatabaseFake.album
    }

    override fun deleteAll() {

    }
}