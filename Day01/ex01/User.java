public class User {
	private int id;

	public User() {
		this.id = UserIdsGenerator.getInstance().generateId();
	}

	public int getId()
	{
		return this.id;
	}

}
