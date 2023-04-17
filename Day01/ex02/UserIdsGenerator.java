public class UserIdsGenerator {

	private int id;

	private static UserIdsGenerator instance = null;
	
	private UserIdsGenerator(){}

	public static UserIdsGenerator getInstance(){
		if(instance == null)
			instance = new UserIdsGenerator();
	   return instance;
	}
	public int getId()
	{
		return this.id;
	}
	public int generateId(){
		this.id = 1 + getInstance().getId();
		return this.id;
	}
 }