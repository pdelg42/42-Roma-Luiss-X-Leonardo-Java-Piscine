import java.util.ArrayList;

import javax.jws.soap.SOAPBinding.Use;

public class UsersArrayList {

	ArrayList<User> list;
	int size_d = 10;
	public UsersArrayList() {
		this.list = new ArrayList<User>(size_d);
	}

	public void addUser(User user) {
		if(user.getId() > size_d)
		{
			list.ensureCapacity(size_d + (size_d / 2));
			System.out.println("capocchia");
		}
		list.add(user);
	}
	public void getId(int id) {
		for(User i: list)
		{
			if(id == i.getId())
				System.out.println(i.getName());
		}
	}
	public void getIndex(int index) {
		for (int i = 0; i < list.size(); i++)
		{
			if(index == i)
			{
				System.out.println(list.get(index).getName());
				break;
			}
		}
	}
	public void getszie(int id) {
		for(User i: list)
		{
			if(id == i.getId())
				System.out.println(i.getName());
		}
	}
}
