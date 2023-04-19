import java.util.ArrayList;

public class Program {
	public static void main(String[] args) {

		
		User demo = new User("And");
		User demo1 = new User("And1");
		User demo2 = new User("And2");
		User demo3 = new User("And3");
		User demo4 = new User("And4");
		User demo5 = new User("And5");
		User demo6 = new User("And");
		User demo7 = new User("And1");
		User demo8 = new User("And2");
		User demo9 = new User("And3");
		User demo10 = new User("And4");
		User demo11 = new User("And5");
		User demo12 = new User("And2");
		User demo13 = new User("And3");
		User demo14 = new User("And4");
		User demo15 = new User("And5");


		UsersArrayList list = new UsersArrayList();
		list.addUser(demo);
		list.addUser(demo1);
		list.addUser(demo2);
		list.addUser(demo3);
		list.addUser(demo4);
		list.addUser(demo5);
		list.addUser(demo6);
		list.addUser(demo7);
		list.addUser(demo8);
		list.addUser(demo9);
		list.addUser(demo10);
		list.addUser(demo11);
		list.addUser(demo12);
		list.addUser(demo13);
		list.addUser(demo14);
		list.addUser(demo15);
		list.getUserById(6);
		list.getUserByIndex(1);
		System.out.println(list.getSize());
		list.getUserById(11);
		list.getUserByIndex(15);
	}
}
