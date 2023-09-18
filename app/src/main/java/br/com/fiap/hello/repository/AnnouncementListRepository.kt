package br.com.fiap.hello.repository

import br.com.fiap.hello.R
import br.com.fiap.hello.model.Announcement

fun getAllAnnouncementList(): List<Announcement> {
    return listOf(
        Announcement(
            id = 1,
            image = R.drawable.person_blue,
            date = "18/03",
            displayNumber = 23,
            title = "Fique por dentro das atividades do seu filho aqui na escola ☺️",
            time = "08:00",
            category = "Todos os pais",
            listingTitle = "Horário escolar",
            description = null,
            imageAnnouncement = R.drawable.school_timetable,
        ),
        Announcement(
            id = 2,
            image = R.drawable.person_blue,
            date = "20/03",
            displayNumber = 52,
            title = "Avaliação mensal dos alunos. Não esqueça de conferir! ✍\uD83C\uDFFC️",
            time = "18:00",
            category = "Todos os pais e alunos",
            listingTitle = "Avaliação mensal",
            imageAnnouncement = R.drawable.monthly_assessment,
            description = "Avaliação Mensal na escola: 27/03 - Lembre-se de estudar e dar o seu melhor! \uD83D\uDC69\u200D\uD83C\uDFEB\uD83D\uDCDA\uD83D\uDCDD",
        ),
    )
}

fun getAnnouncementById(id: Int): Announcement? {
    return getAllAnnouncementList().find {
        it.id == id
    }
}