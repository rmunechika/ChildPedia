package com.nabela.childpedia.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class EncyclopediaEntity(
    var title: String,
    var category : String,
    var description: String,
    var image: String
) : Parcelable