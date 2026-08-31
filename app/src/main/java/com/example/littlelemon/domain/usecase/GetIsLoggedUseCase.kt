package com.example.littlelemon.domain.usecase

import com.example.littlelemon.domain.repository.LittleLemonRepository

class GetIsLoggedUseCase(private val repository: LittleLemonRepository) {

    operator fun invoke(): Boolean {
        return repository.getIsLogged()
    }
}