package com.app.imageslider

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@Composable
fun ProductImagePager(imageUrls: List<String>) {
    val pagerState = rememberPagerState()
    Box {
        HorizontalPager(
            count = imageUrls.size,
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            AsyncImage(
                model = imageUrls[page],
                contentDescription = "Product Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        // Optional indicator
//        HorizontalPagerIndicator(
//            pagerState = pagerState,
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//                .padding(8.dp)
//        )
//        Row(
//            horizontalArrangement = Arrangement.End,
//            modifier = Modifier
//                .align(Alignment.BottomEnd)
//                .padding(16.dp)
//        ) {
//            repeat(imageUrls.size) { index ->
//                val isSelected = pagerState.currentPage == index
//                Box(
//                    modifier = Modifier
//                        .padding(horizontal = 4.dp)
//                        .size(if (isSelected) 10.dp else 8.dp)
//                        .clip(CircleShape)
//                        .background(if (isSelected) Color.White else Color.Gray)
//                )
//            }
//        }

//        Box(
//            modifier = Modifier
//                .align(Alignment.BottomEnd)
//                .padding(10.dp)
//                .background(
//                    color = Color.Black.copy(alpha = 0.5f),
//                    shape = RoundedCornerShape(12.dp)
//                )
//                .padding(horizontal = 8.dp, vertical = 4.dp)
//        ) {
//            Row(
//                horizontalArrangement = Arrangement.spacedBy(8.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                repeat(imageUrls.size) { index ->
//                    val isSelected = pagerState.currentPage == index
//                    Box(
//                        modifier = Modifier
//                            .size(if (isSelected) 10.dp else 8.dp)
//                            .clip(CircleShape)
//                            .background(if (isSelected) Color.White else Color.Gray)
//                    )
//                }
//            }
//        }

        val visibleIndicators = 5
        val currentPage = pagerState.currentPage
        val totalPages = imageUrls.size

        // Calculate indicator start index
        val startIndex = when {
            totalPages <= visibleIndicators -> 0
            currentPage <= 2 -> 0
            currentPage >= totalPages - 3 -> totalPages - visibleIndicators
            else -> currentPage - 2
        }
        val indicatorsToShow = (startIndex until (startIndex + visibleIndicators).coerceAtMost(totalPages)).toList()

        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(10.dp)
                .background(Color.Black.copy(alpha = 0.5f), shape = RoundedCornerShape(12.dp))
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                indicatorsToShow.forEach { index ->
                    val isSelected = index == currentPage
                    Box(
                        modifier = Modifier
                            .size(if (isSelected) 10.dp else 8.dp)
                            .clip(CircleShape)
                            .background(if (isSelected) Color.White else Color.Gray)
                    )
                }
            }
        }
    }
}


