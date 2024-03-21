package com.neolife.homm3guide.screen.post

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.neolife.homm3guide.R
import com.neolife.homm3guide.database.DBHelper
import dev.jeziellago.compose.markdowntext.MarkdownText

@Composable
fun postScreen(navController: NavController, db: DBHelper, postId: Int) {
    val scrollState = rememberScrollState()
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .padding(top = 30.dp)
            .verticalScroll(state = scrollState)
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
        Row() {
            Text(
                text = db.getPostById(postId).name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }
    }
    Column(modifier = Modifier.padding(top = 75.dp)) {
        MarkdownText(
            markdown = db.getPostById(postId).text,
            style = TextStyle(
                color = Color.Black,
                fontSize = 20.sp,
                background = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 10.dp)

        )
    }
}
