package com.seros.testapp.data.storage

import com.seros.testapp.data.storage.models.User

interface UserStorage {

    fun save(saveParam: User): Boolean

    fun get(): User

}