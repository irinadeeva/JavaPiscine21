package day01.ex00;

import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("Alex", 95_000);
        User user2 = new User("Luka", 10_000);
        User user3 = new User("Adam", 150_000);
        User user4 = new User("Elen", -150_000);

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        System.out.println(user4);

        System.out.println("#-----------------------------------------------#");

        System.out.println("User 1 has a balance equal to " + user1.getBalance());
        System.out.println("User 2 has a balance equal to " + user2.getBalance());
        System.out.println("User 3 has a balance equal to " + user3.getBalance());
        System.out.println("User 4 has a balance equal to " + user4.getBalance());

        System.out.println("#-----------------------------------------------#");

        Transaction transaction1 = new Transaction(user2, user1, 10_000, UUID.randomUUID());
        Transaction transaction2 = new Transaction(user3, user4, -5_000, UUID.randomUUID());
        Transaction transaction3 = new Transaction(user4, user3, 1_000, UUID.randomUUID());

        System.out.println(transaction1);
        System.out.println(transaction2);
        System.out.println(transaction3);
    }
}
