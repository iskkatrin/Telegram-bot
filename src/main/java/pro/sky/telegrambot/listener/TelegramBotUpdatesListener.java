package pro.sky.telegrambot.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.NotificationTask;
import pro.sky.telegrambot.service.NotificationTaskService;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TelegramBotUpdatesListener implements UpdatesListener {

    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);

    @Autowired
    private TelegramBot telegramBot;

    @Autowired
    private NotificationTaskService notificationTaskService;

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process( List <Update> updates) {
        updates.forEach(update -> {
            logger.info("Processing update: {}", update);
            if (update.message().text().equals("/start")) {
                Long chatId = update.message().chat().id();
                String greetingMessage = "Привет! Я бот. Как я могу помочь вам?";
                telegramBot.execute(new SendMessage(chatId, greetingMessage));
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    public void processIncomingMessage(String message) {
        Pattern pattern = Pattern.compile("([0-9]{2}\\.[0-9]{2}\\.[0-9]{4} [0-9]{2}:[0-9]{2}) (.+)");
        Matcher matcher = pattern.matcher(message);

        if (matcher.find()) {
            String dateTimeString = matcher.group(1);
            String text = matcher.group(2);

            LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));

            NotificationTask notificationTask = new NotificationTask();
            notificationTask.setLocaldateTime(dateTime);
            notificationTask.setMessageText(messageText);

            notificationTaskService.save(notificationTask);
        }
    }
}
