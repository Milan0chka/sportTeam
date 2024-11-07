package com.example.sportteamapplication.data

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.example.sportteamapplication.R


data class TeamInfo(
    val title: String,
    val image: Int,
    val text: String,
)

val teamInformations = listOf(
    TeamInfo(
        title = "History of the club",
        image = R.drawable.teamhistory_0,
        text = "Founded in 1927, FC Dynamo Kyiv is one of Ukraine’s most iconic football clubs, representing both the spirit of Kyiv and the resilience of Ukrainian people. The club gained early recognition in the 1930s and stood out as a strong contender within the Soviet Union, becoming a beloved symbol for its fans."
    ),
    TeamInfo(
        title = "Playing style",
        image = R.drawable.teamstyle_0,
        text = "Dynamo Kyiv is renowned for its attacking style of play combined with strong discipline in defense. The influence of legendary coach Valeriy Lobanovskyi is still felt in the club’s playing philosophy, with an emphasis on tactical awareness, fitness, and teamwork."
    ),
    TeamInfo(
        title = "Community and Impact",
        image = R.drawable.teamimpact_0,
        text = "Dynamo Kyiv is more than just a football club; it plays an important role in the local community. The club runs several youth academies, helping develop young talent and promoting health and fitness among the youth of Kyiv and Ukraine."
    ),
)