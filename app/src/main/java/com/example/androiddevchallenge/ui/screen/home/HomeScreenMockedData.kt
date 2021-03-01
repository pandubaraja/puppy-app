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

import com.example.androiddevchallenge.base.BaseItem
import com.example.androiddevchallenge.data.Category
import com.example.androiddevchallenge.data.MockData
import com.example.androiddevchallenge.ui.screen.home.viewparam.HeaderItem
import com.example.androiddevchallenge.ui.screen.home.viewparam.PetCarouselItem
import com.example.androiddevchallenge.ui.screen.home.viewparam.PetCellItem
import com.example.androiddevchallenge.ui.screen.home.viewparam.PetSquareListItem

object HomeScreenMockedData {

    val items = mutableListOf(
        PetCarouselItem(MockData.doggos.shuffled()),
        PetSquareListItem(MockData.doggos.shuffled())
    ).apply {
        this.add(HeaderItem(title = "Who wants some love?", subtitle = "Here are some puppies to cuddle with"))
        MockData.doggos.shuffled().forEach {
            this.add(PetCellItem(it))
        }
    }.toList()

    fun getItemWithCategory(category: Category?): List<BaseItem> {
        return mutableListOf(
            PetCarouselItem(MockData.doggos.filter { category?.id == "0" || it.categories.contains(category?.id) }.shuffled()),
            PetSquareListItem(MockData.doggos.filter { category?.id == "0" || it.categories.contains(category?.id) }.shuffled())
        ).apply {
            this.add(HeaderItem(title = "Who wants some love?", subtitle = "Here are some puppies to cuddle with"))
            MockData.doggos.filter { category?.id == "0" || it.categories.contains(category?.id) }.shuffled().forEach {
                this.add(PetCellItem(it))
            }
        }.toList()
    }
}
