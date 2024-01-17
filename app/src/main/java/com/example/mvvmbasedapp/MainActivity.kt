package com.example.mvvmbasedapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmbasedapp.api.QuoteService
import com.example.mvvmbasedapp.api.RetrofitHelper
import com.example.mvvmbasedapp.repository.QuotesRepository
import com.example.mvvmbasedapp.viewmodels.MainViewModel
import com.example.mvvmbasedapp.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quoteService = RetrofitHelper.getInstance().create(QuoteService :: class.java)
        val repository = QuotesRepository(quoteService)

        mainViewModel = ViewModelProvider(this@MainActivity, MainViewModelFactory(repository)).get(MainViewModel :: class.java)

        mainViewModel.quotes.observe(this, Observer {
            Log.d("Data Test", it.results.toString())
        })
    }

}