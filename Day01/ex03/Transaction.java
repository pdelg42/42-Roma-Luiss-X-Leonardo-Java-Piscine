import java.util.UUID;
import java.math.BigInteger;
import java.nio.ByteBuffer;

public class Transaction {
	
	private String	identifier;
	private User	recipient;
	private User	sender;
	private float	transferAmount;
	private String	transferCategory;

	private String generateUniqueId() {
        long 	val = -1;
		String 	str;
        do
        {
            final UUID uid = UUID.randomUUID();
            final ByteBuffer buffer = ByteBuffer.wrap(new byte[16]);
            buffer.putLong(uid.getLeastSignificantBits());
            buffer.putLong(uid.getMostSignificantBits());
            final BigInteger bi = new BigInteger(buffer.array());
            val = bi.longValue();
        } 
        while (val < 0);

		str = Long.toString(val);
        return (str);
    }

	public Transaction(User recipient, User sender, float transferAmount) {
		this.identifier = this.generateUniqueId();
		this.recipient = recipient;
		this.sender = sender;
		this.transferCategory = "debit";
		this.transferAmount = transferAmount;
	}

	public String getTransId() {
		return this.identifier;
	}

	public User getRecipient() {
		return this.recipient;
	}

	public User getSender() {
		return this.sender;
	}

	public float getTransferAmount() {
		return this.transferAmount;
	}

	public String getTransferCategory() {
		return this.transferCategory;
	}

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
}
