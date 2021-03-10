package com.myproject.albumlist.adapter

import android.content.Context
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.myproject.albumlist.R
import com.myproject.albumlist.data.Album
import kotlin.collections.ArrayList


/**
 * Created by Santosh Lokhande on 08/3/2021
 *
 * This class is used to display item of Album.
 *
 * @param Context
 *
 * Here we used ViewHolder design pattern
 *
 */

class AlbumAdapter(val applicationContext: Context) : RecyclerView.Adapter<AlbumAdapter.AlbumHolder>() {

    private var albumList: List<Album> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.album_item, parent, false)

        return AlbumHolder(itemView)
    }

    override fun onBindViewHolder(holder: AlbumHolder, position: Int) {

        val currentAlbum = albumList[position]
        holder.textViewTitle.text = currentAlbum.title

    }

    override fun getItemCount(): Int {
        return albumList.size
    }

    fun setBooks(list: List<Album>) {
        this.albumList = list.sortedBy { list -> list.title }
        notifyDataSetChanged()
    }

    class AlbumHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textViewTitle: TextView = itemView.findViewById(R.id.text_view_title)
        var card_view : CardView = itemView.findViewById(R.id.card_view);

    }

}
