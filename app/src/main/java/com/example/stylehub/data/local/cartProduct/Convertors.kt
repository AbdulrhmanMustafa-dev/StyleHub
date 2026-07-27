package com.example.stylehub.data.local.cartProduct

import androidx.room.TypeConverter
import com.example.stylehub.domain.models.Instruction
import com.google.gson.Gson

class Convertors {
    @TypeConverter
    fun fromStringList(list: List<String>?): String? {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toStringList(data: String?): List<String>? {
        val listType = object : com.google.gson.reflect.TypeToken<List<String>>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun fromIntList(list: List<Int>?): String? {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toIntList(data: String?): List<Int>? {
        val listType = object : com.google.gson.reflect.TypeToken<List<Int>>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun fromInstructionList(list: List<Instruction>?): String? {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toInstructionList(data: String?): List<Instruction>? {
        val listType = object : com.google.gson.reflect.TypeToken<List<Instruction>>() {}.type
        return Gson().fromJson(data, listType)
    }
}
