package com.myproject.albumlist.injection.component

import android.app.Application
import com.myproject.albumlist.app.MyApp
import com.myproject.albumlist.injection.module.NetworkModule
import com.myproject.albumlist.repository.AlbumRepository
import com.myproject.albumlist.viewmodel.AlbumViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface AppInjector {
    /**
     * Injects required dependencies into the specified AlbumViewModel.
     * @param albumViewModel AlbumViewModel in which to inject the dependencies
     */
    fun inject(albumViewModel: AlbumViewModel)

    fun inject(myApp: MyApp)

    fun inject(albumRepository: AlbumRepository)

    @Component.Builder
    interface Builder {
        fun build(): AppInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}