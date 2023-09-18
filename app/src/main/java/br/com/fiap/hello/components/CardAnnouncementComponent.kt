package br.com.fiap.hello.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.hello.R
import br.com.fiap.hello.ui.theme.RobotoRegular

@Composable
fun CardAnnouncementComponent(
    id: Int,
    listingTitle: String,
    image: Int,
    displayNumber: Int,
    date: String,
    navController: NavController
) {
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF7F7F7)),
        onClick = {
            navController.navigate("announcement?announcementId=$id")
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .width(342.dp)
                .height(70.dp)
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 13.dp))
                .padding(all = 16.dp)

        ) {
            Image(
                modifier = Modifier
                    .width(37.dp)
                    .height(37.dp)
                    .background(color = Color(0xFF56B1E0), shape = RoundedCornerShape(size = 5.dp)),
                painter = painterResource(id = image),
                contentDescription = "Imagem de uma pessoa",
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .width(190.dp)
                    .height(60.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = listingTitle,
                    fontFamily = RobotoRegular,
                    fontSize = 15.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF252525),
                )

                Text(
                    text = displayNumber.toString() + " visualizações",
                    fontFamily = RobotoRegular,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFFA9ABAD)
                )
            }

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .width(80.dp)
                    .height(32.dp)
            ) {
                Text(
                    modifier = Modifier.width(40.dp),
                    text = date,
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFFA9ABAD),
                )

                Spacer(modifier = Modifier.width(5.dp))

                Image(
                    modifier = Modifier
                        .width(16.dp)
                        .height(16.dp),
                    painter = painterResource(id = R.drawable.chevron_right),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }
        }
    }
}