package com.example.application10.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.application10.databinding.CategoryItemRecyclerRowBinding
import com.example.application10.models.CategoryModels

class CategoryAdapter (private var categoryList : List<CategoryModels>) :
    RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = CategoryItemRecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(categoryList[position])
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    class MyViewHolder(private val binding: CategoryItemRecyclerRowBinding) :
        RecyclerView.ViewHolder(binding.root){
            //bind the date with views
             fun bindData(category : CategoryModels){
                binding.nameTextView.text = category.name

                Glide.with(binding.coverImageView).load(category.Url).into(binding.coverImageView)
             }
        }

}