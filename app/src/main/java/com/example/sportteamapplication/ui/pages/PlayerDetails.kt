package com.example.sportteamapplication.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.sportteamapplication.R
import com.example.sportteamapplication.data.Player
import com.example.sportteamapplication.data.players

// Displays player details with header and additional info cards
@Composable
fun PlayerDetails(
    navHostController: NavHostController,
    innerPaddingValues: PaddingValues,
    name: String
) {
    val player = players.first { it.name == name }

    Column(
        modifier = Modifier
            .padding(innerPaddingValues)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PlayerHeader(player)
        PlayerInfoCards(player)
    }
}

// Displays the player header
@Composable
fun PlayerHeader(player: Player) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.2f)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.tertiary
                    )
                )
            )
    ) {
        PlayerNumber(player.number)
        PlayerImage(player)
        GradientOverlay()
        PlayerInfo(player)
    }

    PlayerNameRow(player.name)
}

// Displays the player's number
@Composable
fun PlayerNumber(number: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(end = 15.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Text(
            text = "$number",
            color = MaterialTheme.colorScheme.secondary,
            fontSize = 60.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

// Displays the player's image
@Composable
fun PlayerImage(player: Player) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(end = 20.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        AsyncImage(
            model = player.image,
            contentDescription = player.name,
            contentScale = ContentScale.Fit,
            error = painterResource(R.drawable.error_placeholder)
        )
    }
}

// Adds a gradient overlay to the header
@Composable
fun GradientOverlay() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Transparent,
                        MaterialTheme.colorScheme.tertiary
                    ),
                    endY = 850f
                )
            )
    )
}

// Displays basic player info in a column
@Composable
fun PlayerInfo(player: Player) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.4f)
            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        InfoCard("Position", player.position)
        InfoCard("Date of birth", player.dateOfBirth)
        InfoCard("Career start", "${player.careerStartYear}")
        InfoCard("Goals", "${player.goals}")
    }
}

// Creates a card to show player information
@Composable
fun InfoCard(prompt: String, value: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.surface.copy(alpha = 0.2f),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$prompt:\n$value",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onPrimary,
            textAlign = TextAlign.Center
        )
    }
}

// Displays player's name in a row
@Composable
fun PlayerNameRow(name: String) {
    Row(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondary),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onSecondary
        )
    }
}

// Shows player info cards
@Composable
fun PlayerInfoCards(player: Player) {
    val listState: LazyListState = rememberLazyListState()
    var selectedIndex by remember { mutableStateOf(0) }

    val items = listOfNotNull(
        "Biography" to player.bio,
        "Career highlight" to player.biggestHighlight,
        player.personalNote?.let { "Interesting fact" to it }
    )

    // Track the first visible item index for dot indicator
    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemIndex to listState.firstVisibleItemScrollOffset }
            .collect { (index, offset) ->
                val itemSize = listState.layoutInfo.visibleItemsInfo.firstOrNull()?.size ?: 1
                selectedIndex = if (offset > itemSize / 2 && index < items.size - 1) {
                    index + 1
                } else {
                    index
                }
            }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyRow(
            state = listState,
            modifier = Modifier
                .weight(1f)
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(55.dp),
            contentPadding = PaddingValues(horizontal = 30.dp)
        ) {
            items(items) { item ->
                PlayerInfoCard(title = item.first, info = item.second)
            }
        }

        Row(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, _ ->
                DotIndicator(isSelected = selectedIndex == index)
            }
        }
    }
}

// Creates a card with player information
@Composable
fun PlayerInfoCard(title: String, info: String) {
    Card(
        modifier = Modifier
            .width(350.dp)
            .fillMaxHeight()
            .clip(RoundedCornerShape(16.dp))
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 20.dp, horizontal = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = info,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Justify
            )
        }
    }
}

// Displays a dot in dot indicator
@Composable
fun DotIndicator(isSelected: Boolean) {
    Box(
        modifier = Modifier
            .size(15.dp)
            .padding(4.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(if (isSelected) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.tertiary)
    )
}
