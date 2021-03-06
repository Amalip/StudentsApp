package com.amalip.students.presentation.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.amalip.students.R
import com.amalip.students.core.extension.failure
import com.amalip.students.core.extension.observe
import com.amalip.students.core.presentation.BaseFragment
import com.amalip.students.core.presentation.BaseViewState
import com.amalip.students.databinding.ProfileFragmentBinding
import com.amalip.students.domain.model.User
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class ProfileFragment : BaseFragment(R.layout.profile_fragment) {

    private lateinit var binding: ProfileFragmentBinding

    private val profileViewModel by viewModels<ProfileViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        profileViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
        }
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when (state) {
            is ProfileViewState.Updated -> showToast(getString(R.string.text_success))
            is ProfileViewState.LoggedOut -> navController.setGraph(R.navigation.main_graph)
        }
    }

    override fun setBinding(view: View) {
        binding = ProfileFragmentBinding.bind(view)

        binding.lifecycleOwner = viewLifecycleOwner

        binding.apply {
            vm = profileViewModel

            imgChange.setOnClickListener { profileViewModel.getRandomImage() }

            btnEdit.setOnClickListener {
                profileViewModel.editUser(
                    User(
                        name = edtName.text.toString(),
                        firstLastname = edtFirstLastname.text.toString(),
                        secondLastname = edtSecondLastname.text.toString(),
                        email = edtEmail.text.toString()
                    )
                )
            }

            txvLogout.setOnClickListener {
                profileViewModel.logout()
            }
        }

        baseActivity.setBottomNavVisibility(View.VISIBLE)
    }

}