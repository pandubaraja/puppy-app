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
package com.example.androiddevchallenge.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.MockData
import com.example.androiddevchallenge.ui.screen.PetAdoptionAppBar
import com.example.androiddevchallenge.ui.screen.home.components.Header
import com.example.androiddevchallenge.ui.screen.home.components.PetCarousel
import com.example.androiddevchallenge.ui.screen.home.components.PetCell
import com.example.androiddevchallenge.ui.screen.home.components.PetSquareList
import com.example.androiddevchallenge.ui.screen.home.components.TabList
import com.example.androiddevchallenge.ui.screen.home.viewparam.HeaderItem
import com.example.androiddevchallenge.ui.screen.home.viewparam.PetCarouselItem
import com.example.androiddevchallenge.ui.screen.home.viewparam.PetCellItem
import com.example.androiddevchallenge.ui.screen.home.viewparam.PetSquareListItem
import com.example.androiddevchallenge.ui.theme.background

@Composable
fun HomeScreen(
    onPetSelected: PetListener? = null
) {
    val listState = rememberLazyListState()
    val viewModel = viewModel(HomeViewModel::class.java)

    val viewState by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            PetAdoptionAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 40.dp),
                title = {
                    Text(stringResource(id = R.string.app_name))
                },
                actions = {
                    Icon(
                        Icons.Outlined.FavoriteBorder,
                        modifier = Modifier.padding(6.dp),
                        contentDescription = stringResource(id = R.string.pet_favourite)
                    )
                },
                backgroundColor = background
            )
        }
    ) {
        Surface(color = background) {
            Column {
                TabList(
                    tabs = MockData.categories,
                    onCategorySelected = viewModel::onCategorySelected,
                    selectedCategory = viewState.selectedCategory
                )

                LazyColumn(state = listState) {
                    items(viewState.items) {
                        when (it) {
                            is PetCarouselItem -> {
                                PetCarousel(
                                    data = it,
                                    modifier = Modifier.height(230.dp),
                                    onPetSelected = onPetSelected
                                )
                            }
                            is PetSquareListItem -> {
                                PetSquareList(
                                    data = it,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(100.dp),
                                    onPetSelected = onPetSelected
                                )
                            }
                            is HeaderItem -> {
                                Header(
                                    title = it.title,
                                    subTitle = it.subtitle,
                                    modifier = Modifier.padding(horizontal = 16.dp)
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                            }
                            is PetCellItem -> {
                                PetCell(
                                    modifier = Modifier
                                        .padding(start = 16.dp, end = 16.dp),
                                    data = it.data,
                                    onPetSelected = onPetSelected
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    HomeScreen()
}
