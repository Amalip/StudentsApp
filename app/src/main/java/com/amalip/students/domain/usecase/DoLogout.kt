package com.amalip.students.domain.usecase

import com.amalip.students.core.interactor.UseCase
import com.amalip.students.domain.repository.UserRepository
import javax.inject.Inject

/**
 * Created by Amalip on 12/5/2021.
 */
class DoLogout @Inject constructor(private val userRepository: UserRepository) :
    UseCase<Boolean, UseCase.None>() {

    override suspend fun run(params: None) = userRepository.doLogout()

}