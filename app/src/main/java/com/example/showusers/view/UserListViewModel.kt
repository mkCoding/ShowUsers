package com.example.showusers.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.showusers.data.model.DataModel
import com.example.showusers.data.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(val repository: ApiRepository): ViewModel() {

    /*
    MutableState Flow benefits
    - works smoother with coroutines
    - there are robust operations for data transformations
    - Hot (emits data weather there are observers or not)
    */

    val _allUsers = MutableStateFlow <List<DataModel?>?> (emptyList())
    val allUsers:MutableStateFlow<List<DataModel?>?> = _allUsers

    init {
        getAllUsers()
    }

    //this is a method that will populate the Stateflow to be observed by observer/collector
    private fun getAllUsers() {
        viewModelScope.launch {
            val allUsersFromRepo = repository.getAllUsers().data

            if(allUsersFromRepo!=null){
                _allUsers.value = allUsersFromRepo
            }
        }
    }


}