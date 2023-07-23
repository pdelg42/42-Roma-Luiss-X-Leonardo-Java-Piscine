import java.util.UUID;

public class TransactionService {

	private Service _service;

	public TransactionService() {
		_service = new Service();
	}

	public Service getService() {
		return this._service;
	}
}

class Service {

	private UserArrayList _userList;
	private TransactionList _transactionList;

	public Service() {
		_userList = new UserArrayList();
		_transactionList = new TransactionList();
	}

	public void addUser(String name, int balance) {

		User temp = new User(name, balance);

		_userList.addUser(temp);
	}

	public UserArrayList getUserArrayList() {
		return this._userList;
	}

	public int userBalance(int id) {
		try {
			User temp = _userList.userById(id);
			System.out.print(temp.getName() + ": ");
			return temp.getBalance();
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}

	public Transaction[] userTransactionList(int id) {
		try {
			User temp = _userList.userById(id);
			Transaction[] transactionList = temp.getTransactionList().toArray();
			return transactionList;
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void doTransaction(int senderID, int recipientID, int transferAmount) {

		try {
			User sender = _userList.userById(senderID);
			User recipient = _userList.userById(recipientID);
			if (sender != null && recipient != null) {
				Transaction temp = new Transaction(sender, recipient, transferAmount);
				_transactionList.addTransaction(temp);
			}
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public Transaction[] removeTransaction(String transactionID, int userID) {

		for (User u : _userList._usersArray) {
			if (u.getIdentifier() == userID) {
				try {
					u.getTransactionList().removeTransactionbyID(transactionID);
					Transaction[] temp = userTransactionList(userID);
					return temp;
				} catch (TransactionNotFoundException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return null;
	}

	void printTransaction(Transaction[] userTransactionList) {
		for (Transaction t : userTransactionList) {
			System.out.println(t.getIdentifier() + " " + t.getCategory());
		}
		System.out.println("\n");
	}

	void print() {
		int i = -1;

		while (_userList._usersArray[++i] != null) {
			System.out.println("User id:" + _userList._usersArray[i].getIdentifier() + " Balance:"
					+ _userList._usersArray[i].getBalance() + " Name:" + _userList._usersArray[i].getName());
			printTransaction(_userList._usersArray[i].getTransactionList().toArray());
		}
	}

	public boolean unpaired() {
		return false;
	}
}
