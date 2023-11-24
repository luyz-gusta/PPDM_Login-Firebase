package com.example.ppdm_login.repository

import com.example.ppdm_login.service.RetrofitHelper
import com.google.gson.JsonObject
import retrofit2.Response

class CadastroRepository {
    private val apiService = RetrofitHelper.postCadastroService()

     suspend fun cadastroUsuario(
        email: String,
        senha: String,
        foto: String
    ): Response<JsonObject> {
        val requestBody = JsonObject().apply {
            addProperty("login", email)
            addProperty("senha", senha)
            addProperty("imagem", foto)
        }

        return apiService.cadastroUsuario(requestBody)
    }
}