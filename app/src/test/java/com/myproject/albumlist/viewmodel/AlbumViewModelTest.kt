package com.myproject.albumlist.viewmodel

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.myproject.albumlist.AlbumDaoFake
import com.myproject.albumlist.AlbumDatabaseFake
import com.myproject.albumlist.base.BaseUTTest
import com.myproject.albumlist.data.Album
import com.myproject.albumlist.injection.component.AppInjector
import com.myproject.albumlist.repository.AlbumRepository
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class AlbumViewModelTest : BaseUTTest(){

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var application: Application

    @Mock
    lateinit var albumViewModel: AlbumViewModel

    @Mock
    lateinit var albumRepository: AlbumRepository

    @Mock
    lateinit var album: Album

    @Mock
    lateinit var appComponent: AppInjector

    private lateinit var albumList: List<Album>

    private lateinit var albumDaoFake: AlbumDaoFake

    private  val albumDatabaseFake = AlbumDatabaseFake()

    private lateinit var emptyAlbumList: List<Album>

    @Mock
    private lateinit var mockRepository: AlbumRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
       // this.albumViewModel = AlbumViewModel()
        albumDaoFake = AlbumDaoFake(albumDatabaseFake)
        mockData()
        mockDataWithEmptyList();
    }

    @Test
    fun `get album title with empty feild, returns empty`() {
        var albumList = emptyAlbumList
        assertNotNull(emptyAlbumList)
        assertEquals(0,emptyAlbumList.size)
    }

    @Test
    fun get_album_data_response() {
        assertNotNull(albumList)
        var actual = albumList.get(0).title.startsWith("q")
        assertEquals(true,actual)
    }

    @Test
    fun getAllAlbumTitle() {
        var albumList = albumList //= albumViewModel.getAllAlbumTitle()
        assertNotNull(albumList)
        var actual = albumList.get(0).title.startsWith("q")
        assertEquals(true,actual)
    }

    @Test
    fun `album list size should be 3`() {
        var albumList = albumList
        assertNotNull(albumList)
        assertEquals(3,albumList.size)

    }

    private fun mockData() {
        val mockList : MutableList<Album> = mutableListOf()
        mockList.add(Album(1,1,"quidem molestiae enim"))
        mockList.add(Album(2,2,"sunt qui excepturi placeat culpa"))
        mockList.add(Album(3,3,"omnis laborum odio"))
        albumList = mockList.toList()
    }

    private fun mockDataWithEmptyList() {
        val mockList : MutableList<Album> = mutableListOf()
        emptyAlbumList = mockList.toList()
    }

}