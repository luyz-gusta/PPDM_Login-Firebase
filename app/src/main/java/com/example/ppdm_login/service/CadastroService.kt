package com.example.ppdm_login.service

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface CadastroService {

    @POST("/usuario/cadastrarUsuario")
    suspend fun cadastroUsuario(@Body body: JsonObject): Response<JsonObject>

}