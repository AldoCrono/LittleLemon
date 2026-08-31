package com.example.littlelemon.domain.usecase

import com.example.littlelemon.domain.entity.MenuEntity
import com.example.littlelemon.domain.repository.LittleLemonRepository

class GetMenuUseCase(private val repository: LittleLemonRepository) {

    suspend operator fun invoke(): List<MenuEntity> {
        return repository.getMenu()
    }
}