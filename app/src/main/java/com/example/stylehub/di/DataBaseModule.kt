package com.example.stylehub.di

import androidx.room.Room
import com.example.stylehub.data.local.cartProduct.CartProductDAO
import com.example.stylehub.data.local.cartProduct.CartProductRoomDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideCartProductRoomDatabase(
        @ApplicationContext context: android.content.Context
    ): CartProductRoomDataBase {
        return Room.databaseBuilder(
            context = context,
            klass = CartProductRoomDataBase::class.java,
            name = "cart_product_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCartProductDAO(cartProductRoomDatabase: CartProductRoomDataBase): CartProductDAO {
        return cartProductRoomDatabase.cartProductDAO()
    }

}
