import java.util.UUID;

public class Transaction {
    private UUID _identifier;
    private String _sender;
    private String _recipient;
    private Category _category;
    private int _amount;
    private int     _senderId;
    private int     _recipientId;

    public enum Category {
        DEBTS, CREDITS
    }

    public Transaction() {
        this._identifier = null;
        this._sender = null;
        this._recipient = null;
        this._category = null;
        this._amount = 0;
    }

    private void setParameters(User sender, User recipient, int transferAmount) {
        this._identifier = UUID.randomUUID();
        this._sender = sender.getName();
        this._recipient = recipient.getName();
        this._category = null;
        this._amount = transferAmount;
        sender.lessBalance(transferAmount);
        recipient.addBalance(transferAmount);
        sender.getTransactionList().addTransaction(this.setCategory("DEBTS"));
        Transaction temp = new Transaction();
        temp._identifier = this._identifier;
        temp._sender = this._sender;
        temp._recipient = this._recipient;
        temp._amount = this._amount;
        this._senderId = sender.getIdentifier();
        this._recipientId = recipient.getIdentifier();
        recipient.getTransactionList().addTransaction(temp.setCategory("CREDITS"));
    }

    public Transaction(User sender, User recipient, int transferAmount) throws IllegalTransactionException {
        if (sender != null && recipient != null && sender.getBalance() > 0
                && transferAmount > 0 && transferAmount <= sender.getBalance()
                && !sender.equals(recipient)) {
            this.setParameters(sender, recipient, transferAmount);
            return;
        }
        throw new IllegalTransactionException("Illegal Transaction");
    }

    private Transaction setCategory(String category) {
        this._category = Transaction.Category.valueOf(category);
        return this;
    }

    public UUID getIdentifier() {
        return this._identifier;
    }

    public String getSender() {
        return this._sender;
    }

    public String getRecipient() {
        return this._recipient;
    }

    public Category getCategory() {
        return this._category;
    }

    public Integer getAmount() {
        return this._amount;
    }

    public int getSenderId() {
        return this._senderId;
    }

    public int getRecipientId() {
        return this._recipientId;
    }
}
