package com.example.littlelemon.data.remote.service

import com.example.littlelemon.data.remote.model.MenuItemRequest

interface MenuService {

    suspend fun getMenu(): List<MenuItemRequest>
}