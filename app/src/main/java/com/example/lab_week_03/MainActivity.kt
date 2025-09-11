package com.example.lab_week_03

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity(), ListFragment.CoffeeListener {
    private var isTablet: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        isTablet = findViewById<androidx.fragment.app.FragmentContainerView?>(R.id.nav_host_fragment) == null
    }

    override fun onCoffeeSelected(name: String, description: String) {
        if (isTablet) {
            val detailFragment = supportFragmentManager.findFragmentById(R.id.detail_fragment) as DetailFragment
            detailFragment.updateCoffee(name, description)
        } else {
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            val navController = navHostFragment.navController

            val bundle = Bundle().apply {
                putString("name", name)
                putString("description", description)
            }
            navController.navigate(R.id.action_listFragment_to_detailFragment, bundle)
        }
    }
}