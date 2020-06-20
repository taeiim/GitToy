package com.taeiim.gittoy.data.source.local.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.taeiim.gittoy.api.model.GithubRepo

class RepoStringConverter {

    @TypeConverter
    fun stringToList(value: String): GithubRepo {
        val listType = object : TypeToken<GithubRepo>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun listToString(repo: GithubRepo): String {
        return Gson().toJson(repo)
    }

}
