package com.neolife.homm3guide.screen.home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.neolife.homm3guide.database.CardInfoModel
import com.neolife.homm3guide.screen.Screen

@Composable
fun HMM3Card(
    data: CardInfoModel, navController: NavController
) {
    Card(modifier = Modifier
        .fillMaxWidth().
        padding(start = 5.dp, end = 5.dp, top = 8.dp).
        height(90.dp)
            .clickable { navController.navigate("postScreen/"+ data.post_id) }) {
        Text(text = data.name,
            fontSize = 32.sp,
            modifier = Modifier
                .padding(8.dp),
            textAlign = TextAlign.Center,)
        Text(text = data.caption,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(8.dp),)
    }
}