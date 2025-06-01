package com.app.imageslider

data class Products(
    val name: String,
    val price: String,
    val imageUrls: List<String>,
    var isFavorite: Boolean = false
)
