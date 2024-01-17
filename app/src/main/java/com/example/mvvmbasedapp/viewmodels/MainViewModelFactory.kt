package com.example.mvvmbasedapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmbasedapp.repository.QuotesRepository

class MainViewModelFactory(private  val repository: QuotesRepository) : ViewModelProvider.Factory {
    override fun <T: ViewModel> create (modelclass : Class<T>) : T{
        return MainViewModel (repository) as T
    }
}