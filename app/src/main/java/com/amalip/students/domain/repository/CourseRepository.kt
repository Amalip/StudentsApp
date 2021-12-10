package com.amalip.students.domain.repository

import com.amalip.students.core.exception.Failure
import com.amalip.students.core.functional.Either
import com.amalip.students.domain.model.Course

/**
 * Created by Amalip on 12/6/2021.
 */

interface CourseRepository {

    fun getCoursesByUser(userId: Int): Either<Failure, List<Course>>

    fun getCourseByIdAndUser(courseId: Int, userId: Int): Either<Failure, Course>

}