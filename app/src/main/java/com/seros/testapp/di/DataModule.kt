package com.seros.testapp.di

import com.seros.testapp.data.repository.UserRepositoryImpl
import com.seros.testapp.data.storage.UserStorage
import com.seros.testapp.data.storage.sharedprefs.SharedPrefUserStorage
import com.seros.testapp.domain.repository.UserRepository
import org.koin.dsl.module


val dataModule = module {
    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}