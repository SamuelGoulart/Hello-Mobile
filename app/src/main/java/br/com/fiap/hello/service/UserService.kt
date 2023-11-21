package br.com.fiap.hello.service

import br.com.fiap.hello.model.User
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Body;
data class AuthRequest(
    val email: String,
    val password: String
)

interface UserService {
    @POST("/api/v1/auth")
    fun auth(@Body requestBody: AuthRequest): Call<User>
}