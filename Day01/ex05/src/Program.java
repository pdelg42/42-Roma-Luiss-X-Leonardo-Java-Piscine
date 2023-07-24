import java.util.Scanner;
import java.util.InputMismatchException;

public class Program {

    public static void main(String[] args) {
        String profile = "production"; // Default mode is production

        if (args.length > 0 && args[0].equals("--profile=dev")) {
            profile = "dev"; // Set mode to dev if specified in arguments
        }

        System.out.println("Welcome to the Transactions App!");
        System.out.println("Running in " + profile + " mode.\n");

        displayMenu(profile);
    }

    private static void displayMenu(String profile) {
        Scanner scanner = new Scanner(System.in);
        TransactionService transactionService = new TransactionService();
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Add a user");
            System.out.println("2. View user balances");
            System.out.println("3. Perform a transfer");
            System.out.println("4. View all transactions for a specific user");
            System.out.println("5. DEV - remove a transfer by ID");
            System.out.println("6. DEV - check transfer validity");
            System.out.println("7. Finish execution");
            System.out.print("-> ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter a user name and a balance");
                    String userName = scanner.next();
                    int balance = scanner.nextInt();
                    scanner.nextLine();
                    transactionService.getService().addUser(userName, balance);
                    System.out.println("--------------------------------");
                    break;
                case 2:
                    System.out.println("Enter a userId");
                    int userid = scanner.nextInt();
                    scanner.nextLine();
                    transactionService.getService().getUser(userid);
                    System.out.println("--------------------------------");
                    break;
                case 3:
                    System.out.println("Enter sender ID, recipient ID and the transfer amount");
                    int sender = scanner.nextInt();
                    int pizzo = scanner.nextInt();
                    int amount = scanner.nextInt();
                    scanner.nextLine();
                    transactionService.getService().doTransaction(sender, pizzo, amount);
                    System.out.println("--------------------------------");
                    break;
                case 4:
                    System.out.println("Enter a userId");
                    int findId = scanner.nextInt();
                    scanner.nextLine();
                    transactionService.getService().getTransactionUser(findId);
                    System.out.println("--------------------------------");
                    break;
                case 5:
                    if (profile.equals("dev")) {
                        System.out.println("Enter a transId and a userId");
                        String transId = scanner.next();
                        int id = scanner.nextInt();
                        transactionService.getService().getTransactionUser2(id, transId);
                        transactionService.getService().removeTransaction(transId, id);
                        scanner.nextLine();
                        System.out.println("--------------------------------");
                    } else {
                        System.out.println("Invalid option. Try again.");
                        System.out.println("--------------------------------");
                    }
                    break;
                case 6:
                    if (profile.equals("dev")) {
                        System.out.println("Check results");
                        transactionService.getService().unpaired();
                        System.out.println("--------------------------------");
                    } else {
                        System.out.println("--------------------------------");
                        System.out.println("Invalid option. Try again.");
                    }
                    break;
                case 7:
                    System.out.println("Finishing execution. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    System.out.println("--------------------------------");
            }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter a valid option (an integer).");
                System.out.println("--------------------------------");
                choice = 0;
            }
        } while (choice != 7);

        scanner.close();
    }
}
