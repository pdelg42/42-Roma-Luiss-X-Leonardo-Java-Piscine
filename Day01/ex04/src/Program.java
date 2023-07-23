import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        TransactionService transactionService = new TransactionService();

        transactionService.getService().addUser("Andrea", 200);
        transactionService.getService().addUser("Kokoroko", 200);
        transactionService.getService().addUser("Npsolus", 200);

        transactionService.getService().doTransaction(0, 7, 50);
        transactionService.getService().doTransaction(1, 2, 100);
        transactionService.getService().doTransaction(2, 0, 80);

        transactionService.getService().print();

        Scanner scanner = new Scanner(System.in);
        int idInput;
        String input;

        idInput = scanner.nextInt();
        input = scanner.next();
        scanner.close();

        transactionService.getService().removeTransaction(input, idInput);

        transactionService.getService().print();
    }
}
