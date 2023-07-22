
public class Program {
    public static void main(String[] args) {

        User andrea = new User("Andrea", 200);
        User clefari = new User("Clefari", 0);


        Transaction debts = new Transaction(andrea, andrea, 100, Transaction.Category.valueOf("DEBTS"));
        System.out.println("amount    : " + debts.getAmount());
        System.out.println("category  : " + debts.getCategory());
        System.out.println("identifier: " + debts.getIdentifier());
        System.out.println("sender    : " + debts.getSender());
        System.out.println("recipient : " + debts.getRecipient());
        Transaction credits = new Transaction(andrea, clefari, 100, Transaction.Category.valueOf("CREDITS"));

        System.out.println("identifier: " + andrea.getIdentifier());
        System.out.println("name      : " + andrea.getName());
        System.out.println("balance   : " + andrea.getBalance());

        System.out.println("identifier: " + clefari.getIdentifier());
        System.out.println("name      : " + clefari.getName());
        System.out.println("balance   : " + clefari.getBalance());
    }
}
