package day01.ex02;

public interface UsersList {
    boolean addUser(User user);

    User getUserByID(Integer id) throws UserNotFoundException;

    User UserByIndex(Integer index);

    Integer getNumberOfUsers();
}
