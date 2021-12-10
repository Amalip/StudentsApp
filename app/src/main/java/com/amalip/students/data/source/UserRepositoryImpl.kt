package com.amalip.students.data.source

import com.amalip.students.core.enums.UserLevel
import com.amalip.students.core.exception.Failure
import com.amalip.students.core.functional.Either
import com.amalip.students.core.functional.getOrElse
import com.amalip.students.core.plataform.AuthManager
import com.amalip.students.core.plataform.NetworkHandler
import com.amalip.students.data.api.UserApi
import com.amalip.students.domain.model.User
import com.amalip.students.domain.repository.UserRepository
import com.amalip.students.framework.api.ApiRequest
import com.amalip.students.presentation.login.LoginFailure
import com.amalip.students.presentation.profile.ProfileFailure
import javax.inject.Inject

/**
 * Created by Amalip on 12/5/2021.
 */

class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi,
    private val authManager: AuthManager,
    private val networkHandler: NetworkHandler
) : UserRepository, ApiRequest {

    override fun getLocalUser(): Either<Failure, User> {
        val result = authManager.user

        return result?.let {
            Either.Right(it)
        } ?: Either.Left(Failure.Unauthorized)
    }

    override fun doLogout(): Either<Failure, Boolean> {
        authManager.user = null
        return Either.Right(true)
    }

    override fun findUser(enrollment: String, password: String): Either<Failure, User> {
        val result = makeRequest(
            networkHandler,
            userApi.login(
                User(
                    enrollment = enrollment,
                    password = password,
                    level = UserLevel.STUDENT.code
                )
            ),
            { it },
            User()
        )

        return if (result.isRight) {
            authManager.user = result.getOrElse(User())

            result
        } else Either.Left(LoginFailure.NotFound)
    }

    override fun updateUser(user: User): Either<Failure, Boolean> {
        val result = makeRequest(networkHandler, userApi.updateUser(user), { }, Unit)

        return if (result.isRight) {
            authManager.user = user

            Either.Right(true)
        } else Either.Left(ProfileFailure.CouldNotUpdate)
    }

}