package com.seros.testapp.diDagger

import android.content.Context
import com.seros.testapp.data.repository.UserRepositoryImpl
import com.seros.testapp.data.storage.UserStorage
import com.seros.testapp.data.storage.sharedprefs.SharedPrefUserStorage
import com.seros.testapp.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideUserStorage(context: Context): UserStorage{
        return SharedPrefUserStorage(context = context)
    }
    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
}