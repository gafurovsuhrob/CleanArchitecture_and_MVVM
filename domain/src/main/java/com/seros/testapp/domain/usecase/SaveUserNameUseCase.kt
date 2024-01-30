package com.seros.testapp.domain.usecase

import com.seros.testapp.domain.models.SaveUserNameParams
import com.seros.testapp.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParams): Boolean {
        return userRepository.saveName(param)
    }
}