package br.com.fiap.hello.screens

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.core.util.PatternsCompat
import androidx.navigation.NavController
import br.com.fiap.hello.R
import br.com.fiap.hello.model.User
import br.com.fiap.hello.service.AuthRequest
import br.com.fiap.hello.service.RetrofitFactory
import br.com.fiap.hello.ui.theme.RobotoBold
import br.com.fiap.hello.ui.theme.RobotoRegular
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun LoginScreen(navaController: NavController) {

    var userState by remember {
        mutableStateOf<User?>(null)
    }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var isEmailValid by remember { mutableStateOf(true) }
    var isLoginValid by remember { mutableStateOf(true) }
    var isPasswordValid by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F7))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 60.dp)
                .fillMaxWidth()
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF7F7F7)),
                onClick = {
                    navaController.navigate("splash")
                }
            ) {
                Image(
                    modifier = Modifier
                        .width(44.dp)
                        .height(19.dp),
                    painter = painterResource(id = R.drawable.arrow),
                    contentDescription = "Botão de voltar"
                )
            }

            Text(
                text = stringResource(id = R.string.to_enter),
                fontSize = 16.sp,
                fontWeight = FontWeight(700),
                fontFamily = RobotoBold,
                color = Color(0xFF252525),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(end = 50.dp)
                    .weight(1f)
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 220.dp)
                .fillMaxSize(),
        ) {

            if (!isLoginValid) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = stringResource(id = R.string.invalid_email_and_or_password),
                    color = Color.Red,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                modifier = Modifier.padding(start = 20.dp),
                text = "Bem-vindo,\nInsira seu e-mail",
                lineHeight = 1.2.em,
                fontSize = 32.sp,
                color = Color(0xFF252525),
                fontFamily = RobotoBold,
                fontWeight = FontWeight(700)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.sub_welcome),
                fontSize = 20.sp,
                fontFamily = RobotoRegular,
                fontWeight = FontWeight(400),
                color = Color(0xFF848688),
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                Arrangement.Center
            ) {

                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                        isEmailValid = true
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
                    label = {
                        Text(
                            text = stringResource(id = R.string.outlined_text_field_email_label),
                            color = Color(0xffa9abad),
                            fontFamily = RobotoRegular,
                            fontSize = 14.sp
                        )
                    },
                    isError = !isEmailValid,
                    modifier = Modifier
                        .width(width = 400.dp)
                        .clip(shape = RoundedCornerShape(8.dp))
                        .padding(16.dp, 16.dp, 16.dp, 4.dp)
                )

                if (!isEmailValid) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = stringResource(id = R.string.invalid_email),
                        color = Color.Red,
                        textAlign = TextAlign.Center
                    )
                }

                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                        isPasswordValid = true
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
                    label = {
                        Text(
                            text = stringResource(id = R.string.outlined_text_field_password_label),
                            color = Color(0xffa9abad),
                            fontFamily = RobotoRegular,
                            fontSize = 14.sp
                        )
                    },
                    isError = !isPasswordValid,
                    modifier = Modifier
                        .width(width = 400.dp)
                        .clip(shape = RoundedCornerShape(8.dp))
                        .padding(16.dp, 4.dp, 16.dp, 16.dp)
                )


                if (!isPasswordValid) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = stringResource(id = R.string.invalid_password),
                        color = Color.Red,
                        textAlign = TextAlign.Center
                    )
                }
            }

            StyledTextWithBoldAndUnderline()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF329B90)),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(color = Color(0xFF329B90)),
            onClick = {
                if (isValidEmail(email) && isValidPassword(password)) {
                    val requestBody = AuthRequest(
                        email = email,
                        password = password
                    )

                    var call = RetrofitFactory().authService().auth(requestBody)

                    call.enqueue(object : Callback<User> {
                        override fun onResponse(
                            call: Call<User>,
                            response: Response<User>
                        ) {
                            if (response.isSuccessful) {
                                val responseBody = response.body()
                                if (responseBody != null) {
                                    userState = responseBody
                                    navaController.navigate("listOfAnnouncements")
                                } else {
                                    Log.e("FIAP", "Response body is null")
                                }
                            } else {
                                isLoginValid = false;
                                Log.e("FIAP", "Unsuccessful response: ${response.code()}")
                            }
                        }

                        override fun onFailure(call: Call<User>, t: Throwable) {
                            Log.e("FIAP", "onFailure: ${t.message}")
                        }
                    })

                }

                if (!isValidEmail(email)) {
                    isEmailValid = false
                }

                if (!isValidPassword(password)) {
                    isPasswordValid = false
                }
            }
        ) {
            Text(
                text = stringResource(id = R.string.advance),
                fontSize = 24.sp,
                fontFamily = RobotoBold,
                fontWeight = FontWeight(700),
                color = Color(0xFFFFFFFF),
            )
        }
    }

}

private fun isValidEmail(email: String): Boolean {
    val pattern = PatternsCompat.EMAIL_ADDRESS
    return pattern.matcher(email).matches()
}

private fun isValidPassword(password: String): Boolean {
    return password.length >= 5
}


@Composable
fun StyledTextWithBoldAndUnderline() {
    val text = buildAnnotatedString {
        append("Utilizar o ")
        withStyle(
            style = SpanStyle(
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.Bold
            )
        ) {
            append("telefone")
        }
    }

    Text(
        text = text,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight(400),
        color = Color(0xFFA9ABAD),
        fontSize = 16.sp,
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun LoginScreenPreview() {
    val navController = rememberAnimatedNavController()
    LoginScreen(navController)
}
