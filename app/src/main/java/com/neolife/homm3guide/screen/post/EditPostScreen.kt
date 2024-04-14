package com.neolife.homm3guide.screen.post

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.neolife.homm3guide.R
import com.neolife.homm3guide.database.DBHelper
import com.neolife.homm3guide.screen.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun editPostScreen(navController: NavController, db: DBHelper, postId: Int?) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = if (postId == null) "Create post" else "Edit post",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.settings_button),
                            modifier = Modifier.size(30.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues) // This will add padding to the top bar
                .padding(10.dp), // This will add padding to the content
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.padding(10.dp, 0.dp, 10.dp, 10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val name = remember {
                    mutableStateOf("")
                }

                val noImported = remember {
                    mutableStateOf(true)
                }

                val caption = remember {
                    mutableStateOf("")
                }

                val headerText = remember {
                    mutableStateOf("")
                }

                val markdownText = remember {
                    mutableStateOf("")
                }

                if (postId != null && noImported.value) {
                    val post = db.getPostById(postId);
                    val card = db.getCardById(postId);
                    name.value = card.name;
                    caption.value = card.caption;
                    headerText.value = post.name;
                    markdownText.value = post.text;
                    noImported.value = false;
                }


                TextField(
                    label = { Text(text = "Name of Post") },
                    value = name.value,
                    onValueChange = { name.value = it }
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    label = { Text(text = "Description") },
                    value = caption.value,
                    onValueChange = { caption.value = it }
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    label = { Text(text = "Header of post") },
                    value = headerText.value,
                    onValueChange = { headerText.value = it }
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    label = { Text(text = "Markdown text") },
                    modifier = Modifier.size(400.dp),
                    value = markdownText.value,
                    onValueChange = { markdownText.value = it }
                )


                Spacer(modifier = Modifier.height(15.dp))

                Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                    Button(
                        onClick = {
                            if (postId == null) {
                                db.createCardAndPost(
                                    name.value,
                                    caption.value,
                                    headerText.value,
                                    markdownText.value
                                )
                            } else {
                                db.updateCardAndPost(
                                    name.value,
                                    caption.value,
                                    headerText.value,
                                    markdownText.value,
                                    postId
                                );
                            }
                            navController.popBackStack();
                            navController.navigate(Screen.HomeScreen.route)
                        },
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(text = "Save")
                    }
                }
            }
        }
    }
}

