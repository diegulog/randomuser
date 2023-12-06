package com.diegulog.randomuser.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.diegulog.randomuser.data.ResultOf
import com.diegulog.randomuser.domain.repository.UserRepository
import com.diegulog.randomuser.ui.state.UserListUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import com.diegulog.randomuser.BuildConfig

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val resultsPerPage = 100
    private val seed = BuildConfig.APPLICATION_ID
    private val _uiState = MutableStateFlow(UserListUiState())
    val uiState = _uiState.asLiveData()

    init {
        getFirstPage()
    }

    fun getFirstPage() {
        getUsers(0, resultsPerPage)
    }

    private fun getUsers(page: Int, results: Int) = viewModelScope.launch {
        userRepository
            .getUsers(page, results, seed)
            .collect {
                _uiState.value = when (it) {
                    is ResultOf.Loading -> _uiState.value.copy(
                        isLoading = true,
                        error = null
                    )

                    is ResultOf.Failure -> _uiState.value.copy(
                        isLoading = false,
                        error = it.throwable
                    )

                    is ResultOf.Success -> _uiState.value.copy(
                        isLoading = false,
                        users = it.value,
                        error = null
                    )
                }
            }

    }


}