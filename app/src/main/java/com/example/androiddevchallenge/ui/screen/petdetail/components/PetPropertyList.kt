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
package com.example.androiddevchallenge.ui.screen.petdetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.screen.home.viewparam.PetItem
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun PetPropertyList(
    data: List<PetItem.Property>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(data) {
            PetPropertyCell(label = it.title, value = it.value)
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun PetPropertyCell(
    label: String,
    value: String
) {
    Card(
        modifier = Modifier
            .height(68.dp)
            .width(68.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Surface(color = MaterialTheme.colors.surface) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = label, style = typography.subtitle2, color = Color(253, 147, 137))
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = value, style = typography.caption)
            }
        }
    }
}

@Preview
@Composable
fun PetPropertyCellPreview() {
    PetPropertyCell("Label", "Value")
}
