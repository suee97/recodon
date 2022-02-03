package com.example.recodon.data.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recodon.data.models.UserInfo
import com.example.recodon.data.repositories.FeedEarthRepository
import com.example.recodon.utils.RequestState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedEarthViewModel @Inject constructor(
    private val repository: FeedEarthRepository
) : ViewModel() {

    // Get All Data
    private val _allInfo =
        MutableStateFlow<RequestState<List<UserInfo>>>(RequestState.Idle)
    val allInfo: StateFlow<RequestState<List<UserInfo>>> = _allInfo

    fun getAllInfo() {
        _allInfo.value = RequestState.Loading
        try {
            viewModelScope.launch {
                repository.getAllInfo.collect {
                    _allInfo.value = RequestState.Success(it)
                }
            }
        } catch (e: Exception) {
            _allInfo.value = RequestState.Error(e)
        }
    }

    // Add Data
    fun addInfo(userInfo: UserInfo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addInfo(userInfo = userInfo)
        }
    }

    // Reset point
    fun resetPoint() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.resetPoint()
        }
    }

    // Reset Visible State to (true, true, true)
    fun updateInfo(userInfo: UserInfo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateInfo(userInfo = userInfo)
        }
    }

}