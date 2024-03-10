package com.neolife.homm3guide.screen.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.neolife.homm3guide.database.CardInfoModel

@Composable
fun HMM3CardList(
    dataList : List<CardInfoModel>, navController: NavController
) {
    LazyColumn() {
        items(dataList) { data ->
            HMM3Card(data = data, navController)
        }
    }
}