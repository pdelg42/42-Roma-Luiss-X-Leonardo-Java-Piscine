public class User {

	private int id;
	private	String name;

	public User(String name) {
		this.id = UserIdsGenerator.getInstance().generateId();
		this.name = name;
	}

	public int getId() {
		return this.id;
	}
	public String getName(){
		return this.name;
	}
}
