package com.example.composescreens.ui.theme.screens.payment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composescreens.R
import com.example.composescreens.ui.theme.ComposeScreensTheme
import com.example.composescreens.ui.theme.customColors

@Composable
fun TrialJourney() {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.customColors.primary)
                .size(40.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                    .size(28.dp),
                painter = painterResource(id = R.drawable.payment_icon1),
                contentDescription = "null",
                tint = Color.White,
            )
        }
        Box(
            contentAlignment = Alignment.TopCenter

        ) {
            Box(
                modifier = Modifier
                    .offset(y = (5).dp)
                    .background(MaterialTheme.customColors.onBackground5)
                    .padding(bottom = 20.dp)
                    .width(10.dp)
                    .height(60.dp)
            )
            Box(
                modifier = Modifier
                    .offset(y = (-10).dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.customColors.primary)
                    .width(10.dp)
                    .height(55.dp)
            )
        }
        ///////////////////////////////////////
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.customColors.onBackground5)
                .size(40.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                    .size(28.dp),
                painter = painterResource(id = R.drawable.payment_icon2),
                contentDescription = "null",
                tint = Color.White,
            )
        }
        Box(
            contentAlignment = Alignment.TopCenter
        ) {
            Box(
                modifier = Modifier
                    .offset(y = (-10).dp)
                    .background(MaterialTheme.customColors.onBackground5)
                    .padding(bottom = 20.dp)
                    .width(10.dp)
                    .height(60.dp)
            )
            Box(
                modifier = Modifier
                    .offset(y = (-10).dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.customColors.onBackground5)
                    .width(8.dp)
                    .height(50.dp)
            )
        }
        Box(
            modifier = Modifier
                .offset(y = (-15).dp)
                .clip(CircleShape)
                .background(MaterialTheme.customColors.onBackground5)
                .size(40.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                    .size(28.dp),
                painter = painterResource(id = R.drawable.payment_icon3),
                contentDescription = "null",
                tint = Color.White,
            )
        }

    }

}

@Composable
@Preview(showBackground = true )
fun TrialJourneyPreview() {
    ComposeScreensTheme {
        TrialJourney()
    }
}
