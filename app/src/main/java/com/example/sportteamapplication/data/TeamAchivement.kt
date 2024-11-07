package com.example.sportteamapplication.data

import com.example.sportteamapplication.R
import java.sql.Date
import java.time.LocalDate

data class TeamAchievement(
    val title:String,
    val date: LocalDate,
    val desc: String,
    val image:String ?= null,
    val location: String ?= null
)

val teamAchievements = listOf(
    TeamAchievement(
        title = "Soviet Top League Champions",
        date = LocalDate.of(1961, 11, 12),
        desc = "Dynamo Kyiv won their first Soviet Top League title in 1961, marking the beginning of their dominance in Soviet football. The 1961 season was a breakthrough for the club, as they managed to outperform some of the strongest teams in the Soviet Union, including Spartak Moscow and CSKA Moscow. Dynamo's success was built on a solid defense, quick counter-attacks, and the leadership of key players like Viktor Kanevskiy and Andriy Biba.\n\nThis victory was significant not only for Dynamo Kyiv but also for Ukrainian football, as it was the first time a team from outside Russia had claimed the Soviet Top League title. The achievement inspired a generation of young Ukrainian footballers and established Dynamo Kyiv as a force to be reckoned with in Soviet football. The 1961 title win was the first of many, as Dynamo went on to become one of the most successful clubs in Soviet history.",
        image = "https://fcdynamo.com/img/content/histories/53/9999.jpg?fm=jpg&q=80&fit=max&crop=1024%2C649%2C0%2C0",
        location = "Kyiv, Ukraine"
    ),
    TeamAchievement(
        title = "UEFA Cup Winners' Cup",
        date = LocalDate.of(1975, 5, 14),
        desc = "Dynamo Kyiv achieved its first major European success by winning the UEFA Cup Winners' Cup in the 1974–75 season. Under the guidance of legendary coach Valeriy Lobanovskyi, the team demonstrated a remarkable blend of discipline, tactical astuteness, and individual brilliance. They faced Hungarian club Ferencvárosi TC in the final, defeating them convincingly with a 3-0 scoreline. Goals from Volodymyr Onyshchenko and Oleh Blokhin sealed the victory, showcasing Dynamo's attacking prowess and solid defense.\n\nThis victory marked a turning point for Soviet football on the European stage, as Dynamo Kyiv became the first team from the Soviet Union to win a major European trophy. The triumph not only brought glory to the club but also boosted the reputation of Ukrainian football across Europe. The win laid the foundation for future successes and established Dynamo Kyiv as a dominant force in European competitions.",
        image = "https://fcdynamo.com/img/content/histories/67/1601946198.jpg?fm=jpg&q=80&fit=max&crop=400%2C268%2C0%2C0",
        location = "Basel, Switzerland"
    ),
    TeamAchievement(
        title = "UEFA Cup Winners' Cup",
        date = LocalDate.of(1986, 5, 2),
        desc = "In 1986, Dynamo Kyiv once again triumphed in the UEFA Cup Winners' Cup, showcasing their resilience and tactical prowess. Led by coach Valeriy Lobanovskyi, the team delivered a series of outstanding performances throughout the tournament, culminating in a 3-0 victory over Atlético Madrid in the final. Goals from Aleksandr Zavarov, Oleh Blokhin, and Vadym Yevtushenko sealed the win, as Dynamo dominated the match from start to finish.\n\nThis victory was a testament to Lobanovskyi's innovative coaching methods, which emphasized physical conditioning, teamwork, and data-driven tactics. The 1985–86 UEFA Cup Winners' Cup win solidified Dynamo Kyiv's reputation as one of the premier clubs in Europe and further highlighted the strength of Soviet football. The triumph was celebrated by fans across Ukraine, and it remains one of the most cherished moments in the club's storied history.",
        image = "https://fcdynamo.com/img/0a4019c6-5af7-4ce9-99b0-4e79c8fab7fa/152063401662209852.jpg?fm=jpg&q=80&fit=max&crop=986%2C554%2C0%2C0",
        location = "Lyon, France"
    ),
    TeamAchievement(
        title = "Ukrainian Super Cup Winners",
        date = LocalDate.of(2019, 7, 28),
        desc = "Dynamo Kyiv claimed the Ukrainian Super Cup in 2019, defeating Shakhtar Donetsk 2-1 in a thrilling encounter. The match, held in Odessa, saw Dynamo take an early lead through a goal by Mykyta Burda, with Shakhtar equalizing shortly after. However, Dynamo's young star Denys Harmash scored the winning goal in the second half, securing the Super Cup for Kyiv.\n\nThe victory was significant as it set the tone for the upcoming season and demonstrated Dynamo's ability to compete with their fierce rivals. The Super Cup win was a morale booster for the players and fans alike, and it showcased the emerging talent within the squad. It also marked the beginning of a new chapter for Dynamo Kyiv under the guidance of coach Oleksiy Mykhaylychenko, who aimed to bring more silverware to the club.",
        image = "https://fcdynamo.com/img/content/histories/158/123.jpg?fm=jpg&q=80&fit=max&crop=1500%2C1000%2C0%2C0",
        location = "Odessa, Ukraine"
    ),
    TeamAchievement(
        title = "Ukrainian League Champions",
        date = LocalDate.of(2021, 5, 9),
        desc = "Dynamo Kyiv reclaimed the Ukrainian Premier League title in the 2020–21 season, ending a five-year dominance by their rivals Shakhtar Donetsk. Under the leadership of coach Mircea Lucescu, Dynamo displayed consistent performances throughout the season, with a solid defense and an effective attack led by players such as Viktor Tsyhankov and Carlos De Pena. The team secured the title with several games to spare, finishing the season 11 points ahead of Shakhtar.\n\nThe 2020–21 title was particularly significant as it marked Mircea Lucescu's first season in charge of Dynamo Kyiv, and his appointment had initially been met with skepticism due to his previous association with Shakhtar. However, Lucescu's experience and tactical acumen proved crucial in guiding Dynamo back to the top of Ukrainian football. The title win was celebrated by fans as a symbol of the club's resilience and determination to regain their place at the pinnacle of Ukrainian football.",
        image = "",
        location = "Kyiv, Ukraine"
    ),
    TeamAchievement(
        title = "Ukrainian Cup Winners",
        date = LocalDate.of(2021, 5, 13),
        desc = "Dynamo Kyiv added another domestic trophy by winning the Ukrainian Cup in the 2020–21 season. The team faced Zorya Luhansk in the final, and after a tightly contested match, Dynamo emerged victorious with a 1-0 win, thanks to a late goal by Viktor Tsyhankov. The victory secured Dynamo's second trophy of the season, completing a domestic double.\n\nThe Ukrainian Cup win was a testament to Dynamo Kyiv's determination and fighting spirit, as they overcame several tough opponents on their way to the final. Coach Mircea Lucescu's tactical approach once again proved effective, and the players demonstrated their ability to perform under pressure. The victory was celebrated by fans across Ukraine, as Dynamo reestablished themselves as the dominant force in Ukrainian football.",
        image = "https://fcdynamo.com/img/content/histories/131/vas-8756.jpg?fm=jpg&q=80&fit=max&crop=1500%2C1000%2C0%2C0",
        location = "Kyiv, Ukraine"
    )
)