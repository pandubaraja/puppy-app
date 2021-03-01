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
package com.example.androiddevchallenge

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.androiddevchallenge.data.MockData
import com.example.androiddevchallenge.ui.screen.home.HomeScreen
import com.example.androiddevchallenge.ui.screen.petdetail.PetDetailScreen
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.utils.Actions
import com.example.androiddevchallenge.ui.utils.Destination
import com.example.androiddevchallenge.ui.utils.Navigator

@Composable
fun PetAdoptionApp(backDispatcher: OnBackPressedDispatcher) {
    val navigator: Navigator<Destination> = rememberSaveable(
        saver = Navigator.saver(backDispatcher)
    ) {
        Navigator(Destination.Home, backDispatcher)
    }

    val actions = remember(navigator) {
        Actions(navigator)
    }

    MyTheme {
        Crossfade(navigator.current) { destination ->
            when (destination) {
                Destination.Home -> {
                    HomeScreen(actions.selectPet)
                }
                is Destination.PetDetail -> {
                    val doggo = MockData.getDoggo(destination.petId)
                    if (doggo != null) {
                        PetDetailScreen(doggo)
                    } else {
                        // TODO render error screen
                    }
                }
            }
        }
    }
}
