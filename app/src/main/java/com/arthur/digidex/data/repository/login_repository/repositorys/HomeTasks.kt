package com.arthur.digidex.data.repository.login_repository.repositorys

import com.arthur.digidex.data.model.User
import kotlinx.coroutines.flow.Flow

interface HomeTasks {

    /*
    *   Al tener nuestro manifiesto de tareas,
    *   podemos implementar esta interface en un
    *   repositorio de prueba, para facilitar y promover
    *   el testing.
    */

    suspend fun checkUserSession(
        page: Int
    ): Flow<Boolean>

    /*suspend fun getUser(): User?

    suspend fun deleteUser()*/

}