package com.arthur.digidex.ui.screens.home

import com.arthur.digidex.data.model.User

data class HomeUiState(
    val loading: Boolean = false,
    val loginSuccess: Boolean? = null,
    val user: User? = null
)