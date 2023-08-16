package com.example.chucknorrisjokes.View

import JokeViewModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
        val buttonShare: Button = findViewById(R.id.buttonShare)

        viewModel.jokeLiveData.observe(this, Observer { joke ->
            textViewJoke.text = joke.value
        })

        viewModel.fetchRandomJoke()


        // Button New Joke onclick
        buttonNewJoke.setOnClickListener {
            viewModel.fetchRandomJoke()
        }

        // Button Share onclick
        buttonShare.setOnClickListener {
            val jokeText = textViewJoke.text.toString()
            shareJoke(jokeText)
        }
    }

    private fun shareJoke(jokeText: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, jokeText)
        startActivity(Intent.createChooser(intent, "Share Joke"))
    }
}