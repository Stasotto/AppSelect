package com.example.appselect.data

import com.example.appselect.data.models.MovieEntity
import com.example.appselect.data.models.MovieResponse
import com.example.appselect.domain.models.MovieDomain


fun MovieResponse.toListMovieEntity(): List<MovieEntity> {
    return results.map { result ->
        MovieEntity(
            name = result.headline,
            description = result.summary_short,
            imageUrl = result.multimedia.src
        )
    }
}

fun MovieEntity.toMovieDomain() = MovieDomain(
    name = name,
    description = description,
    imageUrl = imageUrl
)