package com.example.stylehub.data.local.cartProduct

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@TypeConverters(Convertors::class)
@Database(entities = [CartEntity::class], version = 1, exportSchema = false)
abstract class CartProductRoomDataBase : RoomDatabase() {
    abstract fun cartProductDAO(): CartProductDAO
}
