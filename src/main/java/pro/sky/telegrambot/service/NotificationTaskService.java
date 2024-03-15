package pro.sky.telegrambot.service;

import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.NotificationTask;
import pro.sky.telegrambot.repository.ReminderRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationTaskService {

    private final ReminderRepository reminderRepository;

    public NotificationTaskService(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    private void sendNotification(String Id, String text) {
        System.out.println("Отправка уведомления в чат " + Id + ": " + text);

    }

    public List<NotificationTask>  findBy (LocalDateTime localDateTime) {
        return reminderRepository.findAllByLocalDateTime(localDateTime);
    }

    public NotificationTask save(NotificationTask notificationTask) {
        return reminderRepository.save(notificationTask);
    }
}



