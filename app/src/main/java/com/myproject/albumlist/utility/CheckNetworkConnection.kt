package com.myproject.albumlist.utility

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo


/**
 * Created by Santosh Lokhande on 08/3/2021
 *
 * Here we can check Network connection of your mobile
 *
 *
 */

@Suppress("DEPRECATION")
object  CheckNetworkConnection {

         fun isConnectingToInternet(context: Context): Boolean {
            val connectivity = context.getSystemService(
                Context.CONNECTIVITY_SERVICE) as ConnectivityManager
             val info = connectivity.allNetworkInfo
             for (i in info)
                 if (i.state == NetworkInfo.State.CONNECTED) {
                     return true
                 }
             return false
        }

}