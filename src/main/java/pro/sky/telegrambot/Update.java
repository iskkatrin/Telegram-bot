package pro.sky.telegrambot;

import lombok.*;
import org.apache.logging.log4j.message.Message;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Update {
    private int updateId;
    private Message message;
}
