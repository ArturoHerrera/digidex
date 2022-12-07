package com.arthur.digidex.data.remote.api

import com.arthur.digidex.data.remote.dto.DigiResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LoginApi {

    /*
    *  Endpoint tomado de: https://digimon-api.com/#docs
    */

    @GET("/api/v1/digimon")
    suspend fun getDigimonList(
        @Query(value = "page") page: Int = 0
    ): Response<DigiResponseDto>

}