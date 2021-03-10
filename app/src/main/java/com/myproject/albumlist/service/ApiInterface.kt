package com.myproject.albumlist.service

import com.myproject.albumlist.data.Album
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Santosh Lokhande on 08/3/2021
 */

interface ApiInterface {

    @GET("albums/")
    fun getAlbumList(): Single<List<Album>>

    @GET("albums/{album_id}/")
    fun getAlbumByAlbumId(@Path("album_id")id: Int): Single<Album>


}