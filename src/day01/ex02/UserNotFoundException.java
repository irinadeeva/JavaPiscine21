package day01.ex02;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User is not found");
    }
}
