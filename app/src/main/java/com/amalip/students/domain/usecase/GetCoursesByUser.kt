package com.amalip.students.domain.usecase

import com.amalip.students.core.interactor.UseCase
import com.amalip.students.domain.model.Course
import com.amalip.students.domain.repository.CourseRepository
import javax.inject.Inject

/**
 * Created by Amalip on 12/6/2021.
 */
class GetCoursesByUser @Inject constructor(private val courseRepository: CourseRepository) :
    UseCase<List<Course>, Int>() {

    override suspend fun run(params: Int) = courseRepository.getCoursesByUser(params)

}