package com.amalip.students.domain.usecase

import com.amalip.students.core.interactor.UseCase
import com.amalip.students.domain.model.User
import com.amalip.students.domain.repository.UserRepository
import javax.inject.Inject

/**
 * Created by Amalip on 10/29/2021.
 */
class FindUser @Inject constructor(private val userRepository: UserRepository) :
    UseCase<User, User>() {

    override suspend fun run(params: User) =
        userRepository.findUser(params.enrollment, params.password)

}