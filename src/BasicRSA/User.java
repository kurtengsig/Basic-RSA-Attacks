package BasicRSA;

import java.util.Random;

public class User {
	private long message;
	public User(long n){
		Random r = new Random();
		message = r.nextInt((int) n);
	}
	public long getMessage(){
		return message;
	}
}
