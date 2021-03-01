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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun Header(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String? = null,
) {
    Column(modifier = modifier) {
        Text(text = title, style = typography.h6)
        Spacer(modifier = Modifier.height(4.dp))
        if (!subTitle.isNullOrBlank()) {
            Text(text = subTitle.orEmpty(), style = typography.caption)
        }
    }
}

@Preview
@Composable
fun HeaderPreview() {
    Header(title = "Test", subTitle = "Test")
}
