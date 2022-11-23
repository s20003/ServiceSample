package jp.ac.it_college.std.s20003.servicesample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jp.ac.it_college.std.s20003.servicesample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btPlay.setOnClickListener {
            val intent = Intent(this@MainActivity, SoundManageService::class.java)
            startService(intent)
            binding.btPlay.isEnabled = false
            binding.btStop.isEnabled = true
        }
        binding.btStop.setOnClickListener {
            val intent = Intent(this@MainActivity, SoundManageService::class.java)
            stopService(intent)
            binding.btPlay.isEnabled = true
            binding.btStop.isEnabled = false
        }

        val fromNotification = intent.getBooleanExtra("fromNotification", false)
        if (fromNotification) {
            binding.btPlay.isEnabled = false
            binding.btStop.isEnabled = true
        }
    }
}