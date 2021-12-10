package com.amalip.students.domain.usecase

import com.amalip.students.core.interactor.UseCase
import com.amalip.students.domain.model.User
import com.amalip.students.domain.repository.UserRepository
import javax.inject.Inject

/**
 * Created by Amalip on 12/7/2021.
 */
class UpdateProfile @Inject constructor(private val userRepository: UserRepository) :
    UseCase<Boolean, User>() {

    override suspend fun run(params: User) = userRepository.updateUser(params)

}