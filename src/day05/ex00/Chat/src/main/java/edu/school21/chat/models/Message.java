package edu.school21.chat.models;

import java.util.Date;

public class Message {
    private long id;
    private User author;
    private Chatroom room;
    private String text;
    private Date  sentTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (id != message.id) return false;
        if (!author.equals(message.author)) return false;
        if (!room.equals(message.room)) return false;
        if (!text.equals(message.text)) return false;
        return sentTime.equals(message.sentTime);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + author.hashCode();
        result = 31 * result + room.hashCode();
        result = 31 * result + text.hashCode();
        result = 31 * result + sentTime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", author=" + author +
                ", room=" + room +
                ", text='" + text + '\'' +
                ", sentTime=" + sentTime +
                '}';
    }
}
