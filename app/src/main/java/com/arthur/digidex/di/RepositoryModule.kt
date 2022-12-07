package com.arthur.digidex.di

import com.arthur.digidex.core.AppDatabase
import com.arthur.digidex.core.AppPreferences
import com.arthur.digidex.data.remote.api.LoginApi
import com.arthur.digidex.data.repository.login_repository.local_data_sources.LoginRoomLocalDataSource
import com.arthur.digidex.data.repository.login_repository.remote_data_sources.LoginRetrofitRemoteDataSource
import com.arthur.digidex.data.repository.login_repository.repositorys.HomeGoodRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @ViewModelScoped
    @Provides
    fun providesLoginGoodRepository(
        api: LoginApi,
        db: AppDatabase,
        prefs: AppPreferences
    ): HomeGoodRepository = HomeGoodRepository(
        loginLocalDS = LoginRoomLocalDataSource(
            pref = prefs,
            dao = db.userDao()
        ),
        loginRemoteDS = LoginRetrofitRemoteDataSource(
            loginApi = api
        )
    )

}