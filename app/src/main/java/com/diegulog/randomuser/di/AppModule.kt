package com.diegulog.randomuser.di

import androidx.room.Room
import com.diegulog.randomuser.data.UserRepositoryImpl
import com.diegulog.randomuser.data.local.AppDatabase
import com.diegulog.randomuser.data.local.LocalDataSourceImpl
import com.diegulog.randomuser.data.remote.NetworkDataSourceImpl
import com.diegulog.randomuser.data.remote.createApiService
import com.diegulog.randomuser.domain.repository.UserRepository
import com.diegulog.randomuser.utils.ContactManager
import org.koin.dsl.module

val appModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "randomuser"
        ).fallbackToDestructiveMigration()
            .build()
    }
    single { createApiService() }
    single<UserRepository> {
        UserRepositoryImpl(
            NetworkDataSourceImpl(get()),
            LocalDataSourceImpl(get())
        )
    }
    single { ContactManager(get()) }

}