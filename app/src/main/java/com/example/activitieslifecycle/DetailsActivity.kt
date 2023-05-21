package com.example.activitieslifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.activitieslifecycle.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i("Log", "Foi criado na segunda " + System.currentTimeMillis())
    }

    override fun onResume() {
        super.onResume()

        Log.i("Log", "Foi resumido na segunda " + System.currentTimeMillis())

        binding.button2.setOnClickListener {
            finish()
        }
    }

    override fun onPause() {
        super.onPause()

        Log.i("Log", "Foi pausado na segunda " + System.currentTimeMillis())
    }

    override fun onStop() {
        super.onStop()

        Log.i("Log", "Foi totalmente pausado na segunda " + System.currentTimeMillis())
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("Log", "Foi totalmente desturido na segunda " + System.currentTimeMillis())
    }
}