package br.com.fiap.hello.model

data class Announcements(
    val message: String,
    val payload: List<Payload>,
    val error: List<String>
) {
    data class Payload(
        val announcementId: Int,
        val userName: String,
        val title: String,
        val description: String? = null,
        val listingTitle: String,
        val displayNumber: Int,
        val category: String,
        val date: String,
        val time: String,
    )
}

