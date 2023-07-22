
public class Program {
    public static void main(String[] args) {

        User andrea = new User("Andrea", 200);
        User clefari = new User("Clefari", 0);
        User dario = new User("Dario", 200);
        User marco = new User("Marco", 0);
        User luis = new User("Luis", 200);
        User africa = new User("Africa", 0);


        Transaction debts = new Transaction(andrea, luis, 100, Transaction.Category.valueOf("DEBTS"));
        System.out.println("amount    : " + debts.getAmount());
        System.out.println("category  : " + debts.getCategory());
        System.out.println("identifier: " + debts.getIdentifier());
        System.out.println("sender    : " + debts.getSender());
        System.out.println("recipient : " + debts.getRecipient());
        Transaction credits = new Transaction(luis, africa, 100, Transaction.Category.valueOf("DEBTS"));

        System.out.println("identifier: " + andrea.getIdentifier());
        System.out.println("name      : " + andrea.getName());
        System.out.println("balance   : " + andrea.getBalance());
        System.out.println();
        System.out.println("identifier: " + clefari.getIdentifier());
        System.out.println("name      : " + clefari.getName());
        System.out.println("balance   : " + clefari.getBalance());
        System.out.println("identifier: " + dario.getIdentifier());
        System.out.println("name      : " + dario.getName());
        System.out.println("balance   : " + dario.getBalance());
        System.out.println();
        System.out.println("identifier: " + marco.getIdentifier());
        System.out.println("name      : " + marco.getName());
        System.out.println("balance   : " + marco.getBalance());
        System.out.println("identifier: " + luis.getIdentifier());
        System.out.println("name      : " + luis.getName());
        System.out.println("balance   : " + luis.getBalance());
        System.out.println();
        System.out.println("identifier: " + africa.getIdentifier());
        System.out.println("name      : " + africa.getName());
        System.out.println("balance   : " + africa.getBalance());
    }
}
