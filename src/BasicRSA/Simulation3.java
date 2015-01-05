package BasicRSA;

import java.util.concurrent.TimeUnit;

public class Simulation3 {
	public void execute(){
		BasicRSA brsa = new BasicRSA();
		while(brsa.e < 0){ brsa = new BasicRSA();}
		User user = new User(brsa.getN());
		Attacker a = new Attacker();
		long ciphertext = brsa.encrypt(user.getMessage());
		System.out.println("\n\nSimulation 3: DECRYPTING A MESSAGE BY HAVING IT SIGNED");
		System.out.println("---------------------------------------------------------\n");
		System.out.println("User: has message:          "+user.getMessage());
		System.out.println("User: has public key:       "+brsa.getPublicKey());
		System.out.println("User: has private key:      "+brsa.getPrivateKey());
		System.out.println("Attacker intercepts ciphertext: "+ciphertext);
		System.out.println("Attacker: asks the user to sign it");
		System.out.println("Attacker: decrypts cipher text to get: "+brsa.decrypt(ciphertext));
	}
}
