package com.example.ppdm_login

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.ppdm_login.component.Screen.SymbianScreen
import com.example.ppdm_login.component.UniversalComponents.ButtonInsert
import com.example.ppdm_login.component.UniversalComponents.TextBoxScreen
import com.example.ppdm_login.component.UniversalComponents.TextFieldPasswordScreen
import com.example.ppdm_login.fuctions.ConvertFirebase
import com.example.ppdm_login.repository.CadastroRepository
import com.example.ppdm_login.ui.theme.PPDMLoginTheme
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PPDMLoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val camera = Icons.Default.PhotoCamera


                    val context = LocalContext.current

                    var fotoUri by remember {
                        mutableStateOf<Uri?>(null)
                    }

                    Log.e("Aqui", "passei aqiu ")

                    val painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(context).data(fotoUri).build()
                    )

                    var imagem by remember {
                        mutableStateOf("https://icones.pro/wp-content/uploads/2021/02/icone-utilisateur-gris.png")
                    }

                    var email by remember {
                        mutableStateOf("")
                    }

                    var senha by remember {
                        mutableStateOf("")
                    }

                    val launcher = rememberLauncherForActivityResult(
                        contract = ActivityResultContracts.GetContent()
                    ) { uri ->
                        uri.let {

                            fotoUri = it
                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row (Modifier.fillMaxWidth().height(40.dp), horizontalArrangement = Arrangement.End){
                            Row(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(40.dp)
                                    .background(color = Color(0xFF3347B0), shape = RoundedCornerShape(0.dp, 0.dp, 0.dp, 16.dp))
                            ) {}
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Column(
                                modifier = Modifier,
                                horizontalAlignment = Alignment.CenterHorizontally
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
                                        .align(alignment = Alignment.BottomEnd)
                                        .clickable {
                                            launcher.launch("image/*")
                                        },
                                    shape = CircleShape,
                                    border = BorderStroke(
                                        width = 2.dp,
                                        brush = Brush
                                            .horizontalGradient(
                                                colors = listOf(Color.Blue, Color.White)
                                            )
                                    )
                                ) {
                                    AsyncImage(
                                        model = if(fotoUri == null){
                                                    imagem
                                                    }else{
                                                         fotoUri
                                                         },


                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale = ContentScale.None,
                                    )
                                }
                                Log.e("morri", "Header: ${imagem}")
                                Image(
                                    imageVector = camera,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(30.dp)
                                        .align(Alignment.BottomEnd),
                                )
                                Log.e("Aquiiiii", "Header: ${imagem}")
                            }

                        }
                        Column(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            TextBoxScreen(
                                label = "Email",
                                valor = email,
                                aoMudar = {
                                    email = it
                                }
                            )
                            TextFieldPasswordScreen(
                                label = "Senha",
                                valor = senha,
                                aoMudar = {
                                    senha = it
                                }
                            )
                            ButtonInsert(text = "Create Account") {
                                val storageReference: StorageReference = FirebaseStorage.getInstance().reference.child("images")

                                val firebaseFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()

                                var imagemUrl: String = ""

                                val storageRef = storageReference.child("${fotoUri!!.lastPathSegment}-${System.currentTimeMillis()}.jpg")
                                storageRef.putFile(fotoUri!!).addOnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                        storageRef.downloadUrl.addOnSuccessListener { downloadUri ->
                                            val map = hashMapOf("pic" to downloadUri.toString())
                                            firebaseFirestore.collection("images").add(map).addOnCompleteListener { firestoreTask ->
                                                if (firestoreTask.isSuccessful) {
                                                    Log.e("Firebase", "Foto adicionada", )
                                                    Toast.makeText(context, "FOTO ADICIONADA COM SUCESSO", Toast.LENGTH_SHORT).show()
                                                } else {
                                                    Log.e("Firebase", "Erro, ${firestoreTask.result}", )
                                                    Toast.makeText(context, "ERRO AO TENTAR REALIZAR O UPLOAD", Toast.LENGTH_SHORT).show()
                                                }
                                            }
                                        }
                                    } else {
                                        Toast.makeText(context, "ERRO AO TENTAR REALIZAR O UPLOAD", Toast.LENGTH_SHORT).show()
                                    }
                                }

                                firebaseFirestore.collection("images")
                                    .get().addOnSuccessListener {
                                        for(i in it){
                                            if(it.last() == i){
                                                imagemUrl = i.data["pic"].toString()

                                                lifecycleScope.launch {
                                                    CadastroRepository().cadastroUsuario(email, senha, imagemUrl)
                                                }
                                            }
                                        }
                                    }
                            }
                        }
                        Row (Modifier.fillMaxWidth().height(40.dp), horizontalArrangement = Arrangement.Start){
                            Row(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(40.dp)
                                    .background(color = Color(0xFF3347B0), shape = RoundedCornerShape(0.dp, 16.dp, 0.dp, 0.dp))
                            ) {}
                        }
                    }

                }
            }
        }
    }
}