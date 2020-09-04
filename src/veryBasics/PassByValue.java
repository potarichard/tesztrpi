package veryBasics;

public class PassByValue {

	// in Java everything is passed by value, in param str it gains a copy of the passed object
	// and string is immutable, so you cant change it
	
	// however a general POJO, is not immutable, vhen you pass it, it copy the value,
	// but in this case the value is the objects address, so when any field changed, the object content is changed
	void tryChangeString(String str) {
		str += " changed";
	}
	
	// it is avaiable by instance's field, works as a field, every Immutables's instance have this field!
	class User
	{
		public int id;
		public int hash;
		
		@Override
		public String toString() {
			return "User [id=" + id + ", hash=" + hash + "]";
		}		
	}
	
	// it's the class field, not the instance's
	static class StaticUser
	{
		public int id;
		public int hash;
		
		@Override
		public String toString() {
			return "StaticUser [id=" + id + ", hash=" + hash + "]";
		}		
	}
	
	void tryChangeUser(User usr) {
		usr.id += 10;
		usr.hash += 10;
	}
	
	void tryChangeStaticUser(StaticUser stusr) {
		stusr.id += 10;
		stusr.hash += 10;
	}
	
	public static void main(String[] args) {
		
//		1
		PassByValue imtb = new PassByValue();
		
		String mystr = new String("halo");		
		imtb.tryChangeString(mystr);
		
		String mystr2 = "easy";		
		imtb.tryChangeString(mystr);

		System.out.println(mystr + " " + mystr2);
		
//		2
		User user = new PassByValue().new User();
		
		StaticUser stuser = new StaticUser();
		
		imtb.tryChangeUser(user);
		
		imtb.tryChangeStaticUser(stuser);
		
		System.out.println("user: " + user);
		
		System.out.println("staticuser: " + stuser);
	}

}












