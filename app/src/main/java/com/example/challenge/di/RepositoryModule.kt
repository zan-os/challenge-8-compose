package com.example.challenge.di

import com.example.challenge.data.local.room.dao.FavoriteDao
import com.example.challenge.data.remote.TheMovieApi
import com.example.challenge.data.repository.MovieRepositoryImpl
import com.example.challenge.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(api: TheMovieApi, dao: FavoriteDao): MovieRepository {
        return MovieRepositoryImpl(api,dao)
    }
}