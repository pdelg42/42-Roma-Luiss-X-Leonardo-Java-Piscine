import java.util.UUID;
import java.math.BigInteger;
import java.nio.ByteBuffer;

public class Transaction {
	
	private long	identifier;
	private User	recipient;
	private User	sender;
	private float	transferAmount;
	private String	transferCategory;

	private Long generateUniqueId() {
        long val = -1;
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
        return val;
    }

	public Transaction(User recipient, User sender, float transferAmount) {
		this.identifier = this.generateUniqueId();
		this.recipient = recipient;
		this.sender = sender;
		this.transferCategory = "debit";
		this.transferAmount = transferAmount;
	}

	public long getTransId(){
		return this.identifier;
	}

	public User getRecipient(){
		return this.recipient;
	}

	public User getSender(){
		return this.sender;
	}

	public float getTransferAmount()
	{
		return this.transferAmount;
	}
	
	public String getTransferCategory()
	{
		return this.transferCategory;
	}
}
