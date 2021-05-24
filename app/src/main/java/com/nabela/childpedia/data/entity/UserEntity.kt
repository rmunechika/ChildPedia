package com.nabela.childpedia.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class UserEntity(
    var createdAt: String? = null,
    var id: String? = null,
    var updatedAt: String? = null,
    var birthdate: String? = null,
    var email: String? = null,
    var name: String? = null,
    var password: String? = null,
    var isReviewer: Boolean
): Parcelable