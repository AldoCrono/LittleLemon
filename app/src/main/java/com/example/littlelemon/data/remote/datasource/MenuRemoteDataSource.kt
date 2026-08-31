package com.example.littlelemon.data.remote.datasource

import com.example.littlelemon.data.remote.model.MenuItemRequest

interface MenuRemoteDataSource {

    suspend fun getMenu(): List<MenuItemRequest>
}