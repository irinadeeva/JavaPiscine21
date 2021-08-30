package edu.school21.chat.logic;

import java.util.List;

public class User {
    private long id;
    private String login;
    private String password;
    private List <Chatroom> createdRooms;
    private List <Chatroom> activeRooms;
}
