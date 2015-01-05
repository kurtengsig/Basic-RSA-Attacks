package BasicRSA;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Simulation2 {
	public void execute(){
		BasicRSA brsa = new BasicRSA();
		while(brsa.e < 0){ brsa = new BasicRSA();}
		User user = new User(brsa.getN());
		Attacker a = new Attacker();
		long ciphertext = brsa.encrypt(user.getMessage());
		long n = brsa.getN();
		long p = user.getMessage();
		System.out.println("\n\nSimulation 2: FACTORING N");
		System.out.println("----------------------------\n");
		System.out.println("User: has message:          "+user.getMessage());
		System.out.println("User: has public key:       "+brsa.getPublicKey());
		System.out.println("User: has private key:      "+brsa.getPrivateKey());
		System.out.println("User: generates ciphertext: "+brsa.encrypt(user.getMessage()));
		System.out.println("Attacker: gets public key:  "+brsa.getPublicKey());
		System.out.println("Attacker: gets ciphertext:  "+ciphertext);
		System.out.println("For the sake of simplicity and time,");
		System.out.println("I will assume the attacker knows the plaintext");
		long startTime = System.currentTimeMillis();
		System.out.println("Attacker: working...");
		System.out.println("Attacker: "+a.factorAttack(n, ciphertext, p));
		long endTime = System.currentTimeMillis();
		System.out.println("Attack took: "+(TimeUnit.MILLISECONDS.toSeconds(endTime-startTime))+" seconds and "
				+((endTime-startTime) - TimeUnit.SECONDS.toMillis((TimeUnit.MILLISECONDS.toSeconds(endTime-startTime))))+"milliseconds");
	}
}
