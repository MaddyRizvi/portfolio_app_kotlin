package com.example.bizzcardapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bizzcardapp.ui.theme.BizzCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BizzCardAppTheme {
                CreateBizCard()
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

   @Composable
   fun CreateBizCard(){
       val buttonClickedState = remember {
           mutableStateOf(false)
       }
       Surface(modifier = Modifier
           .fillMaxWidth()
           .fillMaxHeight()
       ) {
           Card (
               modifier = Modifier
                   .width(200.dp)
                   .height(390.dp)
                   .padding(12.dp),
               shape = RoundedCornerShape(corner = CornerSize(15.dp)),
               colors = CardDefaults.cardColors(
                   containerColor = Color.White
               ),
               elevation = CardDefaults.cardElevation(4.dp)){
               Column (
                   modifier = Modifier
                       .fillMaxHeight()
                       .fillMaxWidth(),
                   verticalArrangement = Arrangement.Top,
                   horizontalAlignment = Alignment.CenterHorizontally)
               {
                   CreateProfileImage()
                   HorizontalDivider()
                   CreateInfo()

                   Button(
                       onClick = {
                           buttonClickedState.value = !buttonClickedState.value
                   }
                   ) {
                       Text(text = "Portfolio",
                           style= MaterialTheme.typography.labelSmall )
                   }
                   if (buttonClickedState.value){
                       Content()
                   }else{
                       Box(){

                       }
                   }
               }
           }
       }



   } // end of CreateBizCard()

@Preview(showBackground = true)
@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(5.dp)) {
        Surface (modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp,
                color = Color.LightGray))
        {
            portfolio(data = listOf("Project 1",
                "Project 2", "Project 3", "Project 4", "Project 5"))
        }
    }
}

@Composable
fun portfolio(data: List<String>) {
    LazyColumn () {
        items(data){item ->
            Card (modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
                shape = RectangleShape,
                elevation = CardDefaults.cardElevation(4.dp)){
                Row(modifier = Modifier
                    .padding(8.dp)
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(7.dp)) {
                    CreateProfileImage(modifier = Modifier.size(100.dp))
                    Column (
                        modifier = Modifier
                            .padding(7.dp)
                            .align(alignment = Alignment.CenterVertically))
                    {
                        Text(text = item,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(1.dp))
                        Text(text = "A Great Project",
                            style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}


@Composable
private fun CreateInfo(){
    Column {
        Text(text = "Syed Rizvi",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.inversePrimary,
            modifier = Modifier.padding(5.dp))

        Text(text = "Android Programmer",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.bodyLarge)
    }
}
@Composable
private fun CreateProfileImage(modifier: Modifier = Modifier){
    Surface(modifier = modifier
        .size(150.dp)
        .padding(10.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 4.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)){
        Image(painter = painterResource(id = R.drawable.profile),
            contentDescription = "profile image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop)
    }
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BizzCardAppTheme {
        CreateBizCard()
    }
}