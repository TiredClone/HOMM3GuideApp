package com.neolife.homm3guide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.neolife.homm3guide.database.DBHelper
import com.neolife.homm3guide.screen.home.HMM3CardList
import com.neolife.homm3guide.screen.home.HomeScreen
import com.neolife.homm3guide.ui.theme.HOMM3GuideTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var db = DBHelper(this);
        setContent {
            HOMM3GuideTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(db)
                }
            }
        }
    }
}


