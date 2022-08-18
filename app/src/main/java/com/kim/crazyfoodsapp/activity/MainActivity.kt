package com.kim.crazyfoodsapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kim.crazyfoodsapp.R
import com.kim.crazyfoodsapp.databinding.ActivityMainBinding
import com.kim.crazyfoodsapp.db.MealDatabase
import com.kim.crazyfoodsapp.viewModel.HomeViewModel
import com.kim.crazyfoodsapp.viewModel.HomeViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val viewModel: HomeViewModel by lazy {
        val mealDatabase = MealDatabase.getInstance(this)
        val homeViewModelProviderFactory = HomeViewModelFactory(mealDatabase)
        ViewModelProvider(this, homeViewModelProviderFactory) [HomeViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.btm_nav)
        val navController = Navigation.findNavController(this,R.id.navigation)
        NavigationUI.setupWithNavController(bottomNavigation,navController)


    }
}