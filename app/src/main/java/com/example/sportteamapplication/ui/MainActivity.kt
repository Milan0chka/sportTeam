package com.example.sportteamapplication.ui

import PlayerList
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sportteamapplication.ui.pages.FavouritePlayers
import com.example.sportteamapplication.ui.pages.PlayerDetails
import com.example.sportteamapplication.ui.pages.TeamAchievement
import com.example.sportteamapplication.ui.pages.TeamOverview
import com.example.sportteamapplication.ui.theme.SportTeamApplicationTheme

// Defines the navigation routes in the app
sealed class Screen(val route: String) {
    object Overview : Screen("overview")
    object Achievements : Screen("achievements")
    object PlayerList : Screen("players")
    object Favourite : Screen("favourite_players")
    object PlayerDetails : Screen("details/{name}") {
        fun createRoute(name: String): String {
            return "details/$name"
        }
    }
}

// Defines the data for each bottom navigation item
data class BottomNavItem(
    val title: String,
    val route: String,
    val icon: ImageVector
)

// MainActivity sets the content and initializes the navigation
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SportTeamApplicationTheme {
                val navController = rememberNavController()
                MainScaffold(navController)
            }
        }
    }
}

// Scaffold with top bar, bottom bar, and floating action button
@Composable
fun MainScaffold(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Show floating action button only on certain screens
    val showFAB = currentRoute == Screen.PlayerList.route || currentRoute == Screen.Favourite.route
    val isPlayerPage = currentRoute == Screen.PlayerList.route

    Scaffold(
        topBar = {
            if (currentRoute != null) {
                CustomTopBar(currentRoute)
            }
        },
        bottomBar = { CustomFloatingBottomBar(navController) },
        floatingActionButton = { if (showFAB) { CustomFloatingButton(navController, isPlayerPage) } }
    ) { innerPadding ->
        NavigationSetUp(navController, innerPadding)
    }
}

// Top app bar showing the title depending on the current screen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(screen: String) {
    val title = when (screen) {
        "achievements" -> "Team Achievements"
        "players" -> "Main Team"
        "favourite_players" -> "Your Favourite Players"
        else -> ""
    }

    TopAppBar(
        modifier = Modifier.fillMaxWidth().height(80.dp),
        title = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}

// Bottom bar navigation with icons
@Composable
fun CustomFloatingBottomBar(navController: NavController) {
    val items = listOf(
        BottomNavItem(
            title = "Player List",
            route = Screen.PlayerList.route,
            icon = Icons.Default.Person
        ),
        BottomNavItem(
            title = "Overview",
            route = Screen.Overview.route,
            icon = Icons.Default.Home
        ),
        BottomNavItem(
            title = "Achievements",
            route = Screen.Achievements.route,
            icon = Icons.Default.Star
        )
    )

    Box(
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .height(64.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(50.dp))
                .background(MaterialTheme.colorScheme.tertiary)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Creates clickable navigation items
            items.forEach { item ->
                CustomNavItem(
                    icon = item.icon,
                    label = item.title,
                    onClick = { navController.navigate(item.route) }
                )
            }
        }
    }
}

// Floating action button that toggles between player list and favourite players page
@Composable
fun CustomFloatingButton(
    navController: NavHostController,
    isPlayerPage: Boolean
) {
    FloatingActionButton(
        onClick = {
            if (isPlayerPage) navController.navigate(Screen.Favourite.route)
            else navController.navigate(Screen.PlayerList.route)
        },
        content = {
            val icon = if (isPlayerPage) Icons.Default.Favorite else Icons.Default.Person
            val desc = if (isPlayerPage) "To favourite page" else "To player list page"
            Icon(
                imageVector = icon,
                contentDescription = desc,
                tint = MaterialTheme.colorScheme.onSecondary
            )
        },
        containerColor = MaterialTheme.colorScheme.secondary
    )
}

// Defines each navigation item with an icon and label
@Composable
fun CustomNavItem(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit
) {
    Icon(
        modifier = Modifier
            .size(48.dp)
            .clip(RoundedCornerShape(32.dp))
            .clickable(
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    color = MaterialTheme.colorScheme.secondary,
                    bounded = true
                )
            )
            .padding(8.dp),
        imageVector = icon,
        contentDescription = label,
        tint = MaterialTheme.colorScheme.primary
    )
}

// Handles the navigation between different screens
@Composable
fun NavigationSetUp(navController: NavHostController, innerPaddingValues: PaddingValues) {
    NavHost(navController = navController, startDestination = Screen.Overview.route) {
        composable(Screen.Overview.route) {
            TeamOverview(navController, innerPaddingValues)
        }
        composable(Screen.Achievements.route) {
            TeamAchievement(navController, innerPaddingValues)
        }
        composable(Screen.PlayerList.route) {
            PlayerList(navController, innerPaddingValues)
        }
        composable(Screen.Favourite.route) {
            FavouritePlayers(navController, innerPaddingValues)
        }
        composable(
            Screen.PlayerDetails.route,
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            if (name != null) {
                PlayerDetails(navController, innerPaddingValues, name)
            }
        }
    }
}
