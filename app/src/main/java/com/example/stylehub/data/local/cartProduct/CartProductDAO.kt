package com.example.stylehub.data.local.cartProduct

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CartProductDAO {
    @Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    suspend fun insertCartProduct(cartEntity: CartEntity)

    @Delete
    suspend fun deleteCartProduct(cartEntity: CartEntity)

    @Query("SELECT * FROM cart_table")
    fun getAllCartProducts(): Flow<List<CartEntity>>

    @Update
    fun updateCartProduct(cartEntity: CartEntity)
}
