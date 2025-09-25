package com.example.afya.ui.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.automirrored.rounded.ArrowForwardIos
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.afya.ui.theme.AfyaBlue
import com.example.afya.ui.theme.AfyaWhite
import com.example.afya.R
import kotlinx.coroutines.launch

data class Doctor(
    val title: String,
    @DrawableRes val iconResId: Int,
    val route: String
)

@Composable
fun Consult() {
    val doctors = listOf(
        Doctor(
            title = "Dr. John Doe",
            iconResId = R.drawable.doc_1,
            route = "home"
        ),
        Doctor(
            title = "Dr. Jane Smith",
            iconResId = R.drawable.doc_2,
            route = "publications"
        ),
        Doctor(
            title = "Dr. Michael Johnson",
            iconResId = R.drawable.doc_3,
            route = "settings_screen"
        ),
        Doctor(
            title = "Dr. Sarah Williams",
            iconResId = R.drawable.doc_4,
            route = "settings_screen"
        ),
        Doctor(
            title = "Dr. David Brown",
            iconResId = R.drawable.doc_5,
            route = "settings_screen"
        )
    )
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState { doctors.size }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(color = AfyaWhite)
            .padding(16.dp)
    ) {
        Row {
            Text("Consult", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.ArrowBackIos,
                contentDescription = "Arrow Backward",
                tint = AfyaBlue,
                modifier = Modifier.clickable() {
                    coroutineScope.launch {
                        val previousPage = (pagerState.currentPage - 1).coerceAtLeast(0)
                        pagerState.animateScrollToPage(previousPage)
                    }
                }
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.ArrowForwardIos,
                contentDescription = "Arrow Forward",
                tint = AfyaBlue,
                modifier = Modifier.clickable() {
                    coroutineScope.launch {
                        val nextPage = (pagerState.currentPage + 1).coerceAtMost(doctors.lastIndex-1)
                        pagerState.animateScrollToPage(nextPage)
                    }
                }
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(end = 200.dp),
            pageSpacing = 8.dp,
            modifier = Modifier.fillMaxWidth()
        )
        { page ->
            Column(modifier = Modifier.wrapContentWidth()) {

                Image(
                    painter = painterResource(id = doctors[page].iconResId),
                    contentDescription = null,
                )
                Text(
                    text = doctors[page].title,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun ConsultPreview() {
    Consult()
}