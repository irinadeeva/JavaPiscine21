package edu.school21.chat.models;

import java.sql.Timestamp;
import java.util.Date;

public class Message {
    private long id;
    private User author;
    private Chatroom room;
    private String text;
    private Timestamp sentTime;

    public static class Builder {
        private long id;
        private User author;
        private Chatroom room;
        private String text;
        private Timestamp sentTime;

        public Builder(long id) {
            this.id = id;
        }

        public Builder author(User author) {
            this.author = author;
            return this;
        }

        public Builder room(Chatroom room) {
            this.room = room;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder sentTime(Timestamp date) {
            this.sentTime = date;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }

    private Message(Builder builder) {
        id = builder.id;
        author = builder.author;
        room = builder.room;
        text = builder.text;
        sentTime = builder.sentTime;
    }

    public Message(long id, User author, Chatroom room, String text, Timestamp sentTime) {
        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.sentTime = sentTime;
    }

    public long getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public Chatroom getRoom() {
        return room;
    }

    public String getText() {
        return text;
    }

    public Timestamp getSentTime() {
        return sentTime;
    }

    public void setId(long id) {
        this.id = id;
    }

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
        return "Message {\n" +
                    "id = " + id + ",\n" +
                    "author = " + author + ",\n" +
                    "room = " + room + ",\n" +
                    "text = \"" + text + '\"' + ",\n" +
                    "dateTime = " + sentTime + ",\n" +
                '}';
    }
}
