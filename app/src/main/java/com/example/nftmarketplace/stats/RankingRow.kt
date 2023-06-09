package com.example.nftmarketplace.stats

import androidx.compose.foundation.Image
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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nftmarketplace.R
import com.example.nftmarketplace.models.rankings
import com.example.nftmarketplace.ui.theme.NFTMarketplaceTheme


@Composable
fun RankingRow(
    index: Int,
    title: String,
    image: Int,
    change: Double,
    eth: Double
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = (index + 1).toString(),
            fontSize = 15.sp,
            color = Color(235, 235, 245).copy(0.6f),
            modifier = Modifier.padding(end = 10.dp)
        )

        Image(
            painter = painterResource(id = image),
            contentDescription = "",
            modifier = Modifier
                .padding(vertical = 11.dp)
                .padding(end = 15.dp)
                .height(44.dp)
                .width(44.dp)
                .fillMaxSize()
                .clip(RoundedCornerShape(10.dp))
        )

        Column {
            Text(
                title,
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                "view info",
                fontSize = 13.sp,
                color = Color(235, 235, 245).copy(0.6f)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_eth),
                    contentDescription = "ETH logo",
                    modifier = Modifier.size(13.dp)
                )
                Text(
                    eth.toString(),
                    color = Color.White,
                    fontSize = 13.sp,
                    textAlign = TextAlign.Left
                )
            }
        }
    }
}



@Preview
@Composable
fun PreviewRankingRow() {
    NFTMarketplaceTheme {
        RankingRow(
            index = 0,
            title = rankings[0].title,
            image = rankings[0].image,
            change = rankings[0].percentChange,
            eth = rankings[0].eth
        )
    }
}