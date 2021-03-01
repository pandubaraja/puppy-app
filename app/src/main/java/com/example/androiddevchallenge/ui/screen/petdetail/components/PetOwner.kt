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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.MockData
import com.example.androiddevchallenge.data.Owner
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun PetOwner(
    data: Owner,
    color: Color,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        getPetOwnerConstraints(),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Card(
            shape = CircleShape,
            backgroundColor = color,
            modifier = Modifier
                .height(48.dp)
                .width(48.dp)
                .layoutId("image")
        ) {
            Image(
                modifier = Modifier.padding(8.dp),
                painter = painterResource(id = data.getOwnerResId()),
                contentDescription = null,
                contentScale = ContentScale.Inside
            )
        }
        Text(
            text = data.name,
            modifier = Modifier.layoutId("title"),
            style = typography.subtitle2
        )
        Text(
            text = "Owner",
            modifier = Modifier
                .layoutId("subtitle"),
            style = typography.subtitle2,
            color = colorResource(id = R.color.red_500)
        )
        Text(
            text = data.range,
            modifier = Modifier.layoutId("range"),
            style = typography.subtitle2
        )
    }
}

private fun getPetOwnerConstraints(): ConstraintSet {
    return ConstraintSet {
        val image = createRefFor("image")
        val title = createRefFor("title")
        val subtitle = createRefFor("subtitle")
        val range = createRefFor("range")

        constrain(image) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            bottom.linkTo(parent.bottom)
        }

        constrain(title) {
            top.linkTo(image.top)
            start.linkTo(image.end, 8.dp)
            bottom.linkTo(subtitle.top)
        }

        constrain(subtitle) {
            top.linkTo(title.bottom)
            start.linkTo(title.start)
            bottom.linkTo(image.bottom)
        }

        constrain(range) {
            top.linkTo(parent.top)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        }
    }
}

@Preview
@Composable
fun PetOwnerPreview() {
    val owner = MockData.getOwner("1")
    if (owner != null) PetOwner(owner, Color.White)
}
