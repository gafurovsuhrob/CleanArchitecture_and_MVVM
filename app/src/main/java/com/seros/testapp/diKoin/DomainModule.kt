package com.seros.testapp.diKoin

import com.seros.testapp.domain.usecase.GetUserNameUseCase
import com.seros.testapp.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module


val domainModule = module {
    factory<GetUserNameUseCase> {
        GetUserNameUseCase(get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(get())
    }
}