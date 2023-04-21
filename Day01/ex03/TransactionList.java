public interface TransactionList {

    void addAtIndex(Transaction transaction, int index);
    void addInTail(Transaction transaction);
    void addInHead(Transaction transaction);
    void printList();
    public Transaction delAtIndex(int index);
    public Transaction delForId(String id);
    public Transaction delHead();
    public Transaction delTail();
    public Transaction[] toArray();
}
