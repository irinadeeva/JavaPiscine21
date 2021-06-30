package day01.ex04;

public class UserIdsGenerator {

    static UserIdsGenerator instance = null;
    private static Integer counter = 0;

    private UserIdsGenerator() {
    }

    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }

    public Integer generateId() {
        return ++counter;
    }
}
