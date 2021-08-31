package edu.school21.chat.app;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Program {
    public static void main(String[] args) {

        User creator = new User(1L, "john", "1111", new ArrayList(), new
                ArrayList());
        Chatroom room = new Chatroom(1L, "chatroom №1", creator, new ArrayList());
        Message message = new Message(-1, creator, room, "Hello!",
                Timestamp.valueOf(LocalDateTime.now()));
        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl();
        messagesRepository.save(message);
        System.out.println(message.getId());

    }
}
