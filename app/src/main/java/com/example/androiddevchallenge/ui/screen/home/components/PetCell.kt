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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.androiddevchallenge.data.MockData
import com.example.androiddevchallenge.ui.screen.home.PetListener
import com.example.androiddevchallenge.ui.screen.home.viewparam.PetItem
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun PetCell(
    data: PetItem,
    modifier: Modifier = Modifier,
    onPetSelected: PetListener? = null
) {
    Column {
        ConstraintLayout(
            getPetCellConstraints(),
            modifier = modifier
                .fillMaxWidth()
                .height(130.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onPetSelected?.invoke(data.id)
                    }
                    .layoutId("card"),
                shape = RoundedCornerShape(8.dp)
            ) {
                Row {
                    Card(
                        modifier = Modifier
                            .width(100.dp)
                            .height(100.dp),
                        shape = RoundedCornerShape(8.dp),
                        backgroundColor = Color(android.graphics.Color.parseColor(data.color))
                    ) {}
                    Column(
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = data.breed, style = typography.subtitle1)
                        Spacer(modifier = Modifier.height(24.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Weight", style = typography.caption, color = Color.Gray)
                            Text(text = data.weight, style = typography.body2)
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Height", style = typography.caption, color = Color.Gray)
                            Text(text = data.height, style = typography.body2)
                        }
                    }
                }
            }

            Box(
                modifier = Modifier
                    .width(100.dp)
                    .fillMaxHeight()
            ) {
                Image(
                    painter = painterResource(id = data.getImageResId()),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.BottomCenter
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

private fun getPetCellConstraints(): ConstraintSet {
    return ConstraintSet {
        val card = createRefFor("card")
        val image = createRefFor("image")

        constrain(card) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(image) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
        }
    }
}

@Preview
@Composable
fun PetCellPreview() {
    PetCell(
        modifier = Modifier.height(150.dp),
        data = MockData.doggos[0]
    )
}
