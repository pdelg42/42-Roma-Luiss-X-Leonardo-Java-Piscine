public interface TransactionListInterface {
	
	void addTransaction(Transaction transaction);
	void removeTransactionbyID(String identifier) throws TransactionNotFoundException;
	Transaction[] toArray();
}
