package com.rmakiyama.skeleton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.rmakiyama.skeleton.designsystem.theme.SkeletonTheme
import com.rmakiyama.skeleton.ui.SkeletonApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            SkeletonTheme {
                SkeletonApp()
            }
        }
    }
}
