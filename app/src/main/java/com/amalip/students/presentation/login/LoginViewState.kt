package com.amalip.students.presentation.login

import com.amalip.students.core.presentation.BaseViewState
import com.amalip.students.domain.model.User

/**
 * Created by Amalip on 9/27/2021.
 */
sealed class LoginViewState : BaseViewState() {

    data class UserFound(val user: User) : BaseViewState()

}