package com.example.manor_f12023

import android.app.Application
import com.example.manor_f12023.database.F1Repository

class F1Application : Application() {
    override fun onCreate() {
        super.onCreate()
        F1Repository.initialize(this)
    }
}