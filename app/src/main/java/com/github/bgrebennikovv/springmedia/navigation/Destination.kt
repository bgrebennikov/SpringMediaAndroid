package com.github.bgrebennikovv.springmedia.navigation

import kotlinx.serialization.Serializable

interface Destination

@Serializable object Home : Destination
@Serializable object Shorts : Destination
@Serializable object CreateContent : Destination
@Serializable object Subscriptions : Destination
@Serializable object Profile : Destination