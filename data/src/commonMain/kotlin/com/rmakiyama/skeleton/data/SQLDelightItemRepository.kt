package com.rmakiyama.skeleton.data

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.rmakiyama.skeleton.data.db.SkeletonDatabase
import com.rmakiyama.skeleton.domain.Item
import com.rmakiyama.skeleton.domain.ItemId
import com.rmakiyama.skeleton.domain.ItemRepository
import dev.zacsweers.metro.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kotlin.time.Instant

@Inject
class SQLDelightItemRepository(
    private val database: SkeletonDatabase,
) : ItemRepository {

    private val itemQueries = database.itemQueries

    override fun getItemsStream(): Flow<List<Item>> {
        return itemQueries.selectAll().asFlow().mapToList(Dispatchers.IO).map { items ->
            items.map { item ->
                Item(
                    id = ItemId(item.id),
                    title = item.title,
                    description = item.description,
                    createdAt = Instant.fromEpochMilliseconds(item.created_at),
                )
            }
        }
    }

    override suspend fun save(item: Item) {
        withContext(Dispatchers.IO) {
            itemQueries.insert(
                id = item.id.value,
                title = item.title,
                description = item.description,
                created_at = item.createdAt.toEpochMilliseconds(),
            )
        }
    }
}
