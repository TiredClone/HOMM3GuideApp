package com.neolife.homm3guide.screen.home

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.neolife.homm3guide.database.CardInfoModel
import com.neolife.homm3guide.database.DBHelper
import com.neolife.homm3guide.screen.Screen
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HMM3Card(
    data: CardInfoModel, navController: NavController, db: DBHelper
) {
    var contextMenuCardID by rememberSaveable { mutableStateOf<Int?>(null) }

    val haptics = LocalHapticFeedback.current
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    Card(modifier = Modifier
        .fillMaxWidth().
        padding(start = 10.dp, end = 10.dp, top = 10.dp).
        height(100.dp)
            .combinedClickable (onClick = { navController.navigate("postScreen/"+ data.post_id) },
                onLongClick = {haptics.performHapticFeedback(HapticFeedbackType.LongPress)
                              contextMenuCardID = data.id},
                onLongClickLabel = "test"),
        ) {
        Text(text = data.name,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp),
            textAlign = TextAlign.Center,)
        Text(text = data.caption,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(10.dp),)

        if (contextMenuCardID != null) {
            ModalBottomSheet(
                onDismissRequest = {
                    contextMenuCardID = null
                },
                sheetState = sheetState
            ){
                BottomSheetListItem(title = "Edit",
                    onItemClick =
                    { scope.launch { sheetState.hide() }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        contextMenuCardID = null
                        navController.navigate(Screen.EditPostScreen.route.replace("{post_id}",data.post_id.toString()))
                    }
                }})
                BottomSheetListItem(title = "Remove",
                    onItemClick =
                    { scope.launch { sheetState.hide() }.invokeOnCompletion {
                        db.removeCard(data.id)
                        if (!sheetState.isVisible) {
                            contextMenuCardID = null
                            navController.navigate(Screen.HomeScreen.route)
                        }
                    }})

            }
        }
    }
}