package pro.sky.telegrambot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.Reminder;

@Service
public class ReminderService {
    @Autowired
   private Reminder reminder;
}
