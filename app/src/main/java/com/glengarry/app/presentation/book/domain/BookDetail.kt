package com.glengarry.app.presentation.book.domain

data class BookDetail(
    val id: String = "",
    val img: String = "...",
    val label: List<String> = emptyList(),
    val price: Double = 0.0,
    val name: String = "",
    val rating: Double = 0.0,
    val detailProduct: String = "",
    val description: String = "",
)
