package com.example.stylehub.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stylehub.domain.TrendingListTist

@Composable
fun Trending(
    modifier: Modifier = Modifier
) {
    Column(
        modifier =
            modifier
                .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "@Trending",
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 40.sp,
                fontFamily = FontFamily(Font(com.example.stylehub.R.font.tenorsans)),
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),
                textAlign = TextAlign.Center,
                letterSpacing = 4.sp,
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = com.example.stylehub.R.drawable._8),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(16.dp))
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            for (i in TrendingListTist.indices) {
                Box(
                    Modifier
                        .padding(0.5.dp)
                        .background(
                            color = Color(0xFFF9F9F9),
                            shape = RoundedCornerShape(size = 30.dp)
                        )
                        .padding(start = 10.dp, top = 8.dp, end = 10.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = TrendingListTist[i].title,
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 16.sp,
                            fontFamily = FontFamily(Font(com.example.stylehub.R.font.tenorsans)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF333333),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.14.sp,
                        )
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = com.example.stylehub.R.drawable._8),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}

//@Preview(name = "Trending")
//@Composable
//private fun PreviewTrending() {
//    Trending(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color.White)
//    )
//}
