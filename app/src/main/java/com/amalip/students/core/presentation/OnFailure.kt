package com.amalip.students.core.presentation

import com.amalip.students.core.exception.Failure

/**
 * Created by Amalip on 9/27/2021.
 */

interface OnFailure {

    fun handleFailure(failure: Failure?)

}