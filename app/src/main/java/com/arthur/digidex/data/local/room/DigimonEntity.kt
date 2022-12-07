package com.arthur.digidex.data.local.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.arthur.digidex.data.remote.dto.DigiResponseDto

@Entity(tableName = "user")
data class DigimonEntity(
    @PrimaryKey @ColumnInfo(name = "user_email") val userEmail: String,
    @ColumnInfo(name = "user_name") val userName: String
) {

    /*@Ignore
    constructor(dto: DigiResponseDto?): this(
        dto?.result?.email ?: "",
        dto?.result?.name ?: "--",
    )*/
}
