package com.example.socialmediakotlin

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

open class News() : Parcelable {

    private var imageUrl = 0
    private var date: String? = null
    private var author: String? = null
    private var imageUrl2 = 0
    private var theme: String? = null
    private var ratingCount: String? = null
    private var commentsCount: String? = null


    constructor (
        imageUrl: Int,
        date: String,
        author: String,
        imageUrl2: Int,
        theme: String,
        ratingCount: String,
        commentsCount: String) : this() {
        this.imageUrl = imageUrl;
        this.date = date;
        this.author = author;
        this.imageUrl2 = imageUrl2;
        this.theme = theme;
        this.ratingCount = ratingCount;
        this.commentsCount = commentsCount
    }

    protected constructor (parcel: Parcel) : this() {
        this.imageUrl = parcel.readInt()
        this.date = parcel.readString()
        this.author = parcel.readString()
        this.imageUrl2 = parcel.readInt()
        this.theme = parcel.readString()
        this.ratingCount = parcel.readString()
        this.commentsCount = parcel.readString()
    }

    fun getDate(): String? {
        return date
    }

    fun getAuthor(): String? {
        return author
    }

    fun getImageUrl2(): Int {
        return imageUrl2
    }

    fun getTheme(): String? {
        return theme
    }

    fun getRatingCount(): String? {
        return ratingCount
    }

    fun getCommentsCount(): String? {
        return commentsCount
    }

    fun getImageUrl(): Int {
        return imageUrl
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "News(imageUrl=$imageUrl, date=$date, author=$author," +
                " imageUrl2=$imageUrl2, theme=$theme, ratingCount=$ratingCount," +
                " commentsCount=$commentsCount)"
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeInt(this.imageUrl)
        dest?.writeString(this.date)
        dest?.writeString(this.author)
        dest?.writeInt(this.imageUrl2)
        dest?.writeString(this.theme)
        dest?.writeString(this.ratingCount)
        dest?.writeString(this.commentsCount)
    }

    companion object CREATOR : Parcelable.Creator<News> {
        override fun createFromParcel(parcel: Parcel): News {
            return News(parcel)
        }

        override fun newArray(size: Int): Array<News?> {
            return arrayOfNulls(size)
        }
    }

}