import java.util.UUID;

class Node {
	Transaction _transaction;
	Node 		next;
	Node		prev;

	public Node(Transaction transaction) {
		this._transaction = transaction;
		this.prev = null;
		this.next = null;
	}
}

public class TransactionList implements TransactionListInterface {
	
	private Node _head;

	public TransactionList() {
		this._head = null;
	}

	@Override
	public void addTransaction(Transaction transaction) {
		Node temp = new Node(transaction);

		if (_head == null) {
			_head = temp;
		} else {
			Node ptr = _head;
			while(ptr.next != null) {
				ptr = ptr.next;
			}
			ptr.next = temp;
			temp.prev = ptr;
			temp.next = null;
		}
	}

	@Override
	public void removeTransactionbyID(String identifier) throws TransactionNotFoundException {
		Node ptr = _head;

		if (_head._transaction.getIdentifier().toString().equals(identifier)) {
			ptr = _head.next;
			_head.next = null;
			ptr.prev = null;
			_head = ptr;
			System.out.println("Transaction " + identifier + ": deleted.");
			return ;
		} else {
			while (ptr != null) {
				if (ptr._transaction.getIdentifier().toString().equals(identifier)) {
					if (ptr.next == null) {
						ptr.prev.next = null;
						System.out.println("Transaction " + identifier + ": deleted.");
						return ;
					} else {
						ptr.prev.next = ptr.next;
						ptr.next.prev = ptr.prev;
						System.out.println("Transaction " + identifier + ": deleted.");
						return  ;
					}
				}
				ptr = ptr.next;
			}
			throw new TransactionNotFoundException("Transaction not in archive.");
		}
	}

	public void printList() {
		Node ptr = this._head;

		if (this._head != null) {
			while (ptr != null) {
				System.out.println(ptr._transaction.getIdentifier());
				ptr = ptr.next;
			}
		}
	}

	public int lenList() {
		Node	ptr = this._head;
		int		i = 0;

		if (this._head != null) {
			while (ptr != null) {
				i++;
				ptr = ptr.next;
			}
			System.out.println("Lenlist: " + i);
			return i;
		}
		return i;
	}

	@Override
	public Transaction[] toArray() {
		Transaction[] 	arrayTransactionList = new Transaction[this.lenList()];
		Node			ptr = this._head;
		int				i = 0;

		if (this._head != null) {	
			while (ptr != null) {
				arrayTransactionList[i] = ptr._transaction;
				ptr = ptr.next;
				i++;
			}
		}
		return arrayTransactionList;
	}
}
