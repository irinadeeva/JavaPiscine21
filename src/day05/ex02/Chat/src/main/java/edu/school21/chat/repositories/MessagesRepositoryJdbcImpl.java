package edu.school21.chat.repositories;

import edu.school21.chat.app.DataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    private Connection connection;
    private String SQL_QUERY = "select * from messages " +
            "left join users u on messages.authorId = u.userId " +
            "left join rooms r on messages.roomId = r.roomId" +
                                " where messagesId = ";


    public MessagesRepositoryJdbcImpl() {
        try {
            connection = DataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Optional<Message> findById(Long id) {
        Message message = null;

        try (PreparedStatement pst = connection.prepareStatement(SQL_QUERY + id);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                message = new Message.Builder(rs.getInt("messagesId"))
                        .author(new User(rs.getInt("authorId"),
                                rs.getString("login"),
                                rs.getString("password")))
                        .room(new Chatroom(rs.getInt("roomId"),
                                rs.getString("name")))
                        .text(rs.getString("text"))
                        .sentTime(rs.getTimestamp("date")).build();
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (message != null)
            return Optional.of(message);
        return Optional.empty();
    }

    @Override
    public void save(Message message) {

        Long userId = message.getAuthor().getId();
        Long roomId = message.getRoom().getId();

        try {
            PreparedStatement pst = connection.prepareStatement(String.format("SELECT * FROM users WHERE userId = %d", userId));
            ResultSet rs = pst.executeQuery();
            if (!rs.next()) {
                throw new NotSavedSubEntityException("There is no user with id =  " + userId);
            }

            pst = connection.prepareStatement(String.format("SELECT * FROM rooms WHERE roomId = %d", roomId));
            rs = pst.executeQuery();
            if (!rs.next()) {
                throw new NotSavedSubEntityException("There is no room with id =  " + roomId);
            }

            pst = connection.prepareStatement(
                    String.format("INSERT INTO messages (text, authorid, roomid, date) " +
                                    "VALUES (%s, %d, %d, %s) RETURNING messagesId",
                            message.getText() == null ? null : "'" + message.getText() + "'",
                            userId, roomId,
                            message.getSentTime() == null ? null : "'" + message.getSentTime().toString() + "'")
            );

            rs = pst.executeQuery();
            rs.next();
            Long messageId = rs.getLong(1);
            message.setId(messageId);




        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
