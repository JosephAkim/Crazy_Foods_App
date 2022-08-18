package com.kim.crazyfoodsapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kim.crazyfoodsapp.databinding.MealItemBinding
import com.kim.crazyfoodsapp.pojo.MealsByCategory

class CategoryMealsAdapter : RecyclerView.Adapter<CategoryMealsAdapter.CategoryMealViewHolder>() {
    private var mealList = ArrayList<MealsByCategory>()

    fun setMealsList(mealsList: List<MealsByCategory>){
        this.mealList = mealsList as ArrayList<MealsByCategory>
        notifyDataSetChanged()
    }

    inner class CategoryMealViewHolder(val binding: MealItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryMealViewHolder {
        return CategoryMealViewHolder(
            MealItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryMealViewHolder, position: Int) {
        Glide.with(holder.itemView).load(mealList[position].strMealThumb).into(holder.binding.imgMeal)
    }

    override fun getItemCount(): Int {
        return mealList.size
    }

}