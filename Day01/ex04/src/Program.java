import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        TransactionService transactionService = new TransactionService();

        transactionService.getService().addUser("Andrea", 200);
        transactionService.getService().addUser("Kokoroko", 200);
        transactionService.getService().addUser("Npsolus", 200);

        transactionService.getService().doTransaction(0, 1, 5000);
        transactionService.getService().doTransaction(1, 2, 100);
        transactionService.getService().doTransaction(2, 0, 80);

        // transactionService.getService().unpaired();
        transactionService.getService().print();

        Scanner scanner = new Scanner(System.in);
        int idInput;
        String input;

        idInput = scanner.nextInt();
        input = scanner.next();
        transactionService.getService().removeTransaction(input, idInput);

        idInput = scanner.nextInt();
        input = scanner.next();
        transactionService.getService().removeTransaction(input, idInput);

        scanner.close();
        transactionService.getService().print();

        transactionService.getService().unpaired();

    }
}
