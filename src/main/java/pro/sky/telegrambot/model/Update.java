package pro.sky.telegrambot.model;

import lombok.*;
import org.apache.logging.log4j.message.Message;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Update {
    private int Id;
    private Message message;
}
