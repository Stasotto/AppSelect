package com.example.appselect.presentation

import com.example.appselect.domain.models.MovieDomain
import com.example.appselect.presentation.models.Movie

fun MovieDomain.toMovie() = Movie(
    name = name,
    description = description,
    imageUrl = imageUrl
)