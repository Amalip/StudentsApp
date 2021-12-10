package com.amalip.students.domain.repository

import com.amalip.students.core.exception.Failure
import com.amalip.students.core.functional.Either
import com.amalip.students.domain.model.User

/**
 * Created by Amalip on 12/5/2021.
 */

interface UserRepository {

    fun getLocalUser(): Either<Failure, User>

    fun doLogout(): Either<Failure, Boolean>

    fun findUser(enrollment: String, password: String): Either<Failure, User>

    fun updateUser(user: User): Either<Failure, Boolean>

}