package com.example.stylehub.core.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.stylehub.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(
    title: String,
    onMenuClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    onCartClick: () -> Unit,
) {

    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier =
                    Modifier
                        .fillMaxWidth(),
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                    )
                }
            }
        },
        navigationIcon = {
            IconButton(onClick = onMenuClick) {
                Icon(
                    painter = painterResource(R.drawable.menu),
                    contentDescription = "Menu",
                )
            }
        },
        actions = {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Search",
            )
            Spacer(modifier.width(16.dp))
            Icon(
                painter = painterResource(id = R.drawable.shopping_bag),
                contentDescription = "shopping_bag",
                modifier = Modifier.clickable(
                    onClick = onCartClick
                )
            )
        },
    )
}
