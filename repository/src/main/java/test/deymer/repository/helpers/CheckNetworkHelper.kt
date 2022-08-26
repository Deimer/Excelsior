package test.deymer.repository.helpers

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import javax.inject.Inject

class CheckNetworkHelper @Inject constructor(
    private val context: Context
) {

    fun isDeviceOnline(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        return if(capabilities != null) {
            if(capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                println("Connected via: Cellular Network")
                true
            } else if(capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                println("Connected via: WiFi Network")
                true
            } else {
                false
            }
        } else false
    }
}