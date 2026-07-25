package com.example.stylehub.presentation.productdetail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stylehub.core.ui.theme.inputBackGrounColor
import com.example.stylehub.core.ui.theme.offWhiteColor
import com.example.stylehub.core.ui.theme.titleActive

@Composable
fun AdderButton(
    modifier: Modifier = Modifier,
    addButtonOnclick: () -> Unit,
    heartButtonOnclick: () -> Unit
) {
    Box(
        modifier = modifier
            .background(
                color = titleActive
            )
            .clip(
                RoundedCornerShape(16.dp)
            )
            .padding(vertical = 8.dp, horizontal = 12.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            TextButton(
                onClick = addButtonOnclick

            ) {
                Icon(
                    painter = androidx.compose.ui.res.painterResource(id = com.example.stylehub.R.drawable.plus),
                    contentDescription = "Plus",
                    tint = inputBackGrounColor
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Add to basket",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily(Font(com.example.stylehub.R.font.tenorsans)),
                        fontWeight = FontWeight(400),
                        color = offWhiteColor,
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.14.sp,
                    )
                )
            }
            Spacer(modifier = Modifier.weight(1F))
            IconButton(
                onClick = heartButtonOnclick,
                modifier = Modifier.padding(8.dp)
            ) {
                Icon(
                    painter = androidx.compose.ui.res.painterResource(id = com.example.stylehub.R.drawable.heart),
                    contentDescription = "Heart",
                    tint = inputBackGrounColor,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }
}

@Preview(name = "AdderButton")
@Composable
private fun PreviewAdderButton() {
    AdderButton(
        addButtonOnclick = {},
        heartButtonOnclick = {}
    )
}
