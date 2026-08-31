package com.example.littlelemon.domain.usecase

import com.example.littlelemon.domain.repository.LittleLemonRepository

class SetIsLoggedUseCase(private val repository: LittleLemonRepository) {

    operator fun invoke(isLogged: Boolean) {
        repository.setIsLogged(isLogged)
    }
}