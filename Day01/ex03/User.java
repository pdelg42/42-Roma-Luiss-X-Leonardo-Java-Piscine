import java.util.UUID;

public class User {

	private UUID	identifier;
	private String	name;
	private float	balance;
	
	public User(String name) {
		this.identifier = UUID.randomUUID();
		this.name = name;
		this.balance = 499.99f;
	}
	public UUID getUserId(){
		return this.identifier;
	}
	public String getName(){
		return this.name;
	}
	public float getBalance(){
		return this.balance;
	}
}
