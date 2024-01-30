package com.seros.testapp.data.repository

import com.seros.testapp.data.storage.models.User
import com.seros.testapp.data.storage.UserStorage
import com.seros.testapp.domain.models.SaveUserNameParams
import com.seros.testapp.domain.models.UserName
import com.seros.testapp.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParams): Boolean {
        val user = mapToStorage(saveParam)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }

    private fun mapToStorage(saveParam: SaveUserNameParams): User {
        return User(firstName = saveParam.name, lastName = "")
    }
}
