package com.example.littlelemon.domain.repository

import com.example.littlelemon.domain.entity.MenuEntity
import com.example.littlelemon.domain.entity.UserEntity

interface LittleLemonRepository {

    suspend fun getMenu(): List<MenuEntity>

    fun getIsLogged(): Boolean

    fun setIsLogged(isLogged: Boolean)

    fun getUserData(): UserEntity

    fun setUserData(firstName: String?, lastName: String?, email: String?)
}