import java.util.ArrayList;

public class UsersArrayList {

	ArrayList<User> list;
	int size_d = 10;
	public UsersArrayList() {
		this.list = new ArrayList<User>(size_d);
	}

	public void addUser(User user) {
		if(user.getId() > size_d)
			size_d = size_d + (size_d / 2);
		list.add(user);
	}

	public void getUserById(int id) {
		for(User i: list)
		{
			if(id == i.getId())
			{
				System.out.println(i);
				return ;
			}
		}
		throw new UserNotFoundException("User not found by id");
	}

	public void getUserByIndex(int index) {
		for (int i = 0; i < list.size(); i++)
		{
			if(index == i)
			{
				System.out.println(this.list.get(index));
				return ;
			}
		}
		throw new UserNotFoundException("User not found by index");
	}

	public int countUsers() {
		return (list.size());
	}

	public int getSize() {
		return (this.size_d);
	}
}
