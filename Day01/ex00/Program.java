import java.util.UUID;

public class Program {

	public static boolean preTransaction(Transaction transaction) {
		
		boolean state;

		state = false;
		if (transaction.getSender().getBalance() > 0 && transaction.getTransferAmount() > 0 && transaction.getSender().getBalance() >= transaction.getTransferAmount())
			state = true;
		return (state);
	}

	public  static void doTransaction(Transaction transaction) {
		System.out.print(transaction.getSender().getName() + " -> " + transaction.getRecipient().getName() + ", -" + transaction.getTransferAmount() + ", OUTCOME, " + transaction.getTransId());
		System.out.println();
		System.out.print(transaction.getRecipient().getName() + " -> " + transaction.getSender().getName() + ", +" + transaction.getTransferAmount() + ", INCOME, " + transaction.getTransId());
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		User recipient = new User("And");
		User sender = new User("Tif");
		Transaction transaction = new Transaction(recipient, sender, 499.98f);

		if (preTransaction(transaction))
			doTransaction(transaction);
		else
			System.out.println("Stai senza una lira!");
	}
}
