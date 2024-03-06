package pro.sky.telegrambot.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TelegramBotUpdatesListener implements UpdatesListener {

    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);
    private Update update;

    @Autowired
    private TelegramBot telegramBot;

    public TelegramBotUpdatesListener(Update update) {
        this.update = update;
    }

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            logger.info("Processing update: {}", update);
            if (update.getMessage().getText().equals("/start")) {
                String chatId = update.getMessage().getChat().getId();
                String greetingMessage = "Привет! Я бот. Как я могу помочь вам?";
                telegramBot.sendMessage(new SendMessage(chatId, greetingMessage));
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
}
