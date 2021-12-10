package com.amalip.students.data.api

import com.amalip.students.domain.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

/**
 * Created by Amalip on 12/5/2021.
 */

interface UserApi {

    @POST("user/login")
    fun login(@Body user: User): Call<User>

    @PUT("user")
    fun updateUser(@Body user: User): Call<Unit>

}