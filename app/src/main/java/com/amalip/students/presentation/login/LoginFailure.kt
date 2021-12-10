package com.amalip.students.presentation.login

import com.amalip.students.R
import com.amalip.students.core.exception.Failure

/**
 * Created by Amalip on 10/29/2021.
 */

sealed class LoginFailure {

    object NotFound : Failure.FeatureFailure(R.string.failure_user_not_found)

}