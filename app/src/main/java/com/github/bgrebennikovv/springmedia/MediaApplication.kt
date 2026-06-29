package com.github.bgrebennikovv.springmedia

import android.app.Application
import com.github.bgrebennikovv.network.networkModule
import com.github.bgrebennikovv.springmedia.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MediaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@MediaApplication)
            modules(
                appModule,
                networkModule
            )
        }
    }
}