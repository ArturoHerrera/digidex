package com.arthur.digidex.ui.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arthur.digidex.data.repository.login_repository.repositorys.HomeTasks
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@ExperimentalCoroutinesApi
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeTasks: HomeTasks
) : ViewModel() {

    private val vmUiState = MutableStateFlow(HomeUiState())

    val uiState = vmUiState.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        vmUiState.value
    )

    fun login(email: String, pass: String) {
        vmUiState.update { it.copy(loading = true, loginSuccess = null) }
        viewModelScope.launch {
            homeTasks
                .checkUserSession(email, pass)
                .collectLatest { result ->
                    vmUiState.update { it.copy(loading = false, loginSuccess = result) }
                    if(result){
                        getUserFromLocal()
                    } else {
                        deleteUserFromLocal()
                    }
                }
        }
    }

    private fun getUserFromLocal(){
        viewModelScope.launch {
            val mUser = homeTasks.getUser()
            vmUiState.update { it.copy(user = mUser) }
            Log.i("testUser", "User ---> ${Gson().toJson(mUser)}")
        }
    }

    private suspend fun deleteUserFromLocal() = homeTasks.deleteUser()
}