package com.neolife.homm3guide.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.neolife.homm3guide.R
import com.neolife.homm3guide.screen.Screen

@Composable
fun HomeScreen(navController: NavController){
    Row (horizontalArrangement = Arrangement.End,
        modifier = Modifier.padding(top = 30.dp)){

        Text(
            text = "HOMM3 Guides",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(end = 50.dp)
        )

        TextButton(
            onClick = {
                navController.navigate(Screen.SettingsScreen.route)
            },
            shape = CircleShape,

            ) {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = stringResource(id = R.string.settings_button),
                modifier = Modifier.size(30.dp, 30.dp)
            )
        }
    }
}