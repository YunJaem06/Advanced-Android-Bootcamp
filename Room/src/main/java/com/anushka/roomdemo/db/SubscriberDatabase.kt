package com.anushka.roomdemo.db

import android.content.Context
import androidx.room.*
import androidx.room.migration.AutoMigrationSpec

@Database(
    entities = [Subscriber::class],
    version = 2,
    autoMigrations = [
    AutoMigration(from = 1, to = 2, spec = SubscriberDatabase.Migration1To2::class)
])
abstract class SubscriberDatabase : RoomDatabase() {

    abstract val subscriberDAO: SubscriberDAO

    @RenameColumn(tableName = "subscriber_data_table", fromColumnName = "subscriber_id", toColumnName = "subs_id")
    class Migration1To2 : AutoMigrationSpec

    companion object {
        @Volatile
        private var INSTANCE: SubscriberDatabase? = null
        fun getInstance(context: Context): SubscriberDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SubscriberDatabase::class.java,
                        "subscriber_data_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}