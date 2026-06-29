package com.github.bgrebennikovv.springmedia.navigation

import com.composables.icons.heroicons.outline.R

val Destination.iconResId: Int
    get() = when (this) {
        is Home -> R.drawable.heroicons_ic_home_outline
        is Shorts -> R.drawable.heroicons_ic_play_outline
        is CreateContent -> R.drawable.heroicons_ic_plus_outline
        is Subscriptions -> R.drawable.heroicons_ic_queue_list_outline
        is Profile -> R.drawable.heroicons_ic_user_outline
        else -> throw IllegalArgumentException("Unknown destination")
    }

val Destination.labelText: String
    get() = when (this) {
        is Home -> "Main"
        is Shorts -> "Shorts"
        is CreateContent -> ""
        is Subscriptions -> "Subs"
        is Profile -> "You"
        else -> ""
    }