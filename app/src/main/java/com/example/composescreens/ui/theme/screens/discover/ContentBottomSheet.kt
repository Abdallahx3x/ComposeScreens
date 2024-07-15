package com.example.composescreens.ui.theme.screens.discover

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composescreens.R
import com.example.composescreens.ui.theme.customColors

@Composable
fun ContentBottomSheet() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .blur(40.dp),
            painter = painterResource(id = R.drawable.img),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.9f),
                            Color.Transparent
                        ),
                        endY = 2000f
                    )
                )
                .blur(40.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 1f),
                            Color.Transparent
                        ),
                        endY = 200f,
                        startY = 1800f
                    )
                )
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    modifier = Modifier,
                    text = "Discover",
                    fontSize = 16.sp,
                    color = MaterialTheme.customColors.onPrimary,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(28.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.customColors.gray)

                ) {
                    IconButton(onClick = { }) {
                        Icon(
                            modifier = Modifier
                                .size(16.dp),
                            painter = painterResource(id = R.drawable.close_icon),
                            contentDescription = "settings",
                            tint = MaterialTheme.customColors.black,
                        )
                    }
                }
            }

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(32.dp)),
                placeholder = {
                    Text(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        text = "Type your imagination and let the [App] visualize it.",
                        color = MaterialTheme.customColors.onBackground4
                    )
                },
                value = "",
                onValueChange = {},
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.customColors.black.copy(alpha = 0.5f),
                    unfocusedContainerColor = MaterialTheme.customColors.black.copy(alpha = 0.5f),
                    unfocusedBorderColor = Color.Transparent,
                    disabledBorderColor = Color.Transparent,
                    focusedTextColor = MaterialTheme.customColors.onBackground4,
                    unfocusedTextColor = MaterialTheme.customColors.onBackground4
                )
            )
            Button(
                onClick = { },
                modifier = Modifier
                    .padding(bottom = 16.dp, top = 24.dp)
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth()
                    .height(64.dp),
                colors = ButtonDefaults.buttonColors(MaterialTheme.customColors.primary),
                shape = RoundedCornerShape(62.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(id = R.drawable.generate_icon),
                        contentDescription = null,
                        tint = Color.White
                    )
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = "Generate",
                        color = Color.White
                    )
                }
            }
        }
    }

}