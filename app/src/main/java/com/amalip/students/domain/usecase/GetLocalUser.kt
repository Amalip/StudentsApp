package com.amalip.students.domain.usecase

import com.amalip.students.core.interactor.UseCase
import com.amalip.students.domain.model.User
import com.amalip.students.domain.repository.UserRepository
import javax.inject.Inject

/**
 * Created by Amalip on 10/6/2021.
 */


class GetLocalUser @Inject constructor(private val userRepository: UserRepository) :
    UseCase<User, UseCase.None>() {

    override suspend fun run(params: None) = userRepository.getLocalUser()

}