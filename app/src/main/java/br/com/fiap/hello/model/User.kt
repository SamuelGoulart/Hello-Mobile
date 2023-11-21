package br.com.fiap.hello.model

data class User(
    val message: String,
    val payload: Payload,
    val error: List<String>
) {
    data class Payload(
        val userId: Int,
        val name: String,
        val email: String,
        val phone: String,
        val password: String,
        val createdAt: String,
        val updateAt: String?,
        val deleteAt: String?
    )
}

