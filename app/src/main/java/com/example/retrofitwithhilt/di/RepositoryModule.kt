package com.example.retrofitwithhilt.di

import com.example.retrofitwithhilt.repository.Repository
import com.example.retrofitwithhilt.repository.RepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class RepositoryModule  {

    @Binds
    abstract fun providesRepository(imp: RepositoryImp): Repository
}