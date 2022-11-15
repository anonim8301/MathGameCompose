package com.example.mathgamecompose.di

import com.example.mathgamecompose.data.GameRepoImpl
import com.example.mathgamecompose.model.GameRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface GameModel {

    @Binds
    fun bindRepository(impl: GameRepoImpl): GameRepo
}