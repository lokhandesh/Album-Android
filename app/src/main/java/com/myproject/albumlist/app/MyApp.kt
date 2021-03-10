package com.myproject.albumlist.app

import android.app.Application
import com.myproject.albumlist.injection.component.AppInjector
import com.myproject.albumlist.injection.component.DaggerAppInjector
import com.myproject.albumlist.injection.module.NetworkModule
import javax.inject.Inject

class MyApp : Application() {

    lateinit var appComponent: AppInjector

    override fun onCreate() {
        super.onCreate()
        myAppInstance = this

        initDaggerAppComponent()

        appComponent.inject(this)

    }

    companion object {
        private var myAppInstance: MyApp? = null
        fun  getInstance(): MyApp? {
            if (myAppInstance == null) {
                myAppInstance = MyApp()
            }
            return myAppInstance
        }

    }

     private fun initDaggerAppComponent() {
         appComponent = DaggerAppInjector.builder()
             .networkModule(NetworkModule)
             .build()
     }

    fun getDaggerComponent() : AppInjector {
        return appComponent;
    }


}