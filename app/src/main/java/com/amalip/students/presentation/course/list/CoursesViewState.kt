package com.amalip.students.presentation.course.list

import com.amalip.students.core.presentation.BaseViewState
import com.amalip.students.domain.model.Course

/**
 * Created by Amalip on 9/27/2021.
 */
sealed class CoursesViewState : BaseViewState() {

    data class CoursesReceived(val courses: List<Course>) : BaseViewState()

}