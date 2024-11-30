package com.example.myapplication

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlin.coroutines.coroutineContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Portfolio ()
            }
        }
    }
}



@Composable
fun Portfolio () {

    val isOpen = remember {
        mutableStateOf(false)
    }

   Surface(
       tonalElevation = 8.dp , shape = RoundedCornerShape(12.dp),
       color = MaterialTheme.colorScheme.background ,
       modifier = Modifier
           .fillMaxWidth()
           .padding(12.dp)
   ) {


       Column(
           horizontalAlignment = Alignment.CenterHorizontally,
           modifier = Modifier.padding(12.dp)
       ) {


          Box(modifier = Modifier
              .size(60.dp)
              .border(
                  color = Color.Black,
                  width = 2.dp,
                  shape = CircleShape
              ),
              contentAlignment = Alignment.Center

          ) {

              Image(painter = painterResource(id = R.drawable.user),
                  contentDescription = "user icon",
                  modifier = Modifier.fillMaxSize())

          }

           Spacer(modifier = Modifier.height(4.dp))
           Divider()
           Spacer(modifier = Modifier.height(4.dp))


           Text(text = "बल्लू बदमाश", style = TextStyle(
               color = Color.Red , fontSize = 20.sp , fontWeight = FontWeight.Bold)
           )

           Text(text = "Android Compose Developer", style = MaterialTheme.typography.bodySmall,
               color = Color.Black)
           Spacer(modifier = Modifier.height(12.dp))



           Row {

           Image(painter = painterResource(id = R.drawable.instagram),
               contentDescription = "instagram" ,
               modifier = Modifier.size(18.dp))

               Text(text = "/बल्लूAndroid", style = MaterialTheme.typography.labelSmall,
                   modifier = Modifier.padding(horizontal = 8.dp))
           }

           Spacer(modifier = Modifier.height(4.dp))

           Row {

               Image(painter = painterResource(id = R.drawable.github2),
                   contentDescription = "github" ,
                   modifier = Modifier.size(18.dp))

               Text(text = "/बल्लूAndroid2804", style = MaterialTheme.typography.labelSmall,
                   modifier = Modifier.padding(horizontal = 8.dp))
           }

           Spacer(modifier = Modifier.height(12.dp))

           Button( onClick = { isOpen.value = !isOpen.value }) {

               Text(text = "My Project")
               
           }

           if(isOpen.value){

               LazyColumn {

                   items(getProjectList()) {
                       ProjectItem(project = it)
                   }


               }

           }



       }


   }
}


@Preview(showBackground = true)
@Composable
fun PortfolioPreview() {
   Portfolio()
}

// holds the data to be loaded (blueprint for the data)
data class Project (
    val name : String ,
    val desc : String
)


// data in the form of list using data class (Project)
fun getProjectList () : List<Project>  {
    return listOf(
        Project(name = "Social Media App", desc = "Connect with your friends"),
        Project(name = "Media Player App", desc = "Listen music endlessly"),
        Project(name = "Gaming Media", desc = "God of war Ragnarok lover"),
        Project(name = "Social Media App", desc = "Connect with your friends"),
        Project(name = "Media Player App", desc = "Listen music endlessly"),
        Project(name = "Gaming Media", desc = "God of war Ragnarok lover"),
        Project(name = "Social Media App", desc = "Connect with your friends"),
        Project(name = "Media Player App", desc = "Listen music endlessly"),
        Project(name = "Gaming Media", desc = "God of war Ragnarok lover"),
        Project(name = "Social Media App", desc = "Connect with your friends"),
        Project(name = "Media Player App", desc = "Listen music endlessly"),
        Project(name = "Gaming Media", desc = "God of war Ragnarok lover"),
        )
}

@Composable
fun ProjectItem(project : Project) {

    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.user), contentDescription = "user projects"
        , modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
        
        Column(
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            Text(text = project.name , style = MaterialTheme.typography.titleMedium)
            Text(text = project.desc , style = MaterialTheme.typography.bodySmall)

        }
    }
}
