package com.neolife.homm3guide.screen.aboutCreator

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.neolife.homm3guide.R
import com.neolife.homm3guide.screen.Screen

@Composable
fun AboutAppCreatorScreen(navController: NavController) {
    val localUriHandler = LocalUriHandler.current
    Row (horizontalArrangement = Arrangement.Start,
        modifier = Modifier.padding(top = 30.dp)){

        TextButton(
            onClick = {navController.popBackStack()},
            shape = CircleShape,

            ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = stringResource(id = R.string.arrow_button),
                modifier = Modifier.size(30.dp, 30.dp)
            )
        }
        Text(
            text = "About app creator",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(start = 30.dp)
        )
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(top = 40.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 60.dp)
                .fillMaxSize()
        ) {
            Image(
                painterResource(id = R.drawable.avatar),
                contentDescription = stringResource(id = R.string.avatar_description),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(180.dp)
                    .clip(CircleShape)
                    .clickable {
                        localUriHandler.openUri("https://natribu.org/")
                    })
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Neo_Life",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 30.dp)
                )

                Text(
                    textAlign = TextAlign.Center,
                    text = "Creator",
                    fontSize = 20.sp,
                    modifier = Modifier.clickable {
                        localUriHandler.openUri("https://www.youtube.com/watch?v=9j4HJp-AsOo")
                    })
            }
        }
    }
}
