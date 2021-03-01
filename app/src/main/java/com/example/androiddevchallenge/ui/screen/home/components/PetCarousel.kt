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
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.MockData
import com.example.androiddevchallenge.ui.screen.home.PetListener
import com.example.androiddevchallenge.ui.screen.home.viewparam.PetCarouselItem
import com.example.androiddevchallenge.ui.screen.home.viewparam.PetItem
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun PetCarousel(
    data: PetCarouselItem,
    modifier: Modifier = Modifier,
    onPetSelected: PetListener? = null
) {
    Column {
        Header(
            title = "Choose your dog",
            subTitle = "Those puppies need your help.",
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            modifier = modifier,
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
        ) {
            items(data.items) {
                PetCarouselCell(data = it, onPetSelected = onPetSelected)
            }
        }
    }
}

@Composable
fun PetCarouselCell(
    data: PetItem,
    modifier: Modifier = Modifier,
    onPetSelected: PetListener? = null
) {
    ConstraintLayout(
        petCarouselCellConstraints(),
        modifier = modifier
            .fillMaxHeight()
            .width(150.dp)
            .padding(PaddingValues(0.dp, 16.dp, 16.dp, 16.dp))
    ) {
        Card(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .clickable {
                    onPetSelected?.invoke(data.id)
                }
                .layoutId("card_pet"),
            shape = RoundedCornerShape(8.dp),
            elevation = 6.dp,
        ) {
            Column(
                modifier =
                Modifier
                    .background(
                        Color(android.graphics.Color.parseColor(data.color))
                    )
            ) {
                Text(
                    text = data.region,
                    style = typography.overline,
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
                    color = Color.White
                )
                Text(
                    text = data.breed,
                    style = typography.subtitle1,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    color = Color.White
                )
            }
        }

        Box(
            modifier = Modifier
                .width(100.dp)
                .wrapContentHeight()
                .layoutId("image_pet")
        ) {
            Image(
                painter = painterResource(id = data.getImageResId()),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
        }

        Card(
            modifier = Modifier
                .width(32.dp)
                .height(32.dp)
                .layoutId("card_favourite"),
            shape = RoundedCornerShape(9.dp),
            elevation = 4.dp,
        ) {
            Icon(
                Icons.Outlined.FavoriteBorder,
                modifier = Modifier.padding(6.dp),
                contentDescription = stringResource(id = R.string.pet_favourite)
            )
        }
    }
}

private fun petCarouselCellConstraints(): ConstraintSet {
    return ConstraintSet {
        val cardPet = createRefFor("card_pet")
        val cardFavourite = createRefFor("card_favourite")
        val imagePet = createRefFor("image_pet")

        constrain(cardPet) {
            top.linkTo(parent.top, margin = 16.dp)
            start.linkTo(parent.start, margin = 16.dp)
            end.linkTo(parent.end, margin = 16.dp)
            bottom.linkTo(parent.bottom, margin = 16.dp)
        }

        constrain(cardFavourite) {
            end.linkTo(parent.end, 12.dp)
            bottom.linkTo(parent.bottom, (-12).dp)
        }

        constrain(imagePet) {
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
        }
    }
}

@Preview
@Composable
fun PetCarouselCellPreview() {
    PetCarouselCell(
        data = MockData.doggos[1],
        modifier = Modifier
            .height(200.dp)
            .width(120.dp)
    )
}
