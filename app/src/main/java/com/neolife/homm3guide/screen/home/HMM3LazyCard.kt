package com.neolife.homm3guide.screen.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.neolife.homm3guide.database.CardInfoModel
import com.neolife.homm3guide.database.DBHelper

@Composable
fun HMM3CardList(
    dataList : List<CardInfoModel>, navController: NavController, db: DBHelper
) {
    LazyColumn() {
        items(dataList) { data ->
            HMM3Card(data = data, navController, db)
        }
    }
}