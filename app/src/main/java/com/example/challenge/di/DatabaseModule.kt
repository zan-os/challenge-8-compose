package com.example.challenge.di

import android.content.Context
import androidx.room.Room
import com.example.challenge.data.local.room.MovieDatabase
import com.example.challenge.data.local.room.dao.FavoriteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MovieDatabase {
        return Room.databaseBuilder(context, MovieDatabase::class.java, "movie.db")
            .build()
    }

    @Provides
    fun provideFavoriteDao(database: MovieDatabase): FavoriteDao {
        return database.favoriteDao()
    }
}