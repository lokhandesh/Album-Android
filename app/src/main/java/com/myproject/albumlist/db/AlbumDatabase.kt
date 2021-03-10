package com.myproject.albumlist.db


import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.myproject.albumlist.app.MyApp
import com.myproject.albumlist.data.Album
import com.myproject.albumlist.db.dao.AlbumDao

/**
 * Created by Santosh Lokhande 08/03/2021
 *
 * This class has used to instantiate Room Database.
 *
 *
 */

@Database(entities = [Album::class], version = 1)
abstract class AlbumDatabase : RoomDatabase() {

    abstract fun albumDao(): AlbumDao

    companion object {
        private var instance: AlbumDatabase? = null

        fun  getInstance(): AlbumDatabase? {
            if (instance == null) {
                synchronized(AlbumDatabase::class) {
                    instance = Room.databaseBuilder(
                            MyApp.getInstance()!!,
                        AlbumDatabase::class.java, "album_database"
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(roomCallback).allowMainThreadQueries()
                        .build()
                }
            }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }

        private val roomCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
            }
        }

    }

}