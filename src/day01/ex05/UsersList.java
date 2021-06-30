package day01.ex05;

public interface UsersList {
    boolean addUser(User user);

    User getUserByID(Integer id) throws UserNotFoundException;

    User UserByIndex(Integer index);

    Integer getNumberOfUsers();
}
