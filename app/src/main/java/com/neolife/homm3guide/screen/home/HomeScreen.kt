package com.neolife.homm3guide.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.neolife.homm3guide.R
import com.neolife.homm3guide.database.DBHelper
import com.neolife.homm3guide.screen.Screen

@Composable
fun HomeScreen(navController: NavController, db: DBHelper){
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

    Column (modifier = Modifier.padding(top = 75.dp)){
        HMM3CardList(db.allCards, navController)

    }
    Row (horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier.padding(end = 20.dp, bottom = 20.dp)){
        ExtendedFloatingActionButton(
            onClick = { /*TODO*/ },
            icon = { Icon(Icons.Filled.Add, "Extended floating action button.") },
            text = { Text(text = "Create post") },
        )
    }




}