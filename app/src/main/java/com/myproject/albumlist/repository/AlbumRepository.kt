package com.myproject.albumlist.repository

import androidx.lifecycle.LiveData
import android.os.AsyncTask
import androidx.lifecycle.MutableLiveData
import com.myproject.albumlist.app.MyApp
import com.myproject.albumlist.data.Album
import com.myproject.albumlist.db.AlbumDatabase
import com.myproject.albumlist.db.dao.AlbumDao
import com.myproject.albumlist.service.ApiInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Santosh Lokhande on 08/3/2021
 *
 * This class is used to communicate with RoomDb and Network Call
 *
 * In init block we initialise AlbumDatabase class.
 *
 */

class AlbumRepository() {

    private var albumDao: AlbumDao
    private var allAlbumData: LiveData<List<Album>>
    private var albumData = MutableLiveData<Album>()
    private  val compositeDisposable = CompositeDisposable()

    @Inject
    lateinit var apiEndPointInterface: ApiInterface

    init {
        val database: AlbumDatabase = AlbumDatabase.getInstance()!!
        albumDao = database.albumDao()
        allAlbumData = albumDao.getAllAlbumList()
        MyApp.getInstance()?.getDaggerComponent()?.inject(this)
    }

    fun getAllAlbumList(): LiveData<List<Album>> {
        return allAlbumData
    }

    fun getAlbumData(): LiveData<Album> {
        return albumData
    }

    fun insert(album: List<Album>) {
        InsertAlbumListAsyncTask(albumDao).execute(album)
    }

    fun retriveAlbumList() {

        val disposable = apiEndPointInterface.getAlbumList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<List<Album>>(){
                override fun onSuccess(list: List<Album>) {
                    insert(list)
                }
                override fun onError(e: Throwable) {
                }

            })

        compositeDisposable.add(disposable);

    }

    private class InsertAlbumListAsyncTask(albumDao: AlbumDao) : AsyncTask<List<Album>, Unit, Unit>() {
        val albumDao = albumDao

        override fun doInBackground(vararg p0: List<Album>?) {
            albumDao.deleteAll()
            albumDao.insert(p0[0]!!)
        }

    }

}