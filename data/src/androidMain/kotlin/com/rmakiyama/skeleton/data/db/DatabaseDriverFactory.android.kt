package com.rmakiyama.skeleton.data.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

actual class DatabaseDriverFactory(
    private val context: Context,
) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = SkeletonDatabase.Schema,
            context = context,
            name = "skeleton.db",
        )
    }
}
