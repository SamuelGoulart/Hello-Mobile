package br.com.fiap.hello.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.hello.R
import br.com.fiap.hello.ui.theme.RobotoBold

@Composable
fun SplashScreen(navaController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEFEFEF))
    ) {

        Image(
            painter = painterResource(id = R.drawable.splash_background),
            contentDescription = "Imagem de background",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_hello),
                contentDescription = "Logo hello",
                modifier = Modifier
                    .width(93.dp)
                    .height(50.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 55.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF329B90)),
                modifier = Modifier
                    .width(339.dp)
                    .height(60.dp)
                    .background(
                        color = Color(0xFF329B90),
                        shape = RoundedCornerShape(size = 16.dp)
                    ),
                onClick = {
                    navaController.navigate("login")
                }
            ) {
                Text(
                    text = "Login",
                    fontSize = 24.sp,
                    fontFamily = RobotoBold,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            StyledTextWithBoldAndUnderlineSplashScreen()

        }
    }
}


@Composable
fun StyledTextWithBoldAndUnderlineSplashScreen() {
    val text = buildAnnotatedString {
        append(" Não tem conta? ")

        withStyle(style = SpanStyle(
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )) {
            append("Cadastre-se")
        }
    }

    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight(700),
        fontFamily = RobotoBold,
        color = Color(0xFFFFFFFF)
    )
}