package com.example.a11acdhmwanimation_recycleview_cardview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country(
    val name: String,
    val capital: String,
    val flag: Int
) : Parcelable {
    companion object {
        val listOfCountry: MutableList<Country> = mutableListOf(
            Country("United Kingdom", "London", R.drawable.united_kingdom_flag),
            Country("Germany", "Berlin", R.drawable.germany_flag),
            Country("France", "Paris", R.drawable.france_flag),
            Country("Spain", "Madrid", R.drawable.spain_flag)
        )
    }
}