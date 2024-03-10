package pro.sky.telegrambot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.Repository.ReminderRepository;
import pro.sky.telegrambot.model.Reminder;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ReminderSchedulerService {

    @Autowired
    private ReminderRepository reminderRepository;

    @Scheduled(cron = "0 * * * * *")
    public void checkReminders() {
        LocalDateTime currentMinute = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);

        List<Reminder> reminders = reminderRepository.findRemindersByTime(currentMinute);

        System.out.println("Найдены записи для уведомления:");
        for (Reminder reminder : reminders) {
            System.out.println("Дата и время уведомления: " + reminder.getDateTime());
            System.out.println("Текст уведомления: " + reminder.getText());
        }
    }
}


