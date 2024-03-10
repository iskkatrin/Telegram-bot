package pro.sky.telegrambot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.Reminder;

@Service
public class NotificationTaskService {

    @Autowired
    private Reminder reminder;

    private void sendNotification(String Id, String text) {
        System.out.println("Отправка уведомления в чат " + Id + ": " + text);
    }
}



