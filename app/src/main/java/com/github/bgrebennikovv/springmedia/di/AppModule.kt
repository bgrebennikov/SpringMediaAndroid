package com.github.bgrebennikovv.springmedia.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.dsl.module


val appModule = module {
    single {
        HttpClient(OkHttp) {

        }
    }
}