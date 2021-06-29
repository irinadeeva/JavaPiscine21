package day01.ex02;

public class Program {
    public static void main(String[] args) throws UserNotFoundException {
        UsersArrayList usersArrayList = new UsersArrayList();
        User user1 = new User("Alex", 95_000);
        User user2 = new User("Luka", 10_000);
        User user3 = new User("Adam", 150_000);
        User user4 = new User("Elen", -150_000);
        User user5 = new User("Julia", 110_000);
        User user6 = new User("Sara", 1250_000);
        User user7 = new User("Ruth", 10_000);
        User user8 = new User("Sam", 954_000);
        User user9 = new User("Charles", 105_000);
        User user10 = new User("Lisa", 155_000);
        User user11 = new User("Paris", 50_000);
        User user12 = new User("Kate", 51_000);

        usersArrayList.addUser(user1);
        usersArrayList.addUser(user2);
        usersArrayList.addUser(user3);
        usersArrayList.addUser(user4);
        usersArrayList.addUser(user5);
        usersArrayList.addUser(user6);
        usersArrayList.addUser(user7);
        usersArrayList.addUser(user8);
        usersArrayList.addUser(user9);
        usersArrayList.addUser(user10);
        usersArrayList.addUser(user11);
        usersArrayList.addUser(user12);

        System.out.println(usersArrayList.getNumberOfUsers());
        System.out.println(usersArrayList.UserByIndex(11));
        System.out.println(usersArrayList.getUserByID(5));

        System.out.println(usersArrayList);

    }
}
