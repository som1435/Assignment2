package com.example.trendingprojects.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "project")
class Project {
    @PrimaryKey(autoGenerate = true)
    var projectId: Int = 0
    var title: String = ""
    var seller: String = ""
    var size: String = ""
    var location: String = ""
    var price: String = ""
    var isFavorite: Boolean = false

    constructor()
    constructor(
        _title: String,
        _seller: String,
        _size: String,
        _location: String,
        _price: String,
        _isFavorite: Boolean
    ) {
        title = _title
        seller = _seller
        size = _size
        location = _location
        price = _price
        isFavorite = _isFavorite
    }
}
