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

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Pets
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.MockData
import com.example.androiddevchallenge.ui.screen.home.viewparam.PetItem

@Composable
fun PetAction(
    data: PetItem,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier
            .background(Color.White),
        elevation = 2.dp
    ) {
        Row {
            Button(
                onClick = {
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                    .weight(0.3f),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (isSystemInDarkTheme()) colorResource(id = R.color.gray_500) else colorResource(id = R.color.gray_100),
                    contentColor = if (isSystemInDarkTheme()) Color.White else Color.Gray
                )
            ) {
                Icon(
                    Icons.Outlined.Share,
                    modifier = Modifier.padding(6.dp),
                    contentDescription = stringResource(id = R.string.pet_favourite)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = {
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp, top = 16.dp, bottom = 16.dp)
                    .weight(0.7f),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(android.graphics.Color.parseColor(data.color)),
                    contentColor = Color.White
                )
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Outlined.Pets,
                        modifier = Modifier.padding(6.dp),
                        contentDescription = stringResource(id = R.string.pet_favourite)
                    )

                    Text(text = "Adopt")
                }
            }
        }
    }
}

@Preview
@Composable
fun PetDetailActionPreview() {
    PetAction(MockData.doggos[0])
}
