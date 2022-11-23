package com.rmakiyama.skeleton.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rmakiyama.skeleton.Greeting
import com.rmakiyama.skeleton.R
import com.rmakiyama.skeleton.designsystem.component.SkeletonTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { SkeletonTopAppBar(titleRes = R.string.title_home) },
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            Text(text = Greeting().greeting())
        }
    }
}
