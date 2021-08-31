package edu.school21.chat.app;

import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.util.Optional;

public class Program {
    public static void main(String[] args) {

        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl();
        Optional<Message> optMsg = messagesRepository.findById(2L);
        if (optMsg.isPresent())
            System.out.println(optMsg.get());
        else
            System.out.println("There is no message with this id.");

    }
}
