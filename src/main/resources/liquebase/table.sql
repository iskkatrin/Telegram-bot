CREATE TABLE tasks (
                       task_id INT AUTO_INCREMENT PRIMARY KEY,
                       chat_id INT NOT NULL,
                       notification_text VARCHAR(255) NOT NULL,
                       send_date_time DATETIME NOT NULL,
                       additional_data VARCHAR(255)
);

