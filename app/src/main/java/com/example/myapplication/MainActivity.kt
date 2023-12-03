@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.rememberAsyncImagePainter
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                UsersApplicationNavigation(userProfiles = userProfileList)
            }
        }
    }
}

@Composable
fun UsersApplicationNavigation(userProfiles: List<UserProfile>) {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = "users_list"
    ) {
        composable("users_list") { UserListScreen(userProfiles, navController) }
        composable(route="users_detail/{user_id}",
            arguments = listOf(navArgument("user_id"){
                type= NavType.IntType
            })
        ) {navBackstackEntry->

            UserDetailScreen(navBackstackEntry.arguments!!.getInt("user_id"))
        }/*...*/
    }
}

@ExperimentalMaterial3Api
@Composable
fun UserListScreen(userProfiles: List<UserProfile>, navController: NavController?) {

    Scaffold(topBar = { AppBar() }) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.LightGray) {

                //Approach 1:
                LazyColumn {
                    items(userProfiles) { userProfile ->
                        //last lambda so directly using curly braces
                        ProfileCard(userProfile = userProfile) {
                            navController?.navigate("users_detail/${userProfile.id}")
                        }

                    }
                }

                //Approach 2: we can also pass the position as arguments by replacing
                //Get the position in arguments and load detail screen based on list[position]
                //to display the detail screen content

               /* LazyColumn {
                    itemsIndexed(userProfiles) { index, userProfile ->
                        ProfileCard(userProfile = userProfile) {
                            navController?.navigate("users_detail/${index}")
                        }
                    }
                }*/

            }
        }

    }

}


@Composable
fun AppBar() {
    TopAppBar(

        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ), title = {
            Text("Top app bar")
        }, navigationIcon = { Icon(Icons.Default.Home, "home icon") })

}

@Composable
fun ProfileCard(userProfile: UserProfile, clickAction: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .padding(8.dp)
            .clickable(onClick = { clickAction.invoke() }),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {

        Row(
            modifier = Modifier.wrapContentSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            ProfilePicture(
                status = userProfile.status, imageRes = userProfile.resourceId, imageSize = 72.dp
            )
            ProfileContent(name = userProfile.name, onlineStatus = userProfile.status)
        }

    }
}

@Composable
fun ProfileContent(name: String, onlineStatus: Boolean) {
    Column(
        modifier = Modifier.padding(8.dp),
    ) {
        Text(
            text = name, style = MaterialTheme.typography.headlineMedium
        )

        Text(
            modifier = Modifier.alpha(0.5f), text = if (onlineStatus) "Active now"
            else "Offline", style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun ProfilePicture(status: Boolean, imageRes: String, imageSize: Dp) {
    Card(
        shape = CircleShape,
        modifier = Modifier.padding(10.dp),
        border = BorderStroke(
            width = 1.dp, color = if (status) Color.Green
            else Color.Red
        ),
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

        Image(
            painter = rememberAsyncImagePainter(model = imageRes),
            contentDescription = "profile",
            modifier = Modifier.size(imageSize),
            contentScale = ContentScale.Crop
        )

    }

}

@ExperimentalMaterial3Api
@Composable
fun UserDetailScreen(userId:Int) {
    //from the list fetching the matching id for accessing the object of userProfile
    val userProfile= userProfileList.first { userProfile ->userId==userProfile.id  }

    Scaffold(topBar = { AppBar() }) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.LightGray) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {

                    ProfilePicture(
                        status = userProfile.status,
                        imageRes = userProfile.resourceId,
                        imageSize = 240.dp
                    )
                    ProfileContent(name = userProfile.name, onlineStatus = userProfile.status)
                }


            }
        }

    }


}

@Preview(showBackground = true)
@Composable
fun UserListPreview() {
    MyApplicationTheme {
        UserListScreen(userProfileList, null)
    }
}

@Preview(showBackground = true)
@Composable
fun UserDetailPreview() {
    MyApplicationTheme {
        UserDetailScreen(0)
    }
}

