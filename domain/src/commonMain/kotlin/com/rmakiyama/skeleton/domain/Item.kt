package com.rmakiyama.skeleton.domain

import kotlin.time.Instant

data class Item(
    val id: ItemId,
    val title: String,
    val description: String?,
    val createdAt: Instant,
)
