package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "soulayma",
                        modifier = Modifier.padding(innerPadding)
                    )
                    ImageComposable(modifier= Modifier.padding(innerPadding))
                }
            }
    }
}

@Composable
fun Greeting(name: String , modifier: Modifier = Modifier) {

    Row(
        modifier= modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,

    ){
        Text(
            text = "Hello $name!",
            modifier = modifier

            )
        Text(
            text = "Hello $name!",
            modifier = modifier

        )
        Text(
            text = "Hello $name!",
            modifier = modifier

        )

    }
}

@Composable()
fun GreetingColumn(name: String, modifier:Modifier =Modifier){
    Column(
        modifier= modifier.fillMaxSize(),
        horizontalAlignment =Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,

    ){
        Text(
            text = "Hello $name!",
            modifier = modifier

        )
        Text(
            text = "Hello $name!",
            modifier = modifier

        )



    }
}
@Composable
fun ImageComposable(modifier: Modifier = Modifier)
{

    var spong by remember { mutableStateOf (R.drawable.bob)}
    Column (modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,)  {
        Image(
            painter = painterResource(id=R.drawable.bob),
            contentDescription = null,
            modifier = Modifier.height(200.dp),
            contentScale = ContentScale.Fit,
        )
        Spacer(modifier=modifier.height(16.dp))
        Button(onClick = {

            spong = if (spong == R.drawable.bob) R.drawable.bob2 else R.drawable.bob
        })
        {
          Text(text ="changer image")
        }
    }
    }

    @Preview(showBackground = true)
    @Composable
    fun ImagePreview() {
        MyApplicationTheme {
            ImageComposable()
        }
    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting(name = "soulayma")
    }
}



@Preview(showBackground = true)
@Composable
fun previewColumn() {
    MyApplicationTheme {
        GreetingColumn(name = "soulayma")

        }


    }
}
