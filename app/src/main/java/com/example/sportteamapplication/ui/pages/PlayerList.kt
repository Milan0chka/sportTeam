import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.sportteamapplication.R
import com.example.sportteamapplication.data.players
import com.example.sportteamapplication.data.Player
import com.example.sportteamapplication.data.favouritePlayers
import com.example.sportteamapplication.ui.Screen

// Function to display the player list using a grid layout
@Composable
fun PlayerList(
    navHostController: NavHostController,
    innerPaddingValues: PaddingValues
) {
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
        items(players) { player ->
            PlayerCard(
                player = player,
                navHostController = navHostController,
                onClick = {
                    if (player in favouritePlayers) {
                        favouritePlayers.remove(player)
                    } else {
                        favouritePlayers.add(player)
                    }
                }
            )
        }
    }
}

// Function to display each player's card
@Composable
fun PlayerCard(
    player: Player,
    navHostController: NavHostController,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val isFavourite = player in favouritePlayers

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                onClick = { navHostController.navigate(Screen.PlayerDetails.createRoute(player.name)) }
            ),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Box(
            modifier = modifier.height(255.dp),
            contentAlignment = Alignment.Center
        ) {
            DisplayPlayerImage(imageLink = player.image, desc = player.name)
            AddGradient()
            DisplayPlayerName(name = player.name)

            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DisplayPlayerNumber(player.number)
                AddToFavouriteButton(isFavourite = isFavourite, onClick = onClick)
            }
        }
    }
}

// Function to display the player's image
@Composable
fun DisplayPlayerImage(
    imageLink: String,
    desc: String
) {
    AsyncImage(
        model = imageLink,
        contentDescription = desc,
        contentScale = ContentScale.Fit,
        error = painterResource(R.drawable.error_placeholder),
        modifier = Modifier.fillMaxSize()
    )
}

// Function to add a gradient effect over the player card image
@Composable
fun AddGradient() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                // Vertical gradient with transparency at the top
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        MaterialTheme.colorScheme.primary
                    ),
                    endY = 900f
                )
            )
    ) {}
}

// Function to display the player's name at the bottom
@Composable
fun DisplayPlayerName(
    name: String
) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.BottomStart
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.displayMedium,
            maxLines = 2
        )
    }
}

// Function to display the player's number
@Composable
fun DisplayPlayerNumber(
    number: Int
) {
    Text(
        text = "№${number}",
        style = MaterialTheme.typography.displaySmall,
        color = MaterialTheme.colorScheme.tertiary
    )
}

// Function to add/remove a player from favorites and animate the button when clicked
@Composable
fun AddToFavouriteButton(
    isFavourite: Boolean,
    onClick: () -> Unit
) {
    // Scale the icon slightly when the player is in favorites
    val scale by animateFloatAsState(
        targetValue = if (isFavourite) 1.2f else 1f,
        animationSpec = tween(durationMillis = 200)
    )

    Icon(
        imageVector = if (isFavourite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
        contentDescription = if (isFavourite) "Remove from favourite" else "Add to favourite",
        tint = MaterialTheme.colorScheme.secondary,
        modifier = Modifier
            .scale(scale)
            .padding(4.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() }, // No ripple effect
                indication = null,
                onClick = onClick
            )
    )
}
