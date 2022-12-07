package com.arthur.digidex.data.remote.dto

import com.google.gson.annotations.SerializedName

data class DigiResponseDto(
    @SerializedName("content") var content: List<Content> = listOf(),
    @SerializedName("pageable") var pageable: Pageable? = Pageable()
)

data class Content(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("href") var href: String? = null
)

data class Pageable(
    @SerializedName("currentPage") var currentPage: Int? = null,
    @SerializedName("elementsOnPage") var elementsOnPage: Int? = null,
    @SerializedName("totalElements") var totalElements: Int? = null,
    @SerializedName("totalPages") var totalPages: Int? = null,
    @SerializedName("previousPage") var previousPage: String? = null,
    @SerializedName("nextPage") var nextPage: String? = null
)