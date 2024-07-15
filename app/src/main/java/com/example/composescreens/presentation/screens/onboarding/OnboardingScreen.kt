package com.example.composescreens.ui.theme.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composescreens.R
import com.example.composescreens.presentation.theme.ComposeScreensTheme
import com.example.composescreens.presentation.theme.customColors
import com.example.composescreens.ui.theme.screens.discover.navigateToDiscoverScreen
import com.example.composescreens.ui.theme.screens.utils.EventHandler

@Composable
fun OnboardingScreen(viewModel: OnboardingViewModel = hiltViewModel()) {
    EventHandler(effect = viewModel.effect) { effect, navController ->
        when (effect) {
            OnboardingUiEffect.NavigateToDiscover -> {
                navController.navigateToDiscoverScreen()
            }
        }
    }
    OnboardingContent(viewModel)
}

@Composable
fun OnboardingContent(listener: OnboardingInteractionListener) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Box {
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(id = R.drawable.onboarding_task_image),
                contentScale = ContentScale.Crop,
                contentDescription = null
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
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    modifier = Modifier
                        .padding(vertical = 16.dp, horizontal = 32.dp),
                    text = "Generate any thing what’s in your mind now",
                    fontSize = 24.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                Text(
                    modifier = Modifier
                        .padding(vertical = 16.dp, horizontal = 32.dp),
                    text = "An AI that developed to help you generate what’s in your mind into beautiful visual",
                    fontSize = 18.sp,
                    color = Color.White.copy(0.4f),
                    textAlign = TextAlign.Center
                )

                Button(
                    onClick = { listener.onClickStartButton() },
                    modifier = Modifier
                        .padding(bottom = 16.dp, top = 24.dp)
                        .padding(horizontal = 24.dp)
                        .fillMaxWidth()
                        .height(64.dp),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.customColors.primary),
                    shape = RoundedCornerShape(62.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = "Lets’ go!",
                        color = Color.White
                    )
                }
            }
        }

    }
}

@Composable
@Preview
fun OnboardingScreenPreview() {
    ComposeScreensTheme {
        OnboardingScreen()
    }
}

