package com.seros.testapp.domain.repository

import com.seros.testapp.domain.models.SaveUserNameParams
import com.seros.testapp.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParams): Boolean

    fun getName(): UserName
}