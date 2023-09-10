package com.example.fuuplugins.activity.mainActivity.network

import androidx.glance.GlanceId
import com.example.fuuplugins.activity.mainActivity.network.bean.PluginJsonFromNetwork
import com.example.fuuplugins.activity.mainActivity.network.bean.PluginListFromNetwork
import com.example.fuuplugins.activity.mainActivity.network.bean.carousel.Carousel
import com.example.fuuplugins.activity.mainActivity.network.bean.carousel.CarouselPicture
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Streaming


interface PluginService {
    @GET("plugin/list")
    fun getPluginList(): Call<PluginListFromNetwork>

    @GET("plugin/{id}/md")
    @Streaming
    fun getPluginMd(@Path("id") id: String) : Call<ResponseBody>

    @GET("plugin/{id}/showJson")
    @Streaming
    fun getPluginJson(@Path("id") id: String) : Call<PluginJsonFromNetwork>

    @GET("carousel/list")
    fun getCarouselPictureList() : Call<CarouselPicture>
}