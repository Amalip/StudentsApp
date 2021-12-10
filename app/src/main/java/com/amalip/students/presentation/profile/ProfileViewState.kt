package com.amalip.students.presentation.profile

import com.amalip.students.core.presentation.BaseViewState

/**
 * Created by Amalip on 9/27/2021.
 */
sealed class ProfileViewState : BaseViewState() {

    object Updated : ProfileViewState()
    object LoggedOut : ProfileViewState()

}