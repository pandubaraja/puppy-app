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
package com.example.androiddevchallenge.ui.screen.home.viewparam

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.base.BaseItem

data class PetItem(
    val id: String,
    val ownerId: String,
    val breed: String,
    val weight: String,
    val height: String,
    val region: String,
    val city: String,
    val description: String,
    val color: String,
    val categories: List<String>,
    val properties: List<Property>
) : BaseItem {

    data class Property(
        val title: String,
        val value: String
    )

    fun getImageResId(): Int {
        return when (id) {
            "1" -> R.drawable.corgi
            "2" -> R.drawable.labrador
            "3" -> R.drawable.beagle
            "4" -> R.drawable.siberian
            "5" -> R.drawable.golden
            "6" -> R.drawable.boxer
            else -> R.drawable.labrador
        }
    }
}
