package com.example.myapplication


data class UserProfile constructor(val name:String,val status:Boolean,val resourceId:Int)


val userProfileList= arrayListOf<UserProfile>(
    UserProfile(name = "John Doe",status = false,R.drawable.images),
    UserProfile(name = "The Professor",status = true,R.drawable.images)
)
