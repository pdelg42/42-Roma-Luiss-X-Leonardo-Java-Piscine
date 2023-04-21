import java.lang.reflect.Array;
import java.util.Arrays;

public class Program {

	public static void main(String[] args) {
		TransactionLinkedList list = new TransactionLinkedList();
		User recipient = new User("And");
		User sender = new User("Tif");
		Transaction transaction0 = new Transaction(recipient, sender, 499.99f);
		Transaction transaction1 = new Transaction(recipient, sender, 499.98f);
		Transaction transaction2 = new Transaction(recipient, sender, 499.97f);
		Transaction transaction3 = new Transaction(recipient, sender, 499.96f);
		Transaction transaction4 = new Transaction(recipient, sender, 499.95f);
		Transaction transaction5 = new Transaction(recipient, sender, 499.94f);
		Transaction transaction6 = new Transaction(recipient, sender, 499.93f);

		list.addInHead(transaction3);
		list.addInHead(transaction2);
		list.addInHead(transaction1);
		list.addInHead(transaction0);
		// list.addInTail((transaction5));
		// list.addAtIndex(transaction4, 4);
		list.printList();
		//System.out.println(list.delHead() + " deleted.");
		//list.printList();
		//System.out.println(list.delTail() + " deleted.");
		//list.printList();
		// System.out.println(list.delForId((transaction6.getTransId())) + " deleted.");
		//list.printList();

		for (Transaction t : list.toArray())	{
			System.out.println(t.toString());
		}

	}
}
