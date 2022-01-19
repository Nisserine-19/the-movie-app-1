package com.gmail.eamosse.idbdata.api.response

import com.google.gson.annotations.SerializedName

data class VideoResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("results")
    val video: List<Video>,
) {
    data class Video(
        @SerializedName("name")
        val name: String,
        @SerializedName("key")
        val key: String,
        @SerializedName("site")
        val site: String
    )
}

internal fun VideoResponse.Video.toVideo() = VideoResponse.Video(
    name = name,
    key = key,
    site = site
)
