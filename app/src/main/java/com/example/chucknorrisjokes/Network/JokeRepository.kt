package com.example.chucknorrisjokes.Network

import com.example.chucknorrisjokes.Model.Joke
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokeRepository {
    private val apiService: JokeApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(JokeApiService::class.java)
    }

    suspend fun getRandomJoke(): Joke? {
        val response = apiService.getRandomJoke()
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }
}
