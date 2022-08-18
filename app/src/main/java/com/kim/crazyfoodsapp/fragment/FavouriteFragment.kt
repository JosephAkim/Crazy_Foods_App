package com.kim.crazyfoodsapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.kim.crazyfoodsapp.R
import com.kim.crazyfoodsapp.activity.MainActivity
import com.kim.crazyfoodsapp.adapters.FavouriteMealsAdapter
import com.kim.crazyfoodsapp.databinding.FragmentFavouriteBinding
import com.kim.crazyfoodsapp.viewModel.HomeViewModel


class FavouriteFragment : Fragment() {
    private lateinit var binding:FragmentFavouriteBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var favouriteAdapter: FavouriteMealsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (activity as MainActivity).viewModel

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentFavouriteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareRecyclerView()
        observeFavourites()
    }

    private fun prepareRecyclerView() {
        favouriteAdapter = FavouriteMealsAdapter()
        binding.rvFavourites.apply {
            layoutManager = GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false)
            adapter = favouriteAdapter
        }
    }

    private fun observeFavourites() {
        viewModel.observeFavouriteMealsLiveData().observe(requireActivity(), Observer { meals ->
            favouriteAdapter.differ.submitList(meals)

        })
    }

}