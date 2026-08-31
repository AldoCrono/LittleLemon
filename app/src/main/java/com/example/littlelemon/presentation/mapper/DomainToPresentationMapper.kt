package com.example.littlelemon.presentation.mapper

import com.example.littlelemon.R
import com.example.littlelemon.domain.entity.MenuEntity
import com.example.littlelemon.domain.entity.UserEntity
import com.example.littlelemon.presentation.model.InfoData
import com.example.littlelemon.presentation.model.MenuItemData

fun List<MenuEntity>.toPresentation() =
    map { it.toPresentation() }

private fun MenuEntity.toPresentation() =
    MenuItemData(
        title = title,
        description = description,
        price = "$${String.format("%.2f", price)}",
        category = category,
        image = image,
    )


fun UserEntity.toPresentation(): List<InfoData> {
    return listOf(
        InfoData(
            label = R.string.first_name,
            value = firstName
        ),
        InfoData(
            label = R.string.last_name,
            value = lastName
        ),
        InfoData(
            label = R.string.email,
            value = email
        ),
    )
}
