package com.example.myapplication



data class UserProfile constructor(val name:String,val status:Boolean,val resourceId:String)


val userProfileList= arrayListOf<UserProfile>(
    UserProfile(name = "John Doe",status = false,"https://randomuser.me/api/portraits/men/32.jpg"),
    UserProfile(name = "The Professor",status = true,"https://randomuser.me/api/portraits/men/33.jpg"),
    UserProfile(name = "John Doe",status = false,"https://randomuser.me/api/portraits/men/34.jpg"),
    UserProfile(name = "Spider Man ",status = true,"https://randomuser.me/api/portraits/men/35.jpg"),
    UserProfile(name = "Bat Man",status = false,"https://randomuser.me/api/portraits/men/36.jpg"),
    UserProfile(name = "Hulk",status = true,"https://randomuser.me/api/portraits/men/37.jpg"),
    UserProfile(name = "Ant Man",status = false,"https://randomuser.me/api/portraits/men/38.jpg"),
    UserProfile(name = "The Expendables",status = true,"https://randomuser.me/api/portraits/men/39.jpg"),
    UserProfile(name = "Iron Man",status = false,"https://randomuser.me/api/portraits/men/40.jpg"),
    UserProfile(name = "The Professor",status = true,"https://randomuser.me/api/portraits/men/41.jpg"),
    UserProfile(name = "John Doe",status = false,"https://randomuser.me/api/portraits/men/42.jpg"),
    UserProfile(name = "The Professor",status = true,"https://randomuser.me/api/portraits/men/43.jpg"),
    UserProfile(name = "John Doe",status = false,"https://randomuser.me/api/portraits/men/44.jpg"),
    UserProfile(name = "The Professor",status = true,"https://randomuser.me/api/portraits/men/45.jpg"),
    UserProfile(name = "John Doe",status = false,"https://randomuser.me/api/portraits/men/46.jpg"),
    UserProfile(name = "Spider Man ",status = true,"https://randomuser.me/api/portraits/men/47.jpg"),
    UserProfile(name = "Bat Man",status = false,"https://randomuser.me/api/portraits/men/48.jpg"),
    UserProfile(name = "Hulk",status = true,"https://randomuser.me/api/portraits/men/49.jpg"),
    UserProfile(name = "Ant Man",status = false,"https://randomuser.me/api/portraits/men/50.jpg"),
    UserProfile(name = "The Expendables",status = true,"https://randomuser.me/api/portraits/men/51.jpg"),
    UserProfile(name = "Iron Man",status = false,"https://randomuser.me/api/portraits/men/52.jpg"),
    UserProfile(name = "The Professor",status = true,"https://randomuser.me/api/portraits/men/53.jpg"),
    UserProfile(name = "John Doe",status = false,"https://randomuser.me/api/portraits/men/54.jpg"),
    UserProfile(name = "The Professor",status = true,"https://randomuser.me/api/portraits/men/55.jpg")
)
