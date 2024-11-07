package com.example.sportteamapplication.ui.pages

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.sportteamapplication.R
import com.example.sportteamapplication.data.TeamInfo
import com.example.sportteamapplication.data.teamInformations

// Displays the team's overview
@Composable
fun TeamOverview(
    navHostController: NavHostController,
    innerPaddingValues: PaddingValues
) {
    LazyColumn(
        modifier = Modifier
            .padding(innerPaddingValues)
            .fillMaxHeight()
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            item {
                MainImage()
                MainTitle()
                PhotoGallery()
            }
            itemsIndexed(teamInformations) { index, info ->
                InfoSection(info, index % 2 == 0)
            }
        }
    )
}

// Displays the team's logo with
@Composable
fun MainImage() {
    val primaryColor = MaterialTheme.colorScheme.primary
    val borderColor = MaterialTheme.colorScheme.secondary

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(370.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(370.dp)
        ) {
            // Top background bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(primaryColor)
            )

            // Canvas drawing for the custom triangle shapes
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(270.dp)
            ) {
                val width = size.width
                val height = size.height - 20

                // Yellow "triangle" at the bottom
                val yellowTrianglePath = Path().apply {
                    moveTo(0f, 0f)
                    lineTo(width, 0f)
                    lineTo(width, 20f)
                    lineTo(width / 2, height + 20f)
                    lineTo(0f, 20f)
                    close()
                }

                drawPath(
                    path = yellowTrianglePath,
                    color = borderColor,
                    style = Fill
                )

                // Blue triangle at the top
                val blueTrianglePath = Path().apply {
                    moveTo(0f, 0f)
                    lineTo(width, 0f)
                    lineTo(width / 2, height)
                    close()
                }

                drawPath(
                    path = blueTrianglePath,
                    color = primaryColor,
                    style = Fill
                )
            }
        }

        // Display the team's logo
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "logo of Dynamo Kyiv",
            modifier = Modifier
                .size(250.dp)
                .align(Alignment.TopCenter)
                .offset(y = 70.dp)
        )
    }
}

// Displays the team's name and slogan
@Composable
fun MainTitle() {
    Column(
        modifier = Modifier
            .padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("FC Dynamo Kyiv", style = MaterialTheme.typography.displayLarge, color = MaterialTheme.colorScheme.onBackground)
        Text("Legacy of Ukrainian Football", style = MaterialTheme.typography.displayMedium, color = MaterialTheme.colorScheme.tertiary)
    }
}

// Displays a photo gallery in a horizontal scrollable row
@Composable
fun PhotoGallery() {
    val photos = listOf(
        R.drawable.team_0,
        R.drawable.team_1,
        R.drawable.team_2,
        R.drawable.team_3,
        R.drawable.team_4
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(top = 10.dp)
            .background(MaterialTheme.colorScheme.background),
        verticalAlignment = Alignment.CenterVertically
    ) {

        items(photos) { photo ->
            Image(
                painter = painterResource(photo),
                contentDescription = "Team Photo",
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(end = 8.dp)
            )
        }
    }
}

// Displays each section of the team's information with alternating alignment
@Composable
fun InfoSection(
    info: TeamInfo,
    isLeanedRight: Boolean
) {
    var alignment = Alignment.Start
    var container = MaterialTheme.colorScheme.secondary
    var content = MaterialTheme.colorScheme.onSecondary
    if (isLeanedRight) {
        alignment = Alignment.End
        container = MaterialTheme.colorScheme.primary
        content = MaterialTheme.colorScheme.onPrimary
    }

    Column(
        modifier = Modifier
            .padding(
                start = if (alignment == Alignment.Start) 0.dp else 15.dp,
                top = 15.dp,
                end = if (alignment == Alignment.Start) 15.dp else 0.dp,
                bottom = 15.dp
            )
            .fillMaxWidth()
            .background(container)
            .padding(
                start = if (alignment == Alignment.Start) 10.dp else 15.dp,
                top = 15.dp,
                end = if (alignment == Alignment.Start) 15.dp else 10.dp,
                bottom = 15.dp
            ),
        horizontalAlignment = alignment
    ) {
        Text(
            text = info.title,
            style = MaterialTheme.typography.displayMedium,
            color = content
        )

        Image(
            painter = painterResource(info.image),
            contentDescription = info.title,
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )

        Text(
            text = info.text,
            style = MaterialTheme.typography.bodyLarge,
            color = content,
            textAlign = if (alignment == Alignment.Start) TextAlign.Start else TextAlign.End
        )
    }
}
