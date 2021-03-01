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
package com.example.androiddevchallenge.ui.screen.petdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.MockData
import com.example.androiddevchallenge.ui.screen.PetAdoptionAppBar
import com.example.androiddevchallenge.ui.screen.home.viewparam.PetItem
import com.example.androiddevchallenge.ui.screen.petdetail.components.PetAction
import com.example.androiddevchallenge.ui.screen.petdetail.components.PetBody
import com.example.androiddevchallenge.ui.screen.petdetail.components.PetHeader

@Composable
fun PetDetailScreen(
    data: PetItem
) {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            Column {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .background(Color(android.graphics.Color.parseColor(data.color))),
                )
                PetAdoptionAppBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    title = {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = null,
                            tint = Color.White
                        )
                    },
                    actions = {
                        Icon(
                            Icons.Outlined.FavoriteBorder,
                            modifier = Modifier.padding(6.dp),
                            contentDescription = stringResource(id = R.string.pet_favourite),
                            tint = Color.White
                        )
                    },
                    backgroundColor = Color(android.graphics.Color.parseColor(data.color))
                )
            }
        }
    ) {
        Box {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .layoutId("body")
            ) {
                PetHeader(data, scrollState = scrollState, containerHeight = 250.dp)
                PetBody(
                    data,
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                )
                Spacer(
                    modifier = Modifier
                        .height(72.dp)
                )
            }

            PetAction(
                data,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .layoutId("footer")
            )
        }
    }
}

@Preview
@Composable
fun PetDetailScreenPreview() {
    val doggo = MockData.getDoggo("1")
    if (doggo != null) PetDetailScreen(doggo)
}
