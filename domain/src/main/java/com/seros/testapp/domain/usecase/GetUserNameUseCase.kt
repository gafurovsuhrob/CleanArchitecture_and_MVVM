package com.seros.testapp.domain.usecase

import com.seros.testapp.domain.models.UserName
import com.seros.testapp.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}