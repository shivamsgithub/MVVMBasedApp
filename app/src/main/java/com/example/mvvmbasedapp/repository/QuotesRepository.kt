package com.example.mvvmbasedapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmbasedapp.api.QuoteService
import com.example.mvvmbasedapp.models.QuoteList

class QuotesRepository (private val quoteService: QuoteService){

    private val quoteLiveData = MutableLiveData<QuoteList>()

    val quotes : LiveData<QuoteList>
        get() = quoteLiveData

    suspend fun getQuotes(page : Int){
        val result = quoteService.getQuotes(page)
        if(result?.body() != null){
            quoteLiveData.postValue(result.body())
        }
    }
}