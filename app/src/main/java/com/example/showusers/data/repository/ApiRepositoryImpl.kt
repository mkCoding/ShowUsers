package com.example.showusers.data.repository

import com.example.showusers.data.api.ApiEndpoints
import com.example.showusers.data.model.UsersModel
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(val apiEndpoints: ApiEndpoints):ApiRepository {
    override suspend fun getAllUsers(): UsersModel  = apiEndpoints.getAllUsers()


}