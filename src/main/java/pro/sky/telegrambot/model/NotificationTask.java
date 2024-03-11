package pro.sky.telegrambot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "tasks")
public class NotificationTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "chatId")
    private Long chatId;

    @Column(name = "time_and_date")
    private LocalDateTime localdateTime;

    @Column(name = "messageText")
    private String messageText;
}
