package com.neolife.homm3guide.screen.post

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.neolife.homm3guide.R
import com.neolife.homm3guide.database.DBHelper
import dev.jeziellago.compose.markdowntext.MarkdownText

@Composable
fun postScreen(navController: NavController, db: DBHelper, postId: Int) {
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.padding(top = 30.dp)
    ) {

        TextButton(
            onClick = {
                navController.popBackStack()
            },
            shape = CircleShape,


            ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = stringResource(id = R.string.arrow_button),
                modifier = Modifier.size(30.dp, 30.dp)
            )
        }

        Text(
            text = db.getPostById(postId).name,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(start = 90.dp)
        )
    }
    Column (modifier = Modifier.padding(top = 75.dp)){
        MarkdownText(
            markdown = db.getPostById(postId).text,
            style = TextStyle(
                color = Color.White,
                fontSize = 20.sp,
                background = Color.Transparent
            ),
            modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(start = 5.dp, end = 5.dp)

        )
    }
}
