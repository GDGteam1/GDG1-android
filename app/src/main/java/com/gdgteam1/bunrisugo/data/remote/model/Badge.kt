package com.gdgteam1.bunrisugo.data.remote.model

data class Badge(
    val badgeId: Int,
    val badgeName: String,
    val badgeIconUrl: String,
    val badgeCondition: String,
    val isActive: Boolean
)
