package com.example.recycleviewwithkotlin


import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var products : ArrayList<Product>
    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var users: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        initArrayOfProducts()
        intiArrayOfUsers()
        recyclerView = findViewById(R.id.RecycleViewId)
        productsAdapter = ProductsAdapter(products,users)
        recyclerView.adapter = productsAdapter
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }

    private fun initArrayOfProducts(){
        products = ArrayList<Product>()
        for(i in 1..10) {
            products.add(Product(i,
                "Product " + i,
                i + 10,
                i * 10 + 500))
        }
    }
    private fun intiArrayOfUsers(){
        users= ArrayList<User>()
        for(i in 1..10){
            users.add(User(i,i,"User "+ i))
        }
    }
}