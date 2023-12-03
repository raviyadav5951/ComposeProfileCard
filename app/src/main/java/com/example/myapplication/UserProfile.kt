package com.example.myapplication


data class UserProfile constructor(
    val id: Int, val name: String, val status: Boolean, val resourceId: String
)


val userProfileList = arrayListOf<UserProfile>(
    UserProfile(
        id = 1, name = "John Doe", status = false, "https://randomuser.me/api/portraits/men/32.jpg"
    ), UserProfile(
        id = 2,
        name = "The Professor",
        status = true,
        "https://randomuser.me/api/portraits/men/33.jpg"
    ), UserProfile(
        id = 3, name = "John Doe", status = false, "https://randomuser.me/api/portraits/men/34.jpg"
    ), UserProfile(
        id = 4,
        name = "Spider Man ",
        status = true,
        "https://randomuser.me/api/portraits/men/35.jpg"
    ), UserProfile(
        id = 5, name = "Bat Man", status = false, "https://randomuser.me/api/portraits/men/36.jpg"
    ), UserProfile(
        id = 6, name = "Hulk", status = true, "https://randomuser.me/api/portraits/men/37.jpg"
    ), UserProfile(
        id = 7, name = "Ant Man", status = false, "https://randomuser.me/api/portraits/men/38.jpg"
    ), UserProfile(
        id = 8,
        name = "The Expendables", status = true, "https://randomuser.me/api/portraits/men/39.jpg",
    ), UserProfile(
        id = 9,
        name = "Iron Man", status = false, "https://randomuser.me/api/portraits/men/40.jpg",
    )
)
