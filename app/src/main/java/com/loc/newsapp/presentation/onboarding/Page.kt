package com.loc.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.loc.newsapp.R

//same each screen
data class Page(
    val title:String,
    val description: String,
    @DrawableRes val image: Int
)

//list of pages
val pages = listOf(
    Page(
        title = "Lorem ipsum is simply dumy",
        description = "Lorem pisum is simply dummy text of the painting and type setting endustry",
        image = R.drawable.onboarding1
    ),

    Page(
        title = "Lorem ipsum is simply dumy",
        description = "Lorem pisum is simply dummy text of the painting and type setting endustry",
        image = R.drawable.onboarding2
),

    Page(
        title = "Lorem ipsum is simply dumy",
        description = "Lorem pisum is simply dummy text of the painting and type setting endustry",
        image = R.drawable.onboarding3
    )

)