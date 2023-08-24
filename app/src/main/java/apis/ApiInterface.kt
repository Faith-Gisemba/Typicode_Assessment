package apis

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/user")
    suspend fun getUsers(): Response<UserResponse>

    @GET("/user")
    suspend fun getUsers(@Path("id") userid: Int): Response<User>

}