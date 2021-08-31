package edu.school21.chat.models;

import java.util.List;

public class Chatroom {
    private long id;
    private String name;
    private User owner;
    private List<Message> allMessages;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chatroom chatroom = (Chatroom) o;

        if (id != chatroom.id) return false;
        if (!name.equals(chatroom.name)) return false;
        if (!owner.equals(chatroom.owner)) return false;
        return allMessages != null ? allMessages.equals(chatroom.allMessages) : chatroom.allMessages == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + owner.hashCode();
        result = 31 * result + (allMessages != null ? allMessages.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", allMessages=" + allMessages +
                '}';
    }
}
