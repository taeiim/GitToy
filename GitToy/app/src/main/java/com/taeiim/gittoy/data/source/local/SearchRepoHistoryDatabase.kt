package com.taeiim.gittoy.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.taeiim.gittoy.data.source.local.model.RepoStringConverter
import com.taeiim.gittoy.data.source.local.model.SearchRepoHistory

@Database(entities = [SearchRepoHistory::class], version = 1, exportSchema = false)

@TypeConverters(RepoStringConverter::class)
abstract class SearchRepoHistoryDatabase : RoomDatabase() {

    abstract fun searchHistoryDao(): SearchRepoHistoryDao

    companion object {
        const val DB_NAME = "SearchRepoHistory.db"
    }

}