package com.myproject.albumlist.viewmodel

import androidx.lifecycle.LiveData
import com.myproject.albumlist.app.MyApp
import com.myproject.albumlist.base.BaseViewModel
import com.myproject.albumlist.data.Album
import com.myproject.albumlist.repository.AlbumRepository
import javax.inject.Inject

/**
 * Created by Santosh Lokhande on 08/3/2021
 *
 * AlbumViewModel which is extended from AndroidViewModel.
 *
 * Here we received all albumlist from RoomDb.
 *
 */


class AlbumViewModel() : BaseViewModel() {

    @Inject
    lateinit var repository: AlbumRepository

    init {
        MyApp.getInstance()?.getDaggerComponent()?.inject(this)
    }

    fun getAllAlbumTitle(): LiveData<List<Album>> {
        return repository.getAllAlbumList()
    }

    fun retriveAlbumList() {
        repository.retriveAlbumList()
    }


}