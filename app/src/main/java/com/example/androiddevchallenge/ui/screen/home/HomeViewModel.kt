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

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevchallenge.base.BaseItem
import com.example.androiddevchallenge.data.Category
import com.example.androiddevchallenge.data.MockData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _state = MutableStateFlow(HomeViewState())
    private val selectedCategory = MutableStateFlow(MockData.categories.first())
    private val categories = MutableStateFlow(MockData.categories)

    val state: StateFlow<HomeViewState>
        get() = _state

    init {
        viewModelScope.launch {
            combine(
                categories,
                selectedCategory
            ) { categories, selectedCategory ->
                HomeViewState(
                    categories = categories,
                    selectedCategory = selectedCategory,
                    items = HomeScreenMockedData.getItemWithCategory(selectedCategory)
                )
            }.catch {
                throw it
            }.collect {
                _state.value = it
            }
        }
    }

    fun onCategorySelected(category: Category) {
        selectedCategory.value = category
    }
}

data class HomeViewState(
    val categories: List<Category> = emptyList(),
    val selectedCategory: Category = MockData.categories.first(),
    val items: List<BaseItem> = HomeScreenMockedData.items,
    val errorMessage: String? = null
)
