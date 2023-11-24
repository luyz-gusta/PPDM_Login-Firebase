package com.example.ppdm_login.component.UniversalComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.example.ppdm_login.R


@Preview(showSystemUi = true)
@Composable
fun Header() {

    val camera = Icons.Default.PhotoCamera

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier
        ) {
            Text(
                text = "Sign Up",
                fontSize = 32.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF3347B0),
            )

            Text(
                text = "Create a new account",
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFFA09C9C),
            )
        }

        Box(
            modifier = Modifier.size(100.dp),
        ) {
            Card(
                modifier = Modifier
                    .size(100.dp)
                    .align(alignment = Alignment.Center),
                shape = CircleShape,
                border = BorderStroke(
                    width = 2.dp,
                    brush = Brush
                        .horizontalGradient(
                            colors = listOf(Color.Blue, Color.White)
                        )
                )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp),
                    contentScale = ContentScale.None,

                    )
            }
            Image(
                imageVector = camera,
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.BottomEnd)
                    .clickable {

                    },
            )
        }

    }
}