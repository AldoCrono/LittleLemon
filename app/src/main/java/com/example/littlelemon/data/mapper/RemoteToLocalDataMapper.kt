package com.example.littlelemon.data.mapper

import com.example.littlelemon.data.local.entity.MenuLocalEntity
import com.example.littlelemon.data.remote.model.MenuItemRequest

fun List<MenuItemRequest>.toLocalDataModel(): List<MenuLocalEntity> =
    map {
        MenuLocalEntity(
            title = it.title,
            description = it.description,
            price = it.price,
            category = it.category,
            image = it.image,
        )
    }