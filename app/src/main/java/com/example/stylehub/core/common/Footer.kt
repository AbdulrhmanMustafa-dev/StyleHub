package com.example.stylehub.core.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stylehub.R

@Composable
fun Footer(
    modifier: Modifier = Modifier
) {
    val email = "Semail@example.com"
    val phone = "01558739292"
    val timeToWork = "8:00 Am  To  8:00 Pm Eve"
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 32.dp, vertical = 24.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(
                painter = painterResource(id = R.drawable.youtube),
                contentDescription = "YouTube"
            )
            Icon(
                painter = painterResource(id = R.drawable.instagram),
                contentDescription = "Instagram"
            )
            Icon(
                painter = painterResource(id = R.drawable.twitter),
                contentDescription = "Twitter"
            )
        }
        Image(
            painter = painterResource(id = R.drawable._8),
            contentDescription = "image description",
            contentScale = ContentScale.None
        )
        Column(
            modifier = Modifier.padding(vertical = 18.dp, horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Email : $email",
                color = androidx.compose.ui.graphics.Color(0xFF000000),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Phone : $phone",
                color = androidx.compose.ui.graphics.Color(0xFF000000),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Working Hours : $timeToWork",
                color = androidx.compose.ui.graphics.Color(0xFF000000),
                modifier = Modifier.padding(bottom = 8.dp)
            )

        }
        Image(
            painter = painterResource(id = R.drawable._8),
            contentDescription = "image description",
            contentScale = ContentScale.None
        )
        Row(
            modifier = Modifier
                .padding(horizontal = 32.dp, vertical = 24.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TextButton(
                onClick = { /* TODO */ }
            ) {
                Text(
                    text = "About Us",
                    color = androidx.compose.ui.graphics.Color(0xFF000000)
                )
            }
            TextButton(
                onClick = { /* TODO */ }
            ) {
                Text(
                    text = "Contact",
                    color = androidx.compose.ui.graphics.Color(0xFF000000)
                )
            }
            TextButton(
                onClick = { /* TODO */ }
            ) {
                Text(
                    text = "Blog",
                    color = androidx.compose.ui.graphics.Color(0xFF000000)
                )
            }
        }
        Text(
            text = "Copyright© StyleHub 2024. All rights reserved.",
            color = androidx.compose.ui.graphics.Color(0xFF888888),
            modifier = Modifier.padding(bottom = 24.dp)
        )
    }
}
