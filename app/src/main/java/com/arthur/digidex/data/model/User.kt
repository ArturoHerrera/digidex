package com.arthur.digidex.data.model

import com.arthur.digidex.data.local.room.UserEntity

data class User(
    val userEmail: String,
    val userName: String
) {
    constructor(entity: UserEntity): this(
        userEmail = entity.userEmail,
        userName = entity.userName
    )
}
