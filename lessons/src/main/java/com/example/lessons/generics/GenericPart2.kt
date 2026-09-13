package com.example.lessons.generics

import com.example.lessons.patterns.MessageNotification
import com.example.lessons.patterns.NewsNotification
import com.example.lessons.patterns.Notification


fun main() {
    val newsNotif =
        NewsNotification(
            1,
            "news in stories",
            "ahowhcwhcuqec",
            "test message"
        )

    val notifHandler = NotificationHandler(notif = newsNotif)

    val messageNotif = MessageNotification(
        2, "from Ilkin", "salam muellim", 200
    )
    val mesNotifHandler = NotificationHandler<MessageNotification>(notif = messageNotif)

    val notif: Notification = messageNotif


}


class NotificationHandler<in T : Notification>(
    private var notif: T
) {

    fun setNotifData(data : T) {
        this.notif = data
    }

}