package com.songul.tozboya.model

public class ExpandedMenuModel {
    private var iconName :String=""
    private var iconImg = -1 // menu icon resource id


    fun getIconName(): String? {
        return iconName
    }

    fun setIconName(iconName: String) {
        this.iconName = iconName
    }

    fun getIconImg(): Int {
        return iconImg
    }

    fun setIconImg(iconImg: Int) {
        this.iconImg = iconImg
    }
}