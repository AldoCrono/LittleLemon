package com.example.littlelemon.domain.usecase

import com.example.littlelemon.domain.entity.MenuEntity

class GetCategoriesUseCase {

    operator fun invoke(menuList: List<MenuEntity>): List<String> {
        return menuList.map { it.category }.distinct()
    }
}