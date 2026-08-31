package com.example.littlelemon.di

import com.example.littlelemon.data.local.datasource.LittleLemonLocalDataSource
import com.example.littlelemon.data.local.datasource.LittleLemonLocalDataSourceImpl
import com.example.littlelemon.data.local.roomdatabase.DatabaseBuilder
import com.example.littlelemon.data.local.roomdatabase.LittleLemonRoomDatabase
import com.example.littlelemon.data.local.sharedpref.LittleLemonSharedPrefs
import com.example.littlelemon.data.remote.datasource.MenuRemoteDataSource
import com.example.littlelemon.data.remote.datasource.MenuRemoteDataSourceImpl
import com.example.littlelemon.data.remote.service.KtorClient
import com.example.littlelemon.data.remote.service.MenuService
import com.example.littlelemon.data.remote.service.MenuServiceImpl
import com.example.littlelemon.data.repository.LittleLemonRepositoryImpl
import com.example.littlelemon.domain.repository.LittleLemonRepository
import com.example.littlelemon.domain.usecase.GetCategoriesUseCase
import com.example.littlelemon.domain.usecase.GetIsLoggedUseCase
import com.example.littlelemon.domain.usecase.GetMenuUseCase
import com.example.littlelemon.domain.usecase.GetUserDataUseCase
import com.example.littlelemon.domain.usecase.SetIsLoggedUseCase
import com.example.littlelemon.domain.usecase.SetUserDataUseCase
import com.example.littlelemon.presentation.navigation.StartNavigationViewModel
import com.example.littlelemon.presentation.screens.home.HomeViewModel
import com.example.littlelemon.presentation.screens.login.LoginViewModel
import com.example.littlelemon.presentation.screens.profile.ProfileViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {

    single<MenuService> {
        MenuServiceImpl(
            httpClient = KtorClient.build()
        )
    }

    single(qualifier = named("LittleLemonRoomDatabase")){
        DatabaseBuilder.build(context = androidContext())
    }

    single<LittleLemonLocalDataSource> {
        LittleLemonLocalDataSourceImpl(
            prefs = LittleLemonSharedPrefs.build(context = androidContext()),
            db = get<LittleLemonRoomDatabase>(qualifier = named("LittleLemonRoomDatabase"))
                .getMenuDao()
        )
    }

    factory<MenuRemoteDataSource> { MenuRemoteDataSourceImpl(service = get()) }

    factory<LittleLemonRepository> {
        LittleLemonRepositoryImpl(
            remoteDataSource = get(),
            ioDispatcher = Dispatchers.IO,
            localDataSource = get()
        )
    }

    factory { GetMenuUseCase(get()) }

    factory { GetCategoriesUseCase() }

    factory { SetIsLoggedUseCase(get()) }

    factory { GetIsLoggedUseCase(get()) }

    factory { GetUserDataUseCase(get()) }

    factory { SetUserDataUseCase(get()) }

    viewModel {
        HomeViewModel(
            getMenuUseCase = get(),
            getCategoriesUseCase = get(),
        )
    }

    viewModel {
        LoginViewModel(
            setIsLoggedUseCase = get(),
            setUserDataUseCase = get(),
        )
    }

    viewModel {
        StartNavigationViewModel(
            getIsLoggedUseCase = get(),
        )
    }

    viewModel {
        ProfileViewModel(
            setIsLoggedUseCase = get(),
            getUserDataUseCase = get(),
        )
    }
}