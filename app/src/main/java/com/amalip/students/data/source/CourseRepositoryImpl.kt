package com.amalip.students.data.source

import com.amalip.students.core.exception.Failure
import com.amalip.students.core.functional.Either
import com.amalip.students.core.plataform.NetworkHandler
import com.amalip.students.data.api.CourseApi
import com.amalip.students.domain.model.Course
import com.amalip.students.domain.repository.CourseRepository
import com.amalip.students.framework.api.ApiRequest
import com.amalip.students.presentation.course.list.CoursesFailure
import javax.inject.Inject

/**
 * Created by Amalip on 12/5/2021.
 */

class CourseRepositoryImpl @Inject constructor(
    private val courseApi: CourseApi,
    private val networkHandler: NetworkHandler
) : CourseRepository, ApiRequest {

    override fun getCoursesByUser(userId: Int): Either<Failure, List<Course>> {
        val result = makeRequest(
            networkHandler, courseApi.getCoursesByUser(userId), { it }, emptyList()
        )

        return if (result.isRight) result
        else Either.Left(CoursesFailure.NotFound)

    }

    override fun getCourseByIdAndUser(courseId: Int, userId: Int): Either<Failure, Course> {
        val result = makeRequest(
            networkHandler, courseApi.getCourseByIdAndUser(courseId, userId), { it }, Course()
        )

        return if (result.isRight) result
        else Either.Left(CoursesFailure.NotFound)
    }

}