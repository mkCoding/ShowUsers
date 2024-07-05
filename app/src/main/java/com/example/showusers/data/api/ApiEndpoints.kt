package com.example.showusers.data.api

import com.example.showusers.data.model.UsersModel
import retrofit2.http.GET

interface ApiEndpoints {

    //method for making call to api endpoint
    @GET(ApiDetails.ENDPOINT_USERS)
    suspend fun getAllUsers():UsersModel

}