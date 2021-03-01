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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.ui.screen.home.viewparam.PetItem

object MockData {

    fun getDoggo(id: String): PetItem? {
        return doggos.firstOrNull { it.id == id }
    }

    fun getOwner(id: String): Owner? {
        return owners.firstOrNull { it.id == id }
    }

    val categories = listOf(
        Category("0", "All"),
        Category("1", "Companion"),
        Category("2", "Pastoral"),
        Category("3", "Guard"),
        Category("4", "Hunting")
    )

    val owners = listOf(
        Owner("1", "John Doe", "2.89 km"),
        Owner("2", "Zanny", "4.52 km"),
        Owner("3", "Cilvanis", "1.25 km"),
    )

    val doggos = listOf<PetItem>(
        PetItem(
            id = "1",
            ownerId = "1",
            breed = "Welsh Corgi",
            weight = "10-14 kg",
            height = "25-30 cm",
            region = "Italy",
            city = "Venice",
            description = "The Pembroke Welsh Corgi is a cattle herding dog breed that originated in Pembrokeshire, Wales. It is one of two breeds known as a Welsh Corgi. The other is the Cardigan Welsh Corgi, and both descend from the line of northern spitz-type dogs",
            color = "#81d7e4",
            categories = listOf(
                "2"
            ),
            properties = listOf(
                PetItem.Property("Sex", "Male"),
                PetItem.Property("Age", "10 months"),
                PetItem.Property("Weight", "10-14 kg"),
                PetItem.Property("Height", "25-30 cm"),
                PetItem.Property("Temper", "Bold"),
                PetItem.Property("Life", "12-15 Y."),
            )
        ),
        PetItem(
            id = "2",
            ownerId = "2",
            breed = "Labrador Retriever",
            weight = "29-36 Kg",
            height = "57-62 cm",
            region = "California",
            city = "Los Angeles",
            description = "The Labrador Retriever, often abbreviated to Labrador, is a breed of retriever-gun dog from the United Kingdom that was developed from imported Canadian fishing dogs. The Labrador is one of the most popular dog breeds in a number of countries in the world, particularly in the Western world.",
            color = "#babcfd",
            categories = listOf(
                "4"
            ),
            properties = listOf(
                PetItem.Property("Sex", "Male"),
                PetItem.Property("Age", "12 months"),
                PetItem.Property("Weight", "29-36 kg"),
                PetItem.Property("Height", "57-62 cm"),
            )
        ),
        PetItem(
            id = "3",
            ownerId = "3",
            breed = "Beagle",
            weight = "10-11 Kg",
            height = "36-41 cm",
            region = "Switzerland",
            city = "Lugano",
            description = "The beagle is a breed of small hound that is similar in appearance to the much larger foxhound. The beagle is a scent hound, developed primarily for hunting hare.",
            color = "#dbb88f",
            categories = listOf(
                "4"
            ),
            properties = listOf(
                PetItem.Property("Sex", "Male"),
                PetItem.Property("Age", "9 months"),
                PetItem.Property("Weight", "10-11 kg"),
                PetItem.Property("Height", "36-41 cm"),
            )
        ),
        PetItem(
            id = "4",
            ownerId = "1",
            breed = "Siberian Husky",
            weight = "29-36 Kg",
            height = "54-60 cm",
            region = "California",
            city = "Sacramento",
            description = "The Siberian Husky is a medium-sized working sled dog breed. The breed belongs to the Spitz genetic family. It is recognizable by its thickly furred double coat, erect triangular ears, and distinctive markings, and is smaller than the similar-looking Alaskan Malamute.",
            color = "#ffa8a7",
            categories = listOf(
                "4"
            ),
            properties = listOf(
                PetItem.Property("Sex", "Male"),
                PetItem.Property("Age", "13 months"),
                PetItem.Property("Weight", "20-27 kg"),
                PetItem.Property("Height", "54-60 cm"),
            )
        ),
        PetItem(
            id = "5",
            ownerId = "2",
            breed = "Golden Retriever",
            weight = "25-32 Kg",
            height = "51-56 cm",
            region = "Germany",
            city = "Berlin",
            description = "The Golden Retriever is a medium-large gun dog that was bred to retrieve shot waterfowl, such as ducks and upland game birds, during hunting and shooting parties. The name \"retriever\" refers to the breed's ability to retrieve shot game undamaged due to their soft mouth.",
            color = "#ffc2c9",
            categories = listOf(
                "1"
            ),
            properties = listOf(
                PetItem.Property("Sex", "Female"),
                PetItem.Property("Age", "7 months"),
                PetItem.Property("Weight", "25-32 kg"),
                PetItem.Property("Height", "51-56 cm"),
            )
        ),
        PetItem(
            id = "6",
            ownerId = "3",
            breed = "Boxer",
            weight = "25-29 Kg",
            height = "53-60 cm",
            region = "Indonesia",
            city = "Jakarta",
            description = "The Boxer is a medium to large, short-haired breed of dog, developed in Germany. The coat is smooth and tight-fitting; colors are fawn, brindled, or white, with or without white markings.",
            color = "#f7ba94",
            categories = listOf(
                "1", "3"
            ),
            properties = listOf(
                PetItem.Property("Sex", "Female"),
                PetItem.Property("Age", "14 months"),
                PetItem.Property("Weight", "25-29 kg"),
                PetItem.Property("Height", "53-60 cm"),
            )
        ),
    )
}
