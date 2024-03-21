package com.neolife.homm3guide.screen.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
fun SettingsScreen(navController: NavController) {
    Column {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(top = 30.dp)
        ) {

            TextButton(
                onClick = {
                    navController.popBackStack()
                },
                shape = CircleShape
                ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.arrow_button),
                    modifier = Modifier.size(30.dp, 30.dp)
                )
            }

            Text(
                text = "Settings",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 90.dp)
            )
        }
        Column(modifier = Modifier.padding(top = 20.dp, start = 20.dp)) {
            TextButton(
                onClick = {navController.navigate(Screen.TableSettingsScreen.route)}){
                Icon(
                    imageVector = Icons.Filled.Build,
                    contentDescription = stringResource(id = R.string.settings_tables_button),
                    modifier = Modifier.size(32.dp, 32.dp)
                )
                Text(
                    text = "Table settings",
                    modifier = Modifier.padding(start = 10.dp),
                    fontSize = 20.sp
                )
            }
            
            Spacer(modifier = Modifier.padding(10.dp))

            TextButton(
                onClick = {navController.navigate(Screen.AboutAppCreator.route)}){
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = stringResource(id = R.string.about),
                    modifier = Modifier.size(32.dp, 32.dp)
                )
                Text(
                    text = "About",
                    modifier = Modifier.padding(start = 10.dp),
                    fontSize = 20.sp
                )
            }
        }
    }

}


