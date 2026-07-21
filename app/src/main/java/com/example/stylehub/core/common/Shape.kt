package com.example.stylehub.core.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.getColor
import androidx.graphics.shapes.RoundedPolygon
import androidx.graphics.shapes.toPath

@Composable
fun TriangleShape(
    modifier: Modifier = Modifier,
    color :Int
) {
    val localContext =  androidx.compose.ui.platform.LocalContext.current
    Box(
        modifier =
            Modifier
                .drawWithCache {
                    val TriangleShape = RoundedPolygon(
                        numVertices = 4,
                        radius = size.minDimension / 2f,
                        centerX = size.width / 2f,
                        centerY = size.height / 2f
                    )
                    val TriangleShapePath =
                        TriangleShape.toPath().asComposePath()
                    onDrawBehind {
                        drawPath(
                            path = TriangleShapePath,
                            color = Color(
                                getColor(
                                    localContext,
                                    color
                                )
                            )
                        )
                    }
                }
                .height(8.dp)
                .width(16.dp)



    )
}
