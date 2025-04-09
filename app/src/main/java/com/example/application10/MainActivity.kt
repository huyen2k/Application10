package com.example.application10

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.application10.adapter.CategoryAdapter
import com.example.application10.databinding.ActivityMainBinding
import com.example.application10.databinding.CategoryItemRecyclerRowBinding
import com.example.application10.models.CategoryModels
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var categoryAdapter: CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getCategories()
    }

    fun getCategories(){
        FirebaseFirestore.getInstance().collection("Category")
            .get().addOnSuccessListener {
                val categoryList = it.toObjects(CategoryModels::class.java)
                setupCategoryRecycleView(categoryList)
            }
    }

    fun setupCategoryRecycleView(categoryList: List<CategoryModels>){
        categoryAdapter = CategoryAdapter(categoryList)
        binding.categoriesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.categoriesRecyclerView.adapter = categoryAdapter
    }
}