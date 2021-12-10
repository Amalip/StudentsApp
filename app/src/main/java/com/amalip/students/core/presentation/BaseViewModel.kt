package com.amalip.students.core.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amalip.students.core.exception.Failure

/**
 * Created by Amalip on 9/27/2021.
 */

abstract class BaseViewModel : ViewModel() {

    var state: MutableLiveData<BaseViewState> = MutableLiveData()
    var failure: MutableLiveData<Failure> = MutableLiveData()

    protected fun handleFailure(failure: Failure) {
        this.failure.value = failure
        state.value = BaseViewState.HideLoading
    }

}