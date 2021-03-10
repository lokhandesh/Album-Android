package com.myproject.albumlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.myproject.albumlist.data.Album

class AlbumDatabaseFake {

    // fake for album table in local db
    val album = MutableLiveData<List<Album>>()

}