package com.example.spotifyclone.db

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.sql.Date

class Converters {
    @TypeConverter
    fun getDate(date : Date) : Long{
        return date.time
    }

    @TypeConverter
    fun toDate(date : Long) : Date{
        return Date(date)
    }
}