package com.amalip.students.data.api

import com.amalip.students.domain.model.Course
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Amalip on 12/6/2021.
 */
interface CourseApi {

    @GET("course/byUser")
    fun getCoursesByUser(@Query("userId") userId: Int): Call<List<Course>>

    @GET("course/byId")
    fun getCourseByIdAndUser(
        @Query("courseId") courseId: Int,
        @Query("userId") userId: Int
    ): Call<Course>

}