package com.rmakiyama.skeleton

import androidx.compose.runtime.Composable
import com.rmakiyama.skeleton.designsystem.theme.SkeletonTheme
import com.rmakiyama.skeleton.navigation.SkeletonNavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    SkeletonTheme {
        SkeletonNavGraph()
    }
}
