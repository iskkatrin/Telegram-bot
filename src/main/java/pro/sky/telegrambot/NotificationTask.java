package pro.sky.telegrambot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class NotificationTask {
    @Id
    @GeneratedValue

    private Long id;
    private String title;
    private LocalDateTime dateTime;
    private boolean completed;
}
