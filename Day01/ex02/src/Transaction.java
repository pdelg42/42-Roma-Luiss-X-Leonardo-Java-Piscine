import java.util.UUID;

public class Transaction {
    private UUID    _identifier;
    private String  _sender;
    private String  _recipient;
    private Category _category;
    private int     _amount;
    public enum Category {
        DEBTS, CREDITS
    }

    private void setParameters(User sender, User recipient, int transferAmount, Category category) {
        this._identifier = UUID.randomUUID();
        this._sender = sender.getName();
        this._recipient = recipient.getName();
        this._category = category;
        this._amount = transferAmount;
        sender.lessBalance(transferAmount);
        recipient.addBalance(transferAmount);
    }
    public Transaction(User sender, User recipient, int transferAmount, Category category) {
        if (sender != null && recipient != null && sender.getBalance() > 0
                && transferAmount > 0 && transferAmount <= sender.getBalance()
                && !sender.equals(recipient)) {
            if (category == Category.DEBTS) {
                this.setParameters(sender, recipient, transferAmount, category);
            } else if (category == Category.CREDITS) {
                this.setParameters(sender, recipient, transferAmount, category);
            }
        } else {
            System.out.println("Transaction not available.");
        }
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
}
