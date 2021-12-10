package com.amalip.students.presentation.course.detail

import com.amalip.students.R
import com.amalip.students.core.exception.Failure

/**
 * Created by Amalip on 9/27/2021.
 */

class CourseFailure {

    object NotFound : Failure.FeatureFailure(R.string.text_no_info)

}