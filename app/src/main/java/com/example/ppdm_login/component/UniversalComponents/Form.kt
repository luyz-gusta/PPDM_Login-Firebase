package com.example.ppdm_login.component.UniversalComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun Form(){
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextBoxScreen(
            label = "Email",
            valor = "",
            aoMudar = {
//                onEmailChange(it) // Chame a função de callback para atualizar o email
            }
        )
        TextFieldPasswordScreen(
            label = "Senha",
            valor = "",
            aoMudar = {
//                onSenhaChange(it) // Chame a função de callback para atualizar a senha
            }
        )
        ButtonInsert(text = "Create Account"){}
    }
}