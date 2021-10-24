package com.livedataexample

import androidx.annotation.DrawableRes

data class Student(
    @DrawableRes val picture: Int,
    val name: String,
    val id : Int,
    val subjects: List<String>
)