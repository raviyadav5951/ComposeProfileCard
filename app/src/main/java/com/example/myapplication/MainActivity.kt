@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MainScreen()
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun MainScreen(userProfiles:List<UserProfile> = userProfileList) {

    Scaffold( topBar = { AppBar()})
    {innerPadding ->
        Column(
        modifier = Modifier
            .padding(innerPadding),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.LightGray) {
//                Column {
//
//                    for(userProfile in userProfiles)
//
//                        ProfileCard(userProfile)
//                    //ProfileCard(userProfileList[1])
//                }

                LazyColumn{
                    items(userProfiles){
                        userProfile->
                        ProfileCard(userProfile = userProfile)
                    }
                }



            }
    }

    }


}

@Composable
fun AppBar(){
        TopAppBar(

            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            title = {
                Text("Top app bar")
            },
            navigationIcon = {Icon(Icons.Default.Home,"home icon")}
        )

}

@Composable
fun ProfileCard(userProfile: UserProfile){
    Card(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(align = Alignment.Top)
        .padding(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {

        Row (modifier = Modifier.wrapContentSize(),
            verticalAlignment =Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start){

            ProfilePicture(status = userProfile.status, imageRes = userProfile.resourceId)
            ProfileContent(name = userProfile.name,onlineStatus = userProfile.status)
        }

    }
}

@Composable
fun ProfileContent(name:String,onlineStatus:Boolean) {
    Column(modifier= Modifier
        .fillMaxWidth()
        .padding(8.dp),) {
        Text(text = name,
            style=MaterialTheme.typography.headlineMedium)

        Text(modifier = Modifier.alpha(0.5f),text =
         if(onlineStatus)
        "Active now"
            else "offline",
            style=MaterialTheme.typography.bodyMedium)

    }


}

@Composable
fun ProfilePicture(status:Boolean,imageRes:String) {
    Card(shape = CircleShape,
        modifier=Modifier.padding(10.dp),
        border = BorderStroke(width=1.dp,
            color = if(status)
                Color.Green
        else Color.Red),
    ) {
//        Image(painter = painterResource(id=imageRes) ,
//            contentDescription = "profile pic",
//            modifier = Modifier.size(72.dp),
//            contentScale = ContentScale.Crop)


//        AsyncImage(
//            //model ="https://randomuser.me/api/portraits/men/32.jpg",
//            model=imageRes,
//            contentDescription = "test",
//            modifier = Modifier.size(72.dp),
//            contentScale = ContentScale.Crop)
//        
        
        Image(painter =
        rememberAsyncImagePainter(model = imageRes), contentDescription = "profile",
            modifier = Modifier.size(72.dp),
            contentScale = ContentScale.Crop)
        
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        MainScreen()
    }
}