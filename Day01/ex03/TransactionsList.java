public interface TransactionsList {
	
	public Transaction[] toArray();
	public void printList();
	public void addInHead(Transaction transaction);
	public void addInTail(Transaction transaction);
	public void addAtIndex(Transaction transaction, int index);
	public Transaction delAtIndex(int index);
	public Transaction delForId(String id);
	public Transaction delHead();
	public Transaction delTail(); 
}
