package com.example.showusers.data.repository

import com.example.showusers.data.model.UsersModel

interface ApiRepository {

    suspend fun getAllUsers():UsersModel
}