package br.com.fiap.hello.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.hello.R
import br.com.fiap.hello.repository.getAnnouncementById
import br.com.fiap.hello.ui.theme.RobotoBold
import br.com.fiap.hello.ui.theme.RobotoRegular

@Composable
fun AnnouncementScreen(id: Int, navController: NavController) {
    val getAnnouncementByIdState = remember {
        mutableStateOf(getAnnouncementById(id = id))
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color(0xFFF7F7F7)),
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxWidth()
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF7F7F7)),
                onClick = {
                    navController.navigate("listOfAnnouncements")
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
                text = "Novo comunicado",
                fontSize = 16.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF252525),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(1f)
            )

            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF7F7F7)),
                onClick = {}
            ) {
                Image(
                    modifier = Modifier
                        .width(44.dp)
                        .height(19.dp),
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "Botão de Menu"
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier
                .width(340.dp)
                .height(50.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Image(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                painter = painterResource(id = R.drawable.person),
                contentDescription = "Imagem da pessoa que envio o comunicado",
                contentScale = ContentScale.FillBounds
            )

            Column() {
                Text(
                    text = "Sarah Connor, dir.",
                    fontSize = 20.sp,
                    fontFamily = RobotoRegular,
                    color = Color(0xFF252525),
                )
                Text(
                    text = "Para: ${getAnnouncementByIdState.value!!.category}",
                    fontSize = 17.sp,
                    fontFamily = RobotoRegular,
                    color = Color(0xFFA9ABAD),
                )
            }

            Text(
                text = getAnnouncementByIdState.value!!.time.toString(),
                fontSize = 17.sp,
                fontFamily = RobotoRegular,
                color = Color(0xFFA9ABAD),
            )

        }

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Divider(
                modifier = Modifier
                    .width(310.dp)
                    .height(1.dp)
                    .background(color = Color(0xFFE6E7E8)),
                thickness = 1.dp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier
                    .width(340.dp),
                text = getAnnouncementByIdState.value!!.title,
                fontSize = 22.sp,
                fontFamily = RobotoBold,
                color = Color(0xFF252525),
            )

            if (getAnnouncementByIdState.value!!.description !== null) {
                Text(
                    modifier = Modifier
                        .width(340.dp),
                    text = getAnnouncementByIdState.value!!.description.toString(),
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    fontFamily = RobotoRegular,
                    color = Color(0xFF000000),
                )

            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val id = getAnnouncementByIdState.value!!.id
            val height = if (id == 1) 481 else 280

            Image(
                modifier = Modifier
                    .width(340.dp)
                    .height(height.dp),
                painter = painterResource(id = getAnnouncementByIdState.value!!.imageAnnouncement),
                contentDescription = "image description",
            )
        }
    }
}


