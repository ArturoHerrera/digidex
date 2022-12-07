package com.arthur.digidex.data.model

import com.arthur.digidex.data.local.room.DigimonEntity

data class User(
    val userEmail: String,
    val userName: String
) {
    constructor(entity: DigimonEntity): this(
        userEmail = entity.userEmail,
        userName = entity.userName
    )
}
