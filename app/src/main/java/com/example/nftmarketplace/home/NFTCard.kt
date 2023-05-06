package com.example.nftmarketplace.home

import com.example.nftmarketplace.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.nftmarketplace.models.nfts
import com.example.nftmarketplace.ui.theme.NFTMarketplaceTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun NFTCard(
    title: String,
    subtittle: String,
    image: Painter,
    liked: Int,
    eth: Double
) {
    var isLiked by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .height(262.dp)
            .width(175.dp)
            .border(
                1.dp,
                Color.White.copy(0.5f),
                RoundedCornerShape(30.dp)
            )
            .clip(RoundedCornerShape(30.dp))
            .background(Color.White.copy(0.2f))
    ) {
        Image(painter = image,
            contentDescription = "",
            modifier = Modifier
                .height(155.dp)
                .width(155.dp)
                .padding(10.dp)
                .border(
                    1.dp,
                    color = Color.Transparent,
                    shape = RoundedCornerShape(27.dp)
                )
                .fillMaxSize()
                .clip(RoundedCornerShape(27.dp)),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .padding(bottom = 10.dp)
        ) {
            Text(text = title,
                color = Color.White,
                fontSize = 13.sp,
                textAlign = TextAlign.Left
            )
            Text(text = subtittle,
                color = Color(235, 235, 245).copy(0.6f),
                fontSize = 12.sp,
                textAlign = TextAlign.Left
            )
        }
        Row(
            modifier = Modifier.padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_eth),
                    contentDescription = "Etherium Icon"
                )
                Text(
                    eth.toString(),
                    color = Color.White,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Left
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconToggleButton(checked = isLiked,
                    onCheckedChange = {
                        isLiked = !isLiked
                    }, modifier = Modifier.size(13.dp)) {
                    Icon(
                        tint = if (isLiked) {
                            Color.Red
                        } else {
                            Color(235, 235, 245).copy(0.6f)
                        },
                        imageVector = if (isLiked) { Icons.Filled.Favorite } else {Icons.Default.FavoriteBorder},
                        contentDescription = ""
                    )
                }
                Text(
                    liked.toString(),
                    color = Color(235, 235, 245).copy(0.6f),
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Right
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewNFTCard() {
    NFTMarketplaceTheme {
        NFTCard(title = nfts[0].title,
            subtittle = nfts[0].subtitle,
            image = painterResource(id = nfts[0].image),
            liked = nfts[0].likes,
            eth = nfts[0].eth)
    }
}