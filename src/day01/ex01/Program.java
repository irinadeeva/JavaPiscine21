package day01.ex01;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("Alex", 95_000);
        User user2 = new User("Luka", 10_000);
        User user3 = new User("Adam", 150_000);
        User user4 = new User("Elen", -150_000);

        System.out.println("User 1 has an id = " + user1.getIdentifier());
        System.out.println("User 2 has an id = " + user2.getIdentifier());
        System.out.println("User 3 has an id = " + user3.getIdentifier());
        System.out.println("User 4 has an id = " + user4.getIdentifier());
    }
}
