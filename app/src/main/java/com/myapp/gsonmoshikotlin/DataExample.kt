package com.myapp.gsonmoshikotlin

import kotlinx.serialization.Serializable


@Serializable
data class DataExample(
    val _id: String,
    val about: String,
    val address: String,
    val age: Int,
    val balance: String,
    val company: String,
    val email: String,
    val eyeColor: String,
    val gender: String,
    val guid: String,
    val index: Int,
    val isActive: Boolean,
    val latitude: Double,
    val longitude: Double,
    val name: String,
    val phone: String,
    val picture: String,
    val registered: String
)