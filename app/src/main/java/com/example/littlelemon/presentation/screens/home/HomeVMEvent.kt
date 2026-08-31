package com.example.littlelemon.presentation.screens.home

sealed class HomeVMEvent {

    data object NavigateToProfile : HomeVMEvent()
}