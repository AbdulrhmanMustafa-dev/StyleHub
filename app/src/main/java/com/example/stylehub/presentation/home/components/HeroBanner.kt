package com.example.stylehub.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getColor
import com.example.stylehub.R
import com.example.stylehub.core.ui.theme.placeHolderColor
import com.example.stylehub.core.ui.theme.secondaryColor
import com.example.stylehub.domain.models.BannerModel
import kotlinx.coroutines.launch

@Composable
fun HeroBanner(modifier: Modifier = Modifier, bannerList: List<BannerModel>) {
    val pagerState =
        androidx.compose.foundation.pager.rememberPagerState(pageCount = { bannerList.size })
    val coroutineScope = rememberCoroutineScope()
    val localContext = androidx.compose.ui.platform.LocalContext.current
    Box(
        modifier =
            modifier
                .fillMaxWidth()
                .height(600.dp),
        contentAlignment = Alignment.Center,
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.image_10),
                contentDescription = "Hero Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth(),
            )
        }

        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(600.dp)
                    .background(Color.Black.copy(alpha = 0.2f)),
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 24.dp),
        ) {
            Text(
                text = "LUXURY\nFASHION\n& ACCESSORIES",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                lineHeight = 40.sp,
            )

            Spacer(modifier = Modifier.height(128.dp))

            Button(
                onClick = { /* TODO: Navigate to collection */ },
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = Color(0x99000000),
                    ),
                shape = RoundedCornerShape(50),
            ) {
                Text(
                    text = "EXPLORE COLLECTION",
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(bannerList.size) { iteration ->
                    val color =
                        if (pagerState.currentPage == iteration) R.color.Secondary else R.color.Offwhite

                    Box(
                        modifier =
                            Modifier
                                .padding(horizontal = 6.dp)
                                .rotate(45f)
                                .background(Color(getColor(localContext, color)))
                                .size(8.dp)
                                .padding(16.dp)
                                .border(
                                    width = 1.dp,
                                    color = if (pagerState.currentPage == iteration) secondaryColor else placeHolderColor,
                                    shape = androidx.compose.foundation.shape.RoundedCornerShape(4.dp)
                                )
                                .clickable(
                                    onClick = {
                                        coroutineScope.launch {
                                            pagerState.animateScrollToPage(page = iteration)
                                        }
                                    }
                                ),
                    ) {

                    }
                }
            }
        }
    }
}


@Preview
@Composable
private fun test() {
    HeroBanner(
        modifier = Modifier.background(Color(0xFFFFFFFF)),
        bannerList = listOf(
            BannerModel(
                id = 1,
                image = R.drawable.image_10,

                ),
            BannerModel(
                id = 2,
                image = R.drawable.image_10,

                ),
            BannerModel(
                id = 3,
                image = R.drawable.image_10,

                )
        )
    )
}
