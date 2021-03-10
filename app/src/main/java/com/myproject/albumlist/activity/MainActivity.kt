package com.myproject.albumlist.activity

import androidx.lifecycle.Observer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.ActionBar
import android.widget.*
import androidx.lifecycle.ViewModelProviders
import com.myproject.albumlist.adapter.AlbumAdapter
import com.myproject.albumlist.data.Album
import com.myproject.albumlist.viewmodel.AlbumViewModel
import com.myproject.albumlist.utility.CheckNetworkConnection
import android.graphics.Color
import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.myproject.albumlist.R


/**
 * Created by Santosh Lokhande on 08/3/2021.
 *
 * This is main activity which interact with user.
 *
 * Here we have used AlbumAdapter to display Album title.
 *
 */


class MainActivity : AppCompatActivity() {

    lateinit var progressBar: ProgressBar
    lateinit var parentCoordinate:ConstraintLayout
    private lateinit var albumViewModel: AlbumViewModel
    private val adapter = AlbumAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setCustomView(R.layout.header);
        albumViewModel = ViewModelProviders.of(this).get(AlbumViewModel::class.java)

        initUi()

        albumViewModel.getAllAlbumTitle().observe(this,
                Observer<List<Album>> { t ->
                    Log.d("MainActivity","Observer")
                    adapter.setBooks(t!!)
                    progressBar.visibility=View.INVISIBLE
                })
    }

    fun initUi(){

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        progressBar = findViewById(R.id.progressBar)
        parentCoordinate = findViewById(R.id.parentLayout)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        if (CheckNetworkConnection.isConnectingToInternet(this)){
            progressBar.visibility=View.VISIBLE
            albumViewModel.retriveAlbumList();
        }else{
            val snackbar = Snackbar
                .make(parentCoordinate, "Required internet to fetch updated album", Snackbar.LENGTH_LONG)
            snackbar.setActionTextColor(Color.RED)
            snackbar.show()
        }

    }
}