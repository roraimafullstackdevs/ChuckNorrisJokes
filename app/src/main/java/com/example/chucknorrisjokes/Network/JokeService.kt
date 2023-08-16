package com.example.chucknorrisjokes.Network


import retrofit2.Response
import retrofit2.http.GET
import com.example.chucknorrisjokes.Model.Joke
interface JokeApiService {
    @GET("jokes/random")
    suspend fun getRandomJoke(): Response<Joke>
}
