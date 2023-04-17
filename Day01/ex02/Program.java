import java.util.ArrayList;
public class Program {
	public static void main(String[] args) {

		
		User demo = new User("And");
		User demo1 = new User("And1");
		User demo2 = new User("And2");
		User demo3 = new User("And3");
		User demo4 = new User("And4");
		User demo5 = new User("And5");


		UsersArrayList list = new UsersArrayList();
		list.addUser(demo);
		list.addUser(demo1);
		list.addUser(demo2);
		list.addUser(demo3);
		list.addUser(demo4);
		list.addUser(demo5);
		list.getId(6);
		list.getIndex(1);
		System.out.println(list.getsize(list));
	}
}
