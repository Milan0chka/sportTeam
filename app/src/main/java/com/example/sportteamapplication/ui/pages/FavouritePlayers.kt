package com.example.sportteamapplication.ui.pages

import PlayerCard
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.sportteamapplication.R
import com.example.sportteamapplication.data.favouritePlayers

// Shows a list of favourite players or a prompt if empty
@Composable
fun FavouritePlayers(
    navHostController: NavHostController,
    innerPaddingValues: PaddingValues
) {
    if (favouritePlayers.isEmpty())
        EmptyFavouritePrompt()
    else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(innerPaddingValues)
                .fillMaxHeight()
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background),
            contentPadding = PaddingValues(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(favouritePlayers) { player ->
                PlayerCard(
                    player = player,
                    navHostController = navHostController,
                    onClick = {
                        favouritePlayers.remove(player)
                    }
                )
            }
        }
    }
}

// Displays a message when there are no favourite players
@Composable
fun EmptyFavouritePrompt(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Oops",
            style = MaterialTheme.typography.displayMedium
        )
        Text(
            text = "You have not added any players to favourites yet!",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
        Image(
            painter = painterResource(R.drawable.error_image),
            contentDescription = "meow", // Fun image description
            modifier = Modifier
                .padding(10.dp)
                .size(200.dp)
        )
    }
}
