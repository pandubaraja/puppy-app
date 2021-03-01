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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.MockData
import com.example.androiddevchallenge.ui.screen.home.viewparam.PetItem
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun PetBody(
    data: PetItem,
    modifier: Modifier = Modifier
) {
    Surface(
        color = Color(android.graphics.Color.parseColor(data.color))
    ) {
        Surface(
            shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
        ) {
            Column(
                modifier = modifier
                    .layoutId("body")
            ) {
                ConstraintLayout(
                    getPetBodyConstraints(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {

                    Text(
                        text = data.breed,
                        style = typography.h6,
                        modifier = Modifier
                            .layoutId("title")
                    )

                    Row(
                        modifier = Modifier
                            .layoutId("subtitle"),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Outlined.LocationOn,
                            contentDescription = null,
                            modifier = Modifier
                                .width(16.dp)
                                .height(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "${data.city}, ${data.region}", style = typography.caption)
                    }

                    Card(
                        modifier = Modifier
                            .width(32.dp)
                            .height(32.dp)
                            .layoutId("favourite"),
                        shape = RoundedCornerShape(9.dp),
                        elevation = 4.dp,
                    ) {
                        Icon(
                            Icons.Outlined.FavoriteBorder,
                            modifier = Modifier.padding(6.dp),
                            contentDescription = stringResource(id = R.string.pet_favourite)
                        )
                    }

                    PetPropertyList(
                        data = data.properties,
                        modifier = Modifier
                            .layoutId("property_list")
                    )

                    val owner = MockData.getOwner(data.ownerId)
                    if (owner != null) {
                        PetOwner(
                            modifier = Modifier
                                .layoutId("owner")
                                .padding(horizontal = 16.dp),
                            data = owner,
                            color = Color(android.graphics.Color.parseColor(data.color))
                        )
                    }

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .layoutId("description")
                            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                        text = data.description,
                        style = typography.body2,
                        lineHeight = 21.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PetBodyPreview() {
    val doggo = MockData.getDoggo("1")
    if (doggo == null) {
        Text("Something goes wrong")
    } else {
        PetBody(data = doggo)
    }
}

private fun getPetBodyConstraints(): ConstraintSet {
    return ConstraintSet {
        val title = createRefFor("title")
        val subtitle = createRefFor("subtitle")
        val propertyList = createRefFor("property_list")
        val description = createRefFor("description")
        val favourite = createRefFor("favourite")
        val owner = createRefFor("owner")

        constrain(title) {
            top.linkTo(parent.top, 16.dp)
            start.linkTo(parent.start, margin = 16.dp)
        }

        constrain(subtitle) {
            top.linkTo(title.bottom, 4.dp)
            start.linkTo(parent.start, margin = 16.dp)
        }

        constrain(favourite) {
            top.linkTo(title.top)
            bottom.linkTo(subtitle.bottom)
            end.linkTo(parent.end, margin = 16.dp)
        }

        constrain(propertyList) {
            top.linkTo(subtitle.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(owner) {
            top.linkTo(propertyList.bottom, 8.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(description) {
            top.linkTo(owner.bottom, margin = 16.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    }
}
