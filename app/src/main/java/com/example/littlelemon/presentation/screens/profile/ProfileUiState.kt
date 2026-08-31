package com.example.littlelemon.presentation.screens.profile

import com.example.littlelemon.presentation.model.InfoData

data class ProfileUiState(
    val userInfoList: List<InfoData> = emptyList(),
    val profileEvent: ProfileVMEvent? = null,
)