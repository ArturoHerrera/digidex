package com.arthur.digidex.data.repository.login_repository.remote_data_sources

import com.arthur.digidex.data.remote.api.LoginApi
import com.arthur.digidex.data.remote.dto.DigiResponseDto
import com.arthur.digidex.data.remote.dto.LoginBody
import com.arthur.digidex.data.repository.login_repository.repositorys.LoginRemoteDataSource
import com.arthur.digidex.utils.networkCall
import com.arthur.meal_db.utils.ServiceResult

class LoginRetrofitRemoteDataSource(
    private val loginApi: LoginApi
) : LoginRemoteDataSource {


    override suspend fun userLogin(page: Int): ServiceResult<DigiResponseDto?> =
        networkCall {
            loginApi.getDigimonList(
               page = 0
            ).body()
        }
}