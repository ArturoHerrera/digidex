package com.arthur.digidex.data.repository.login_repository.repositorys

import com.arthur.digidex.data.model.User
import com.arthur.digidex.data.remote.dto.DigiResponseDto
import com.arthur.meal_db.utils.ServiceResult
import com.arthur.meal_db.utils.getDto
import com.arthur.meal_db.utils.succeeded
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class HomeGoodRepository(
    private val loginLocalDS: LoginLocalDataSource,
    private val loginRemoteDS: LoginRemoteDataSource
) : HomeTasks {

    //val isValidToken = loginLocalDS.getUserToken("mUserCredentials")

    override suspend fun checkUserSession(
        page: Int
    ): Flow<Boolean> = flow {
        emit(loginRemoteDS.userLogin(page))
    }
        .map { result ->
            if (result.succeeded) {
                /*
                *  Si desearamos obtener la información del usuario insertado,
                *  cambiariamos la firma de esta suspend function (Desde las LoginTasks) .
                *
                *  Para este caso de muestra, tampoco valideraemos la
                *  nullabilidad de los datos, pero seria lo correcto.
                */
                val mUserDto = result.getDto()
                /*mUserDto?.let { safeAuthDto ->
                    loginLocalDS.setUser(safeAuthDto)
                }*/
                return@map result.succeeded ?: false
            }
            return@map false
        }
        .flowOn(Dispatchers.IO)
        .catch { e -> e.printStackTrace() }

    /*override suspend fun getUser(): User? = loginLocalDS.getUser()

    override suspend fun deleteUser() = loginLocalDS.deleteUser()*/

}

interface LoginLocalDataSource {
    /*fun getUserToken(user: String): String?
    suspend fun setUser(userDto: DigiResponseDto): User?
    suspend fun getUser(): User?
    suspend fun deleteUser()*/
}

interface LoginRemoteDataSource {
    suspend fun userLogin(page: Int): ServiceResult<DigiResponseDto?>
}