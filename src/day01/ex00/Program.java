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

        Transaction transaction1 = new Transaction(user1, user2, TransferCatagory.OUTCOME,50_000 );
        Transaction transaction2 = new Transaction(user1, user2, TransferCatagory.OUTCOME,5_000 );
       /* Transaction transaction2 = new Transaction();
        Transaction transaction3 = new Transaction();
        Transaction transaction4 = new Transaction();*/
        System.out.println("#-----------------------------------------------#");
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        System.out.println(user4);

    }
}
