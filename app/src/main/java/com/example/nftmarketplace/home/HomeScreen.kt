package com.example.nftmarketplace.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nftmarketplace.ui.theme.NFTMarketplaceTheme


@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                content = {
                    Text(
                        "NFT Marketplace",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp,
                        color = Color.White
                    )
                },
                backgroundColor = Color.Transparent,
                elevation = 0.dp
            )
        },
        backgroundColor = Color(33, 17, 52)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            CategoryList()
            Text(
                text = "Trending collections",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
            CollectionList()
            Text(
                text = "Top sellers",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
            NFTList()
        }
    }
}


@Preview
@Composable
fun PreviewHomeScreen() {
    NFTMarketplaceTheme {
        HomeScreen()
    }
}