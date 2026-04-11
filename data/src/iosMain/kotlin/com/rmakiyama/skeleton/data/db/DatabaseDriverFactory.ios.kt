package com.rmakiyama.skeleton.data.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            schema = SkeletonDatabase.Schema,
            name = "skeleton.db",
        )
    }
}
