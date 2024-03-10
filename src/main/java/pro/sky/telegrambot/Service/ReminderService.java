package pro.sky.telegrambot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.Repository.ReminderRepository;
import pro.sky.telegrambot.model.Reminder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    public void processIncomingMessage(String message) {
        Pattern pattern = Pattern.compile("([0-9]{2}\\.[0-9]{2}\\.[0-9]{4} [0-9]{2}:[0-9]{2}) (.+)");
        Matcher matcher = pattern.matcher(message);

        if (matcher.find()) {
            String dateTimeString = matcher.group(1);
            String text = matcher.group(2);

            LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));

            Reminder reminder = new Reminder();
            reminder.setDateTime(dateTime);
            reminder.setText(text);

            reminderRepository.save(reminder);
        }
    }

}

