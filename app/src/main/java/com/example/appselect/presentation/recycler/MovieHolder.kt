package com.example.appselect.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appselect.R
import com.example.appselect.databinding.ItemMovieBinding
import com.example.appselect.presentation.models.Movie

class MovieHolder(item: View) : RecyclerView.ViewHolder(item) {

    companion object {
        fun from(parent: ViewGroup) = MovieHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        )
    }

    private val binding by lazy { ItemMovieBinding.bind(item) }

    fun bind(movie: Movie) = with(binding) {
        name.text = movie.name
        description.text = movie.description
        loadImage(movie.imageUrl)


    }

    private fun loadImage(url: String) {
        Glide.with(binding.image.context)
            .load(url)
            .into(binding.image)
    }

}