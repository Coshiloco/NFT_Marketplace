package com.example.nftmarketplace.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.nftmarketplace.R
import com.example.nftmarketplace.ui.theme.NFTMarketplaceTheme


@Composable
fun CategoryCard(title: String, image: Painter) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(27.dp))
            .border(
                width = 1.dp,
                color = Color.White.copy(0.5f),
                shape = RoundedCornerShape(27.dp)
            )
            .height(186.dp)
            .width(280.dp)
    ) {
        Image(
            painter = image,
            contentDescription = "Card Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = title,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        )
    }
}



@Preview
@Composable
fun PreviewCategoryCard() {
    NFTMarketplaceTheme {
        Column() {
            CategoryCard("Art", painterResource(id = R.drawable.card_art))
            Spacer(modifier = Modifier.padding(16.dp))
            CategoryCard("Music", painterResource(id = R.drawable.card_music))
            Spacer(modifier = Modifier.padding(16.dp))
            CategoryCard("Virtual Worlds", painterResource(id = R.drawable.card_vw))
        }
    }
}