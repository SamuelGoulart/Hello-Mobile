package br.com.fiap.hello.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.hello.R
import br.com.fiap.hello.components.CardAnnouncementComponent
import br.com.fiap.hello.model.Announcement
import br.com.fiap.hello.repository.getAllAnnouncementList

@Composable
fun ListOfAnnouncementsScreen(navController: NavController) {

    var listaAnnouncementState = remember {
        mutableStateOf(getAllAnnouncementList())
    }

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
                text = "Lista de comunicados",
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

        AnnouncementList(listaAnnouncementState, navController)

    }
}

@Composable
fun AnnouncementList(
    listAnnouncements: MutableState<List<Announcement>>,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        for (announcement in listAnnouncements.value) {
            CardAnnouncementComponent(
                id = announcement.id,
                listingTitle = announcement.listingTitle,
                displayNumber = announcement.displayNumber,
                date = announcement.date,
                image = announcement.image,
                navController = navController,
            )
        }
    }
}