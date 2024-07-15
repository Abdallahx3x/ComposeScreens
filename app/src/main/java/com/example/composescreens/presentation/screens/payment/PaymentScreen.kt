package com.example.composescreens.ui.theme.screens.payment

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composescreens.R
import com.example.composescreens.presentation.theme.ComposeScreensTheme
import com.example.composescreens.presentation.theme.customColors
import com.example.composescreens.ui.theme.screens.discover.navigateToDiscoverScreen
import com.example.composescreens.ui.theme.screens.utils.EventHandler
import kotlin.math.absoluteValue

@Composable
fun PaymentScreen(viewModel: PaymentViewModel = hiltViewModel()) {
    EventHandler(effect = viewModel.effect) { effect, navController ->
        when (effect) {
            PaymentUiEffect.NavigateToDiscover -> {
                navController.navigateToDiscoverScreen()
            }
        }
    }
    PaymentContent(viewModel)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PaymentContent(listener: PaymentInteractionListener) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Box {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .blur(12.dp),
                painter = painterResource(id = R.drawable.payment_background),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Black.copy(alpha = 0.5f),
                                Color.Transparent
                            ),
                            startY = 100f
                        )
                    )
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
                            startY = 1500f,
                            endY = 10f,
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.Start

            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .padding(horizontal = 16.dp),
                    text = "Try for Free",
                    fontSize = 34.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                Text(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .padding(horizontal = 16.dp),
                    text = "How it Works",
                    fontSize = 16.sp,
                    color = MaterialTheme.customColors.onBackground2,
                    textAlign = TextAlign.Center
                )
                Row(
                    modifier = Modifier
                        .padding(top = 50.dp)
                        .padding(horizontal = 24.dp),
                ) {
                    TrialJourney()
                    Column {
                        Text(
                            modifier = Modifier
                                .padding(vertical = 12.dp, horizontal = 12.dp),
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = MaterialTheme.customColors.primary,
                                        fontSize = 16.sp,
                                    )
                                ) {
                                    append("Today: Get instant access\n")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = MaterialTheme.customColors.onBackground4,
                                        fontSize = 12.sp,
                                    )
                                ) {
                                    append("Start your full access to all features")
                                }
                            },
                            textAlign = TextAlign.Start
                        )
                        Text(
                            modifier = Modifier
                                .padding(vertical = 42.dp, horizontal = 12.dp),
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = MaterialTheme.customColors.onPrimary,
                                        fontSize = 16.sp,
                                    )
                                ) {
                                    append("Day 2: Trial Reminder\n")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = MaterialTheme.customColors.onBackground4,
                                        fontSize = 12.sp,
                                    )
                                ) {
                                    append("Get reminder about when your free trial will end")
                                }
                            },
                            textAlign = TextAlign.Start
                        )
                        Text(
                            modifier = Modifier
                                .padding(horizontal = 12.dp),
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = MaterialTheme.customColors.onPrimary,
                                        fontSize = 16.sp,
                                    )
                                ) {
                                    append("Day 3: Trial Ends\n")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = MaterialTheme.customColors.onBackground4,
                                        fontSize = 12.sp,
                                    )
                                ) {
                                    append("Cancel anytime before. Your subscription will start on [Date]")
                                }
                            },
                            textAlign = TextAlign.Start
                        )
                    }
                }
                val pageState = rememberPagerState(initialPage = 1, pageCount = { 3 })

                HorizontalPager(
                    state = pageState,
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .height(220.dp),
                    contentPadding = PaddingValues(horizontal = 40.dp),
                ) { page ->
                    FeedbackCard(
                        modifier = Modifier
                            .size(width = 340.dp, height = 200.dp)
                            .graphicsLayer {
                                val pageOffset = (
                                        (pageState.currentPage - page) + pageState
                                            .currentPageOffsetFraction
                                        ).absoluteValue
                                lerp(
                                    start = 0.9f,
                                    stop = 1f,
                                    fraction = 1f - pageOffset.coerceIn(
                                        0f,
                                        1f
                                    )
                                ).also {
                                    scaleX = it
                                    scaleY = it
                                }
                                alpha = lerp(
                                    start = 0.5f,
                                    stop = 1f,
                                    fraction = 1f - pageOffset.coerceIn(
                                        0f,
                                        1f
                                    )
                                )
                            },
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    text = "3-day free trial, then $49.99/Year",
                    fontSize = 14.sp,
                    color = MaterialTheme.customColors.onBackground4,
                    textAlign = TextAlign.Center
                )
                Button(
                    onClick = { listener.onClickSubscribeButton() },
                    modifier = Modifier
                        .padding(bottom = 8.dp, top = 15.dp)
                        .padding(horizontal = 24.dp)
                        .fillMaxWidth()
                        .height(64.dp),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.customColors.primary),
                    shape = RoundedCornerShape(62.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = "Subscribe for 4.17/Month",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.security_icon),
                        contentDescription = null,
                        tint = MaterialTheme.customColors.primary
                    )
                    Text(
                        modifier = Modifier,
                        text = "payment now!",
                        fontSize = 12.sp,
                        color = MaterialTheme.customColors.primary,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun PaymentScreenPreview() {
    ComposeScreensTheme {
        PaymentScreen()
    }
}
