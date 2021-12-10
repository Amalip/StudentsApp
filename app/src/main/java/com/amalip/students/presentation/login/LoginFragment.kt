package com.amalip.students.presentation.login

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import androidx.fragment.app.viewModels
import com.amalip.students.R
import com.amalip.students.core.extension.failure
import com.amalip.students.core.extension.observe
import com.amalip.students.core.presentation.BaseFragment
import com.amalip.students.core.presentation.BaseViewState
import com.amalip.students.databinding.LoginFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class LoginFragment : BaseFragment(R.layout.login_fragment) {

    private lateinit var binding: LoginFragmentBinding

    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
        }

    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when (state) {
            is LoginViewState.UserFound ->
                navController.navigate(LoginFragmentDirections.actionLoginFragmentToCoursesFragment())
        }
    }

    override fun setBinding(view: View) {
        binding = LoginFragmentBinding.bind(view)

        binding.apply {
            lifecycleOwner = this@LoginFragment

            vm = loginViewModel

            btnDoLogin.setOnClickListener { loginViewModel.doLogin() }

        }

        baseActivity.setBottomNavVisibility(GONE)
    }

}