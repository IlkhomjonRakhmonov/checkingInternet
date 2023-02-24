package uz.rakhmonov.checkinginternet

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import uz.rakhmonov.checkinginternet.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding :ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCheck.setOnClickListener {
            if (hasConnection(binding.root.context)){
                binding.tvMavjudEmas.text = "internet mavjud"
            } else{
                binding.tvMavjudEmas.text = "mavjud emas"


            }
        }


    }
    fun hasConnection(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        if (wifiInfo != null && wifiInfo.isConnected) {
            return true
        }
        wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
        if (wifiInfo != null && wifiInfo.isConnected) {
            return true
        }
        wifiInfo = cm.activeNetworkInfo
        return (wifiInfo != null) && wifiInfo.isConnected
    }
}