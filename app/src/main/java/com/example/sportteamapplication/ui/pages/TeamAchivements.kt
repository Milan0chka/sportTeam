package com.example.sportteamapplication.ui.pages

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.sportteamapplication.R
import com.example.sportteamapplication.data.TeamAchievement
import com.example.sportteamapplication.data.teamAchievements

// Displays a list of achievements in chronological order
@Composable
fun TeamAchievement(
    navHostController: NavHostController,
    innerPaddingValues: PaddingValues
) {
    LazyColumn(
        modifier = Modifier
            .padding(innerPaddingValues)
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            item{
                Text(
                    text = "Learn about Dynamo Kyiv`s achievements in chronological order",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center
                )
                StartPoint()
            }
            items(teamAchievements.reversed()) { achievement ->
                AchievementInfo(achievement)
            }
            item {
                EndPoint()
            }
        }
    )
}

// Displays individual achievement info with expandable details
@Composable
fun AchievementInfo(achievement: TeamAchievement) {
    var isExpanded by remember { mutableStateOf(false) }
    val animatedHeight by animateDpAsState(targetValue = if (isExpanded) 700.dp else 80.dp)

    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier.fillMaxWidth()
    ) {
        Timeline(animatedHeight = animatedHeight)
        AchievementCard(
            achievement = achievement,
            isExpanded = isExpanded,
            animatedHeight = animatedHeight,
            onClick = { isExpanded = !isExpanded }
        )
    }
}

// Draws the timeline line and icon
@Composable
fun Timeline(animatedHeight: Dp) {
    Box(
        modifier = Modifier
            .width(40.dp)
            .fillMaxHeight(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxHeight()
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .width(2.dp)
                    .height(30.dp)
                    .background(MaterialTheme.colorScheme.tertiary)
            )
            Icon(
                painter = painterResource(R.drawable.cirle_icon),
                contentDescription = "Achievement",
                tint = MaterialTheme.colorScheme.onBackground
            )
            Box(
                modifier = Modifier
                    .width(2.dp)
                    .height(animatedHeight - 35.dp)
                    .background(MaterialTheme.colorScheme.tertiary)
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

// Displays the expandable card for each achievement
@Composable
fun AchievementCard(
    achievement: TeamAchievement,
    isExpanded: Boolean,
    animatedHeight: Dp,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(end = 10.dp)
            .fillMaxWidth()
            .height(animatedHeight)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiary)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "${achievement.date}", style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.onTertiary)
            Text(text = achievement.title, style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)

            // Display the achievement details only when expanded
            AnimatedVisibility(visible = isExpanded) {
                AchievementDetails(achievement = achievement)
            }
        }
    }
}

// Shows detailed information about the achievement including an image and description
@Composable
fun AchievementDetails(achievement: TeamAchievement) {
    Column(
        modifier = Modifier
            .padding(top = 10.dp)
            .clip(RoundedCornerShape(15.dp))
            .border(2.dp, MaterialTheme.colorScheme.secondary, shape = RoundedCornerShape(15.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier.height(200.dp),
            model = achievement.image,
            contentDescription = achievement.title,
            contentScale = ContentScale.Crop,
            error = painterResource(R.drawable.error_placeholder)
        )
        Text(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary)
                .padding(10.dp),
            text = achievement.desc,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Justify,
            overflow = TextOverflow.Ellipsis
        )
    }
}

// Display the timeline's ending point
@Composable
fun EndPoint() {
    Box(
        modifier = Modifier.fillMaxSize().padding(start = 2.25.dp).offset(y = (-30).dp),
    ) {
        Icon(
            painter = painterResource(R.drawable.end_line_icon),
            contentDescription = "End point",
            tint = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier.rotate(90f),
        )
    }
}

// Display the timeline's starting point
@Composable
fun StartPoint() {
    Box(
        modifier = Modifier.fillMaxSize().padding(start = 2.25.dp).offset(y = 10.dp),
    ) {
        Icon(
            painter = painterResource(R.drawable.start_line_icon),
            contentDescription = "Start point",
            tint = MaterialTheme.colorScheme.tertiary,
        )
    }
}
