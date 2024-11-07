package com.example.sportteamapplication.data

import androidx.compose.runtime.mutableStateListOf
import com.example.sportteamapplication.R

data class Player (
    val name: String,
    val image: String,
    val personalNote: String? = null, // New attribute replacing "video"
    val dateOfBirth: String,
    val position: String,
    val number: Int,
    val goals: Int,
    val careerStartYear: Int,
    val bio: String,
    val biggestHighlight: String
)

val players = listOf(
    Player(
        name = "Heorhiy Bushchan",
        image = "https://fcdynamo.com/img/img/match_center/players/90/bushchan44.png",
        personalNote = "Heorhiy Bushchan has a keen interest in chess, which he credits for his improved strategic thinking on the field. He also enjoys reading historical fiction in his spare time.",
        dateOfBirth = "1994-05-31",
        position = "Goalkeeper",
        number = 1,
        goals = 0,
        careerStartYear = 2012,
        bio = "Heorhiy Bushchan is Dynamo Kyiv’s first-choice goalkeeper, known for his quick reflexes and strong presence in the box. Over the years, he has developed into one of the top keepers in Ukraine. His composure in high-pressure situations has earned him accolades from fans and pundits alike.",
        biggestHighlight = "Bushchan's most notable highlight came during the 2020 UEFA Champions League group stage, where he delivered a stellar performance against Barcelona, making a series of key saves."
    ),
    Player(
        name = "Kostyantun Vivcharenko",
        image = "https://fcdynamo.com/img/img/match_center/players/558/vivcharenko44.png",
        dateOfBirth = "2001-06-10",
        position = "Defender",
        number = 2,
        goals = 3,
        careerStartYear = 2019,
        bio = "Kostyantun Vivcharenko is a rising talent in Dynamo Kyiv’s defense. He has made significant strides since breaking into the first team, showcasing excellent tackling and positional awareness. Despite his young age, he has become a regular starter and a fan favorite.",
        biggestHighlight = "Vivcharenko’s breakout moment came during the 2022 Ukrainian Cup final, where his goal helped secure a victory for Dynamo Kyiv. His contribution in defense and attack stood out in that crucial match."
    ),
    Player(
        name = "Denys Popovov",
        image = "https://fcdynamo.com/img/img/match_center/players/464/popov44.png",
        personalNote = "Denys is passionate about cooking and often shares his culinary creations on social media. He believes that cooking helps him unwind after intense matches and keeps his mind clear.",
        dateOfBirth = "1999-02-17",
        position = "Defender",
        number = 4,
        goals = 5,
        careerStartYear = 2018,
        bio = "Denys Popov is a powerhouse in defense, known for his physical strength and aerial ability. He is a constant threat during set pieces, both defensively and offensively. His commanding presence at the back has made him a key player for both Dynamo Kyiv and the Ukraine national team.",
        biggestHighlight = "Popov’s standout moment was during Ukraine’s U20 World Cup campaign in 2019, where he scored crucial goals, including one in the final that helped Ukraine lift the trophy."
    ),
    Player(
        name = "Volodymyr Brazhko",
        image = "https://fcdynamo.com/img/img/match_center/players/569/brazhko44.png",
        personalNote = "Volodymyr finds relaxation in painting landscapes, a hobby he developed to help him unwind and focus before big games. His artwork has even been displayed at local exhibitions.",
        dateOfBirth = "2002-01-23",
        position = "Midfielder",
        number = 6,
        goals = 2,
        careerStartYear = 2020,
        bio = "Volodymyr Brazhko is a tireless midfielder with great vision and passing ability. He is known for his work rate and ability to cover large areas of the pitch. Brazhko has been a vital cog in Dynamo’s midfield since his debut, impressing with his technical skills.",
        biggestHighlight = "His first professional goal in 2021 was a key moment in Dynamo’s title chase, cementing his place in the starting lineup."
    ),
    Player(
        name = "Andriy Yarmolenko",
        image = "https://fcdynamo.com/img/img/match_center/players/30/yarmolenko55.png",
        personalNote = "Andriy is fluent in four languages: Ukrainian, Russian, English, and Spanish. He often acts as a translator for international teammates, helping them adapt to life in Kyiv.",
        dateOfBirth = "1989-10-23",
        position = "Midfielder",
        number = 7,
        goals = 140,
        careerStartYear = 2007,
        bio = "Andriy Yarmolenko is a Dynamo Kyiv legend, renowned for his dribbling, powerful left foot, and ability to score from long range. His leadership on the field has guided Dynamo through numerous campaigns, and his name is etched in the club’s history as one of its greatest players.",
        biggestHighlight = "Yarmolenko's long career includes multiple league titles and unforgettable moments, but his highlight would be scoring over 100 goals for Dynamo, making him one of the top scorers in the club's history."
    ),
    Player(
        name = "Volodymyr Shepelev",
        image = "https://fcdynamo.com/img/img/match_center/players/423/shepelev44.png",
        personalNote = "Volodymyr has a passion for collecting vintage cars, with his collection considered one of the finest among Ukrainian athletes. He is especially proud of his rare 1967 Mustang.",
        dateOfBirth = "1997-06-01",
        position = "Midfielder",
        number = 8,
        goals = 10,
        careerStartYear = 2015,
        bio = "Volodymyr Shepelev is a central midfielder known for his precise passing and tactical intelligence. He has been a consistent performer for Dynamo Kyiv, helping orchestrate play from deep positions and contributing both defensively and offensively.",
        biggestHighlight = "Shepelev's best moment came during the 2018-2019 season, where his performances in midfield helped Dynamo win the Ukrainian Cup."
    ),
    Player(
        name = "Nazar Voloshyn",
        image = "https://fcdynamo.com/img/img/match_center/players/590/voloshyn44.png",
        dateOfBirth = "2000-09-16",
        position = "Midfielder",
        number = 9,
        goals = 4,
        careerStartYear = 2018,
        bio = "Nazar Voloshyn is a dynamic midfielder with an eye for goal. His ability to break through defensive lines and create chances has made him a key figure in Dynamo’s attack. Known for his speed and technical ability, Voloshyn is a promising talent in Ukrainian football.",
        biggestHighlight = "In 2020, Voloshyn scored a crucial goal in a heated derby against Shakhtar Donetsk, solidifying his place in the first team."
    ),
    Player(
        name = "Mykola Shaparenko",
        image = "https://fcdynamo.com/img/img/match_center/players/447/shaparenko44.png",
        personalNote = "Mykola is an accomplished pianist and regularly performs at charity events. He finds that playing the piano helps him stay calm under pressure, both on and off the field.",
        dateOfBirth = "1998-10-04",
        position = "Midfielder",
        number = 10,
        goals = 8,
        careerStartYear = 2017,
        bio = "Mykola Shaparenko is known for his creativity and flair in midfield. His ability to drive forward with the ball and score from distance has made him a key player for Dynamo Kyiv and the Ukrainian national team. Shaparenko’s vision and passing make him a dangerous playmaker.",
        biggestHighlight = "Scoring a stunning goal against Bayern Munich in the UEFA Champions League group stage in 2021."
    ),
    Player(
        name = "Vladyslav Vanat",
        image = "https://fcdynamo.com/img/img/match_center/players/561/vanat44.png",
        personalNote = "Vladyslav is an avid hiker and spends much of his off-season exploring the Carpathian Mountains. He believes being in nature recharges him for the long football season.",
        dateOfBirth = "2002-04-24",
        position = "Forward",
        number = 11,
        goals = 12,
        careerStartYear = 2021,
        bio = "Vladyslav Vanat is a young and energetic forward known for his clinical finishing and intelligent movement in the box. Since breaking into the first team, he has quickly established himself as one of Dynamo’s most promising strikers.",
        biggestHighlight = "Vanat’s hat-trick against Zorya Luhansk in 2021 was a career-defining performance, showcasing his potential as a top forward."
    ),
    Player(
        name = "Ruslan Nescheret",
        image = "https://fcdynamo.com/img/img/match_center/players/539/neshcheret44.png",
        dateOfBirth = "2002-01-22",
        position = "Goalkeeper",
        number = 35,
        goals = 0,
        careerStartYear = 2020,
        bio = "Ruslan Nescheret is a young goalkeeper who has impressed with his agility and shot-stopping ability. Despite his age, he has been given significant responsibility at Dynamo Kyiv, showing maturity beyond his years.",
        biggestHighlight = "Nescheret’s standout performance came in a 2020 UEFA Champions League match against Barcelona, where he made several world-class saves to keep Dynamo in the game."
    ),
    Player(
        name = "Valentyn Rubchinsky",
        image = "https://fcdynamo.com/img/img/match_center/players/745/rubchynskyi44.png",
        dateOfBirth = "2003-07-15",
        position = "Midfield",
        number = 15,
        goals = 1,
        careerStartYear = 2021,
        bio = "Valentyn Rubchinsky is a talented midfielder known for his ability to control the tempo of the game. His composure on the ball and range of passing make him a key player in Dynamo Kyiv’s midfield.",
        biggestHighlight = "Rubchinsky’s first goal for Dynamo came in a vital match against Dnipro-1, where his performance earned him praise from both coaches and fans."
    ),
    Player(
        name = "Eduardo Gerrero",
        image = "https://fcdynamo.com/img/img/match_center/players/756/gerrero.png",
        personalNote = "Eduardo is passionate about photography and often documents Dynamo’s travels with his camera. He dreams of publishing a photo book that captures his football journey.",
        dateOfBirth = "1998-03-21",
        position = "Forward",
        number = 39,
        goals = 7,
        careerStartYear = 2022,
        bio = "Eduardo Gerrero is a dynamic forward with a knack for scoring goals. His pace and dribbling ability make him a constant threat to opposing defenses, and he has quickly become a key player for Dynamo Kyiv.",
        biggestHighlight = "His debut goal for Dynamo in a crucial UEFA Europa League match put his name on the map, showcasing his potential."
    )
)

val favouritePlayers = mutableStateListOf<Player>()
