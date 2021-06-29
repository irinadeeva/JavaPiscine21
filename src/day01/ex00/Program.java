package day01.ex00;

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

        Transaction transaction1 = new Transaction(user1, user2, TransferCategory.OUTCOME, -10_000);
        Transaction transaction2 = new Transaction(user2, user1, TransferCategory.INCOME, 10_000);
        Transaction transaction3 = new Transaction(user4, user3, TransferCategory.OUTCOME, -5_000);
        Transaction transaction4 = new Transaction(user3, user4, TransferCategory.INCOME, 5_000);
        Transaction transaction5 = new Transaction(user3, user4, TransferCategory.OUTCOME, -5_000);
        Transaction transaction6 = new Transaction(user4, user3, TransferCategory.INCOME, 5_000);

        System.out.println("#-----------------------------------------------#");
        System.out.println(transaction1);
        System.out.println(transaction2);
        System.out.println(transaction3);
        System.out.println(transaction4);
        System.out.println(transaction5);
        System.out.println(transaction6);

        System.out.println("#-----------------------------------------------#");
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        System.out.println(user4);


    }
}
