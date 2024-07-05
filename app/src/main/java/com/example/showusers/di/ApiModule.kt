package com.example.showusers.di

import com.example.showusers.data.api.ApiDetails
import com.example.showusers.data.api.ApiEndpoints
import com.example.showusers.data.repository.ApiRepository
import com.example.showusers.data.repository.ApiRepositoryImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    //Provides dependencies that will be injected throughout the app

    //Retrofit instance
    @Provides
    fun providesRetrofit():Retrofit{
        //http interceptor
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()

        //retrofit (base url, client, converterFactory)
        return Retrofit.Builder()
            .baseUrl(ApiDetails.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
    }


    //ApiEndpoints instance
    @Provides
    fun providesApiEndPoints(retrofit: Retrofit):ApiEndpoints{
        return retrofit.create(ApiEndpoints::class.java)
    }

    //ApiRepository
    @Provides
    fun providesRepository(apiEndpoints: ApiEndpoints):ApiRepository{
        return ApiRepositoryImpl(apiEndpoints)
    }
}