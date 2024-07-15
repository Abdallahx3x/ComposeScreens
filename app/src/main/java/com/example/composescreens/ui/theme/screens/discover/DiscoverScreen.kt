package com.example.composescreens.ui.theme.screens.discover

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composescreens.R
import com.example.composescreens.ui.theme.ComposeScreensTheme
import com.example.composescreens.ui.theme.customColors
import kotlinx.coroutines.launch

@Composable
fun DiscoverScreen() {
    DiscoverContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscoverContent() {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState()
    val scope = rememberCoroutineScope()
    var offsetY by remember { mutableFloatStateOf(0f) }
    val screenHeight =
        with(LocalDensity.current) { LocalConfiguration.current.screenHeightDp.dp.toPx() }

    BottomSheetScaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.customColors.background),
        sheetContent = {
            Column(modifier = Modifier.height(440.dp)) {
                ContentBottomSheet()
            }

        },
        scaffoldState = bottomSheetScaffoldState,
        sheetShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        sheetContainerColor = Color.Black,
        sheetPeekHeight = 0.dp,
        containerColor = Color.Black
    ) {
        Column(modifier = Modifier.pointerInput(Unit) {
            detectDragGestures { change, dragAmount ->
                change.consume()
                when {
                    dragAmount.y > 0 -> {
                        scope.launch {
                            bottomSheetScaffoldState.bottomSheetState.partialExpand()
                        }
                    }
                }
                offsetY += dragAmount.y
                if (offsetY > screenHeight) {
                    offsetY = screenHeight
                }
                if (offsetY < 0) {
                    offsetY = 0f
                }
            }
        }) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.customColors.onBackground1)
                ) {
                    IconButton(onClick = { }) {
                        Icon(
                            modifier = Modifier
                                .size(22.dp),
                            painter = painterResource(id = R.drawable.settings_icon),
                            contentDescription = "settings",
                            tint = MaterialTheme.customColors.onBackground2,
                        )
                    }
                }
                Text(
                    modifier = Modifier,
                    text = "Discover",
                    fontSize = 16.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.customColors.onBackground1)
                ) {
                    IconButton(onClick = {
                        scope.launch {
                            bottomSheetScaffoldState.bottomSheetState.expand()
                        }
                    }) {
                        Icon(
                            modifier = Modifier
                                .size(20.dp),
                            painter = painterResource(id = R.drawable.add),
                            contentDescription = "add",
                            tint = MaterialTheme.customColors.primary,
                        )
                    }
                }
            }

            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                verticalItemSpacing = 4.dp,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
            ) {
                item {
                    DiscoverCard(height = 230.dp)
                }
                item {
                    DiscoverCard(height = 160.dp)
                }
                item {
                    DiscoverCard(height = 240.dp)
                }
                item {
                    DiscoverCard(height = 230.dp)
                }
                item {
                    DiscoverCard(height = 160.dp)
                }
                item {
                    DiscoverCard(height = 240.dp)
                }
            }
        }
    }
}

@Composable
@Preview
fun DiscoverScreenPreview() {
    ComposeScreensTheme {
        DiscoverScreen()
    }
}
