/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screen.home.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Category

@Composable
fun TabList(
    tabs: List<Category>,
    selectedCategory: Category,
    modifier: Modifier = Modifier,
    onCategorySelected: (Category) -> Unit
) {
    val selectedIndex = tabs.indexOfFirst { it == selectedCategory }

    Card(
        shape = RoundedCornerShape(0.dp),
        elevation = 0.dp
    ) {
        Column {
            ScrollableTabRow(
                selectedTabIndex = selectedIndex,
                backgroundColor = Color(android.R.color.transparent),
                edgePadding = 0.dp,
                indicator = { tabPositions ->
                    Surface(
                        modifier
                            .customTabIndicatorOffset(tabPositions[selectedIndex])
                            .height(4.dp),
                        color = Color(240, 171, 169),
                        shape = RoundedCornerShape(2.dp),
                    ) {}
                },
                divider = {}
            ) {
                tabs.forEachIndexed { index, tab ->
                    Tab(
                        selected = index == selectedIndex,
                        onClick = {
                            onCategorySelected.invoke(tab)
                        },
                        text = {
                            Text(text = tab.title)
                        }
                    )
                }
            }
        }
    }
}

fun Modifier.customTabIndicatorOffset(
    currentTabPosition: TabPosition
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "tabIndicatorOffset"
        value = currentTabPosition
    }
) {
    val currentTabWidth = currentTabPosition.width
    val indicatorOffset by animateDpAsState(
        targetValue = currentTabPosition.left + (currentTabWidth / 2) - 2.dp,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset, y = (-4).dp)
        .width(4.dp)
}
