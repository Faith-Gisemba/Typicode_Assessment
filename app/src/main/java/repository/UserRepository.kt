package repository

import apis.ApiClient
import apis.ApiInterface
import apis.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient = ApiClient.buildClient(ApiInterface::class.java)

    suspend fun getUsers(): Response<UserResponse> {
        return withContext(Dispatchers.IO){
            apiClient.getUsers()
        }

    }
}
