package com.example.stylehub.presentation.category.components

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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import com.example.stylehub.R
import com.example.stylehub.core.ui.theme.body
import com.example.stylehub.domain.models.ProductModel

@Composable
fun Filter(
    modifier: Modifier = Modifier,
    products: List<ProductModel>,
    onFilterClick: () -> Unit,
    hasFilter: List<String>,
    onListView: () -> Unit,
    ondateClick: () -> Unit,
    onFilterCloseClick: () -> Unit
) {
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start
        ) {

            Text(
                modifier = Modifier.align(Alignment.CenterVertically),
                text = "${products.size} Apparel",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 14.84.sp,
                    fontFamily = FontFamily(Font(R.font.tenorsans)),
                    fontWeight = FontWeight(400),
                    color = body,
                    textAlign = TextAlign.Center,
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            TextButton(
                onClick = ondateClick,
                shape = ButtonDefaults.outlinedShape,
                colors = ButtonDefaults.textButtonColors(
                    contentColor = body
                )
            ) {
                Row(
                    modifier = Modifier.padding(4.dp)
                ) {
                    Text(
                        "NEW"
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.down),
                        contentDescription = null
                    )
                }
            }
            IconButton(
                modifier = Modifier.padding(horizontal = 4.dp),
                onClick = onListView
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.listview),
                    contentDescription = null
                )
            }

            IconButton(
                modifier = Modifier.padding(horizontal = 4.dp),
                onClick = onFilterClick
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.filter),
                    contentDescription = null
                )
            }

        }
        Spacer(modifier = Modifier.height(8.dp))
        if (hasFilter.isNotEmpty()) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                hasFilter.forEach { filter ->
                    Box(
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Color(0xFFDEDEDE),
                                shape = RoundedCornerShape(size = 30.dp)
                            )
                            .padding(4.dp)
                            .wrapContentWidth(
                                Alignment.CenterHorizontally
                            )
                            .height(32.dp)
                            .padding(start = 10.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
                    ) {
                        Row(
                            modifier = Modifier.wrapContentWidth(
                                Alignment.CenterHorizontally
                            ),
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                modifier = Modifier.padding(horizontal = 4.dp),
                                text = filter,
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 14.84.sp,
                                    fontFamily = FontFamily(Font(R.font.tenorsans)),
                                    fontWeight = FontWeight(400),
                                    color = body,
                                    textAlign = TextAlign.Center,
                                )
                            )
//                                 Spacer(modifier = Modifier.weight(1f))
                            Icon(
                                modifier = Modifier.padding(horizontal = 4.dp).clickable(
                                    onClick = onFilterCloseClick
                                ),
                                painter = painterResource(id = R.drawable.close),
                                contentDescription = null
                            )
                        }


                    }
                }
            }
        }
    }
}
