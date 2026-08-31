package com.example.littlelemon.domain.usecase

import com.example.littlelemon.domain.entity.UserEntity
import com.example.littlelemon.domain.repository.LittleLemonRepository

class GetUserDataUseCase(private val repository: LittleLemonRepository) {

    operator fun invoke(): UserEntity {
        return repository.getUserData()
    }
}