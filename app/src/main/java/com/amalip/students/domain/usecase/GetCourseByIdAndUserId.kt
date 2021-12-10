package com.amalip.students.domain.usecase

import com.amalip.students.core.interactor.UseCase
import com.amalip.students.domain.model.Course
import com.amalip.students.domain.repository.CourseRepository
import javax.inject.Inject

/**
 * Created by Amalip on 12/6/2021.
 */
class GetCourseByIdAndUserId @Inject constructor(private val courseRepository: CourseRepository) :
    UseCase<Course, Pair<Int, Int>>() {

    /** Params:
     * First -> Course ID
     * Second -> User ID
     */

    override suspend fun run(params: Pair<Int, Int>) =
        courseRepository.getCourseByIdAndUser(params.first, params.second)

}