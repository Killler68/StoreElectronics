package com.example.storeelectronicsproject.common.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.storeelectronicsproject.homestore.FragmentHomeStore
import com.example.storeelectronicsproject.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigateToFragmentActivity(FragmentHomeStore())
    }
}