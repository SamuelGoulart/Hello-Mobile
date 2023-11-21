package br.com.fiap.hello.service

import br.com.fiap.hello.model.Announcement
import br.com.fiap.hello.model.Announcements
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AnnouncementService {
    @GET("/api/v1/announcements")
    fun getAllAnnouncement(): Call<Announcements>

    @GET("/api/v1/announcements/{announcementId}")
    fun getAnnouncementById(
        @Path("announcementId") announcementId: Int
    ): Call<Announcement>

}