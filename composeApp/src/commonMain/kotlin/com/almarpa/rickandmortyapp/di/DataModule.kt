package com.almarpa.rickandmortyapp.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import org.koin.core.module.dsl.factoryOf
import com.almarpa.rickandmortyapp.data.remote.ApiService

val dataModule = module {
    single {
        HttpClient {
            install(ContentNegotiation){
                json(json = Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
            }
            install(DefaultRequest){
                url{
                    protocol = URLProtocol.HTTPS
                    host = "rickandmortyapi.com"
                    // parameters.append("key", "") To add API_KEY
                }
            }
        }
    }
    factoryOf(::ApiService)
}