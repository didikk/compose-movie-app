package com.example.mymovie.data.db

import androidx.room.TypeConverter
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json

class IntListConverter {
    @TypeConverter
    fun convertToJson(list: List<Int>): String {
        return Json.encodeToString(ListSerializer(Int.serializer()), list)
    }

    @TypeConverter
    fun convertFromJson(json: String): List<Int> {
        return Json.decodeFromString(ListSerializer(Int.serializer()), json)
    }
}