package com.example.task2

import android.app.Application
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

object MainApp : Application() {
    val executorService: ExecutorService = Executors.newSingleThreadExecutor()
}