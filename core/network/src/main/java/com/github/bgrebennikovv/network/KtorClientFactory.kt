package com.github.bgrebennikovv.network

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import java.util.concurrent.TimeUnit

object KtorClientFactory {

    fun create(): HttpClient {
        return HttpClient(OkHttp){
            engine {
                config {
                    connectTimeout(15, TimeUnit.SECONDS)
                    readTimeout(15, TimeUnit.SECONDS)
                    writeTimeout(15, TimeUnit.SECONDS)
                }
            }

            install(ContentNegotiation){
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                })
            }

            install(Logging){
                logger = object : Logger{
                    override fun log(message: String) {
                        Log.d("KtorNetwork", message)
                    }
                }
                level = LogLevel.ALL
            }
        }
    }
}