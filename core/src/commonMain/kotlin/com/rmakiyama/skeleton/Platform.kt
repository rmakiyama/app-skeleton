package com.rmakiyama.skeleton

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform