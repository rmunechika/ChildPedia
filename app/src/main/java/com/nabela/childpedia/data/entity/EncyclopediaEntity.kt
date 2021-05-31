package com.nabela.childpedia.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EncyclopediaEntity (
    var image :String,
    var title :String,
    var category :String,
    var description :String
) : Parcelable