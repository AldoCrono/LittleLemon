package com.example.littlelemon.presentation.screens.login

sealed class LoginVMEvent {
    data object NavigateToHome : LoginVMEvent()
}