package com.example.chucknorrisjokes.View

import JokeViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorrisjokes.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: JokeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(JokeViewModel::class.java)
        val textViewJoke: TextView = findViewById(R.id.jokeLabel)
        val buttonNewJoke: FloatingActionButton = findViewById(R.id.button)

        viewModel.jokeLiveData.observe(this, Observer { joke ->
            textViewJoke.text = joke.value
        })

        viewModel.fetchRandomJoke()


        buttonNewJoke.setOnClickListener {
            viewModel.fetchRandomJoke()
        }
    }
}