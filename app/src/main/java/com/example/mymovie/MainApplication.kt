package com.example.mymovie

import android.app.Application
import com.example.mymovie.di.appModule
import com.example.mymovie.di.mapperModule
import com.example.mymovie.di.networkModule
import com.example.mymovie.di.repositoryModule
import com.example.mymovie.di.useCaseModule
import com.example.mymovie.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                listOf(
                    appModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule,
                    mapperModule
                )
            )
        }
    }
}