package com.example.afya.ui.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.afya.ui.theme.AfyaCream
import com.example.afya.ui.theme.AfyaDark
import com.example.afya.R
import com.example.afya.ui.theme.AfyaWhite

data class NavItem(
    val title: String,
    @DrawableRes val iconResId: Int,
    val route: String
)

val navItems = listOf(
    NavItem(
        title = "Dental",
        iconResId = R.drawable.tooth,
        route = "home"
    ),
    NavItem(
        title = "Eye",
        iconResId = R.drawable.eye,
        route = "publications"
    ),
    NavItem(
        title = "Skin",
        iconResId = R.drawable.dermis,
        route = "settings_screen"
    ),
    NavItem(
        title = "ENT",
        iconResId = R.drawable.pharynx,
        route = "settings_screen"
    ),
    NavItem(
        title = "Heart",
        iconResId = R.drawable.heart,
        route = "settings_screen"
    ),
    NavItem(
        title = "Digestive",
        iconResId = R.drawable.stomach,
        route = "settings_screen"
    ),
    NavItem(
        title = "Bones",
        iconResId = R.drawable.spine,
        route = "settings_screen"
    ),
    NavItem(
        title = "Respiratory",
        iconResId = R.drawable.lungs,
        route = "settings_screen"
    )
)

@Composable
fun QuickHelp(onNavItemClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(color = AfyaCream)
            .padding(16.dp),

        ) {
        Text(
            "Quick Help",
            color = AfyaDark,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.padding(10.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
//            modifier = Modifier.border(1.dp, AfyaDark),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            // Sets the space between each item vertically
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(navItems) { navItem ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(
                            color = AfyaWhite,
                        )
                        .clickable(
                            onClick = { onNavItemClick(navItem.route) },
                        )
                ) {
                    Image(
                        painter = painterResource(id = navItem.iconResId),
                        contentDescription = null,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = navItem.title,
                        color = AfyaDark,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun QuickHelpPreview() {
    QuickHelp(
        onNavItemClick = {}
    )
}