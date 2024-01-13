package com.example.healthyapp.Domain

import java.io.Serializable

class ItemsDomain(
    val imgPath: String,
    val title: String,
    val price: Double,
    val description: String,
    val rate: Int
) : Serializable