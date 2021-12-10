package com.amalip.students.core.di

import com.amalip.students.core.plataform.AuthManager
import com.amalip.students.core.plataform.NetworkHandler
import com.amalip.students.data.api.CourseApi
import com.amalip.students.data.api.UserApi
import com.amalip.students.data.source.CourseRepositoryImpl
import com.amalip.students.data.source.UserRepositoryImpl
import com.amalip.students.domain.repository.CourseRepository
import com.amalip.students.domain.repository.UserRepository
import com.amalip.students.framework.api.ApiProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Amalip on 10/20/2021.
 */

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(
        apiProvider: ApiProvider,
        authManager: AuthManager,
        networkHandler: NetworkHandler
    ): UserRepository =
        UserRepositoryImpl(
            apiProvider.getEndpoint(UserApi::class.java),
            authManager,
            networkHandler
        )

    @Provides
    @Singleton
    fun provideCourseRepository(
        apiProvider: ApiProvider,
        networkHandler: NetworkHandler
    ): CourseRepository =
        CourseRepositoryImpl(
            apiProvider.getEndpoint(CourseApi::class.java),
            networkHandler
        )

}