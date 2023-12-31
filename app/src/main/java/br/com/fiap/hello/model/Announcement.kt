package br.com.fiap.hello.model

data class Announcement(
    val message: String? = null,
    val payload: Payload? = null,
    val error: List<String> = emptyList()
) {
    data class Payload(
        val announcementId: Int,
        val userName: String,
        val title: String,
        val description: String? = null,
        val imageAnnouncement: String? = null,
        val listingTitle: String,
        val displayNumber: Int,
        val category: String,
        val date: String,
        val time: String,
    )
}

