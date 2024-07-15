package com.example.composescreens.ui.theme.screens.payment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composescreens.R
import com.example.composescreens.ui.theme.ComposeScreensTheme
import com.example.composescreens.ui.theme.customColors


@Composable
fun FeedbackCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.customColors.onBackground1),
        shape = RoundedCornerShape(12.dp),
        onClick = { }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.user1),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
            Text(
                modifier = Modifier
                    .padding(start = 8.dp),
                text = "Aboood",
                fontSize = 12.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                modifier = Modifier
                    .size(16.dp),
                painter = painterResource(id = R.drawable.star_icon),
                contentDescription = "null",
                tint = MaterialTheme.customColors.orange,
            )
            Icon(
                modifier = Modifier
                    .size(16.dp),
                painter = painterResource(id = R.drawable.star_icon),
                contentDescription = "null",
                tint = MaterialTheme.customColors.orange,
            )
            Icon(
                modifier = Modifier
                    .size(16.dp),
                painter = painterResource(id = R.drawable.star_icon),
                contentDescription = "null",
                tint = MaterialTheme.customColors.orange,
            )
            Icon(
                modifier = Modifier
                    .size(16.dp),
                painter = painterResource(id = R.drawable.star_icon),
                contentDescription = "null",
                tint = MaterialTheme.customColors.orange,
            )
            Icon(
                modifier = Modifier
                    .size(16.dp),
                painter = painterResource(id = R.drawable.star_icon),
                contentDescription = "null",
                tint = MaterialTheme.customColors.orange,
            )
        }
        Text(
            modifier = Modifier
                .padding(
                    bottom = 16.dp, top = 8.dp,
                    start = 16.dp, end = 10.dp
                ),
            text = "staf sangat membantu untuk redeem voucher namun waktunya lumayan lama karena masih mengecek kode vou",
            fontSize = 12.sp,
            color = Color.White,
            textAlign = TextAlign.Start
        )


    }
}

@Composable
@Preview
fun FeedbackCardPreview() {
    ComposeScreensTheme {
        FeedbackCard()
    }
}
