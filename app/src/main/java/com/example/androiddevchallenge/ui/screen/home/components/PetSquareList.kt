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

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.MockData
import com.example.androiddevchallenge.ui.screen.home.PetListener
import com.example.androiddevchallenge.ui.screen.home.viewparam.PetItem
import com.example.androiddevchallenge.ui.screen.home.viewparam.PetSquareListItem

@Composable
fun PetSquareList(
    data: PetSquareListItem,
    modifier: Modifier = Modifier,
    onPetSelected: PetListener? = null
) {
    Column {
        Header(
            title = "Popular",
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            modifier = modifier,
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
        ) {
            items(data.items) {
                PetSquareCell(
                    data = it,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(100.dp),
                    onPetSelected = onPetSelected
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun PetSquareCell(
    data: PetItem,
    modifier: Modifier,
    onPetSelected: PetListener? = null
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(android.graphics.Color.parseColor(data.color))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .clickable {
                    onPetSelected?.invoke(data.id)
                }
        ) {
            Image(
                painter = painterResource(id = data.getImageResId()),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter
            )
        }
    }
}

@Preview
@Composable
fun PetSquareCellPreview() {
    PetSquareCell(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp),
        data = MockData.doggos[0]
    )
}
