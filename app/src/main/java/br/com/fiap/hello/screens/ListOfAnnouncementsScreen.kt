package br.com.fiap.hello.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.hello.R
import br.com.fiap.hello.components.CardAnnouncementComponent
import br.com.fiap.hello.model.Announcements
import br.com.fiap.hello.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun ListOfAnnouncementsScreen(navController: NavController) {
    var listaAnnouncementState by remember {
        mutableStateOf<Announcements?>(null)
    }

    var call = RetrofitFactory().announcementService().getAllAnnouncement()

    call.enqueue(object : Callback<Announcements> {
        override fun onResponse(
            call: Call<Announcements>,
            response: Response<Announcements>
        ) {
            if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody != null) {
                    listaAnnouncementState = responseBody
                }
            } else {
                Log.e("FIAP", "Unsuccessful response: ${response.code()}")
            }
        }

        override fun onFailure(call: Call<Announcements>, t: Throwable) {
            Log.e("FIAP", "onFailure: ${t.message}")
        }
    })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F7))
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
                    navController.navigate("login")
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
                text = stringResource(id = R.string.list_of_announcements),
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

        if (listaAnnouncementState?.payload != null) {
            Log.e("FIAP", "$listaAnnouncementState")
            AnnouncementList(listaAnnouncementState!!.payload, navController)
        } else {
            // TODO: Adicione lógica para lidar com o estado nulo ou payload nulo
        }
    }
}

@Composable
fun AnnouncementList(
    listAnnouncements: List<Announcements.Payload>,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (announcement in listAnnouncements) {
            CardAnnouncementComponent(
                id = announcement.announcementId,
                listingTitle = announcement.listingTitle,
                displayNumber = announcement.displayNumber,
                date = announcement.date,
                image = R.drawable.person_blue,
                navController = navController,
            )
        }
    }
}
