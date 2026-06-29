package com.github.bgrebennikovv.network

import org.koin.dsl.module

val networkModule = module {
    single {
        KtorClientFactory.create()
    }
}