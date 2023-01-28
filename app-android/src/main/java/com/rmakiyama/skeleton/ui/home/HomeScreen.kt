package com.rmakiyama.skeleton.ui.home

import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rmakiyama.skeleton.R
import com.rmakiyama.skeleton.designsystem.component.SkeletonTopAppBar
import com.rmakiyama.skeleton.designsystem.theme.SkeletonTheme
import com.rmakiyama.skeleton.model.Item

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.load()
    }

    HomeScreen(
        items = state.items,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreen(
    items: List<Item>,
) {
    Scaffold(
        topBar = { SkeletonTopAppBar(titleRes = R.string.title_home) },
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding),
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 24.dp),
            verticalArrangement = spacedBy(16.dp),
        ) {
            items(items, key = { it.hashCode() }) { item ->
                Item(item)
            }
        }
    }
}

@Composable
private fun Item(item: Item) {
    Card(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleLarge,
            )
            if (item.description != null) {
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = item.description.orEmpty(),
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    val items = listOf(
        Item(title = "hoge", description = "hoge hoge"),
        Item(title = "fuga", description = null),
        Item(title = "piyo", description = "piyo piyo piyo\npiyo"),
    )
    SkeletonTheme {
        HomeScreen(
            items = items,
        )
    }
}
