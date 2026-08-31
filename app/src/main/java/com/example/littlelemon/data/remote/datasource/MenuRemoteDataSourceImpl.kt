package com.example.littlelemon.data.remote.datasource

import com.example.littlelemon.data.remote.model.MenuItemRequest
import com.example.littlelemon.data.remote.service.MenuService

class MenuRemoteDataSourceImpl(private val service: MenuService): MenuRemoteDataSource {

    override suspend fun getMenu(): List<MenuItemRequest> {
        return service.getMenu()
    }
}