package br.com.fiap.hello.model

data class Announcement(
    val id: Int,
    val image: Int,
    val imageUser: Int,
    val userName: String,
    val listingTitle: String,
    val title: String,
    val date: String,
    val time: String,
    val description: String? = null,
    val imageAnnouncement: Int,
    val displayNumber: Int,
    val category: String,
)
