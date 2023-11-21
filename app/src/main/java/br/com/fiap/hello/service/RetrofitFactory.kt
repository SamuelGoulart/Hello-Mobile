package br.com.fiap.hello.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val BASE_URL = "http://192.168.3.3:8080/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun authService(): UserService {
        return retrofitFactory.create(UserService::class.java)
    }

    fun announcementService(): AnnouncementService {
        return retrofitFactory.create(AnnouncementService::class.java)
    }
}