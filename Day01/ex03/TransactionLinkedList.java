import java.lang.reflect.Array;
import java.util.Arrays;

public class TransactionLinkedList{
	
	private	Node head;
	private	Node tail;
	private int size;

	public TransactionLinkedList() {
		this.size = 0;
	}

	public Transaction[] toArray() {
		Transaction [] ret = new Transaction[this.size];
		Node temp = this.get(0);
		int i = 0;

		while (size-- > 0) {
			ret[i] = temp.transaction;
			i++;
			temp = temp.next;
		}
		return (ret);
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.transaction + " -> ");
			temp = temp.next;
		}
		System.out.println("END");
	}

	public void addInHead(Transaction transaction) {
		Node node = new Node(transaction);
		node.next = head;
		head = node;

		if (tail == null) {
			tail = head;
		}
		size++;
	}

	public void addInTail(Transaction transaction) {
		if (tail == null) {
			addInHead(transaction);
			return ;
		}

		Node node = new Node(transaction);
		tail.next = node;
		tail = node;
		size++;
	}

	public void addAtIndex(Transaction transaction, int index) {
		if (index == 0) {
			addInHead(transaction);
			return ;
		}
		if (index == size) {
			addInTail(transaction);
			return ;
		}

		Node temp = head;
		for (int i = 1; i < index; i++) {
			temp = temp.next;
		}

		Node node = new Node(transaction, temp.next);
		temp.next = node;
	}

	public Transaction delAtIndex(int index) {
		if (index == 0) {
			return (delHead());
		}
		if (index == size - 1) {
			return (delTail());
		}

		Node prev = get(index - 1);
		Transaction transaction = prev.next.transaction;

		prev.next = prev.next.next;
		return (transaction);
	}

	public Transaction delForId(String id) {
		Node 	temp = head;
		int		index = 0;

		while (temp.next != null) {
			if (temp.transaction.getTransId().compareTo(id) == 0) {
				return (delAtIndex(index));
			}
			index++;
			temp = temp.next;
		}
		if (temp.next == null) {
			if (temp.transaction.getTransId().compareTo(id) == 0) {
				return (delTail());
			}
		}
		throw new TransactionNotFoundException("Transaction not found by index");
	}

	public Transaction delHead() {
		Transaction transaction = head.transaction;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		size--;
		return (transaction);
	}

	public Transaction delTail() {
		if (size <= 1) {
			return (delHead());
		}

		Node secondLast = get(size - 2);
		Transaction transaction = tail.transaction;
		tail = secondLast;
		tail.next = null;
		size--;
		return (transaction);
	}

	// public Node find(int value) {
	// 	Node node = head;
	// 	while (node != null) {
	// 		if (node.value == value) {
	// 			return (node);
	// 		}
	// 		node = node.next;
	// 	}
	// 	return (null);
	// }

	public Node get(int index) {
		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return (node);
	}

	private class Node {
		private Transaction transaction;
		private Node next;

		public Node(Transaction transaction) {
			this.transaction = transaction;
		}

		public Node(Transaction transaction, Node next) {
			this.transaction = transaction;
			this.next = next;
		}
	}
}
