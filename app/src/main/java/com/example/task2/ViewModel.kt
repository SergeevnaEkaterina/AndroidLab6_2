package com.example.task2

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.net.URL
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivityViewModel : ViewModel() {
    var executorService: ExecutorService = Executors.newSingleThreadExecutor()
    val bitmapData = MutableLiveData<Bitmap>()

 fun load(name: String) {

    executorService.execute {
        URL(name)
            .openConnection().getInputStream().use {
                val bitmap = BitmapFactory.decodeStream(it)
                bitmapData.postValue(bitmap)
            }
        Log.i("thread of picture loading", "${Thread.currentThread()}")
    }

}
    override fun onCleared() {
        executorService.shutdown()
        super.onCleared()
    }

}