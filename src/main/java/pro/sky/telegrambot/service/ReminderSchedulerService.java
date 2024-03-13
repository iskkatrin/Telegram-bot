package pro.sky.telegrambot.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.configuration.TelegramBotConfiguration;
import pro.sky.telegrambot.model.NotificationTask;
import pro.sky.telegrambot.repository.ReminderRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ReminderSchedulerService {

    private ReminderRepository reminderRepository;

    private TelegramBot telegramBot;

    public ReminderSchedulerService(ReminderRepository reminderRepository, TelegramBot telegramBot) {
        this.reminderRepository = reminderRepository;
        this.telegramBot = telegramBot;
    }


    @Scheduled(cron = "0 * * * * *")
    public void checkReminders() {
        LocalDateTime currentMinute = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);

        List<NotificationTask> notificationTasks = reminderRepository.findAllByLocalDateTime(currentMinute);

        for (NotificationTask notificationTask : notificationTasks) {
            System.out.println("Дата и время уведомления: " + notificationTask.getLocalDateTime());
            System.out.println("Текст уведомления: " + notificationTask.getMessageText());
            telegramBot.execute(new SendMessage(notificationTask.getChatId(), notificationTask.getMessageText()));
        }
    }
}


