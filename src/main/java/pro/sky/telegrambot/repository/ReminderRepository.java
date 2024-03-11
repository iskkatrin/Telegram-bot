package pro.sky.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pro.sky.telegrambot.model.Reminder;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReminderRepository  extends JpaRepository<Reminder, Long> {

    @Query("SELECT r FROM Reminder r WHERE r.dateTime = :time")
    List<Reminder> findRemindersByTime(@Param("time") LocalDateTime time);
}

