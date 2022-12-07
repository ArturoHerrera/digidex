package com.arthur.digidex.di

import com.arthur.digidex.data.repository.login_repository.repositorys.HomeGoodRepository
import com.arthur.digidex.data.repository.login_repository.repositorys.HomeTasks
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class InterfaceTasksModule {

    @Binds
    abstract fun bindsCategoryListTasks(
        repository: HomeGoodRepository
    ): HomeTasks

}