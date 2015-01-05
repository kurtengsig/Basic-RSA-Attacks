package BasicRSA;

import java.util.concurrent.TimeUnit;

public class Simulation4 {
	public void execute(){
		BasicRSA brsa = new BasicRSA(827, 317);
		while(brsa.e < 0){ brsa = new BasicRSA();}
		Attacker a = new Attacker();
		long n = brsa.getN();
		long message = a.generateMessage((long) Math.pow(n, (1.0/brsa.e)));
		long ciphertext = brsa.encrypt(message);
		System.out.println("\n\nSimulation 4: TAKING THE E-th ROOT OF A MESSAGE OVER LOW ENCRYPTION");
		System.out.println("-------------------------------------------------------------\n");
		System.out.println("User: has public key:       "+brsa.getPublicKey());
		System.out.println("User: has private key:      "+brsa.getPrivateKey());
		System.out.println("User: generates message < n^(1/e): "+message);
		System.out.println("User: generates ciphertext: "+ciphertext);
		System.out.println("Attacker: knows public key: "+brsa.getPublicKey());
		System.out.println("Since this is a special case,\nIt is possible to recover the message by calling the e-th root of the message");
		System.out.println("Attacker: Computes c^(1/e) where e is part of the public key:");
		long startTime = System.currentTimeMillis();
		System.out.println("Attacker: working...");
		System.out.println("Attacker: found the message to be: "+a.computeEthRoot(ciphertext, brsa.e));
		long endTime = System.currentTimeMillis();
		System.out.println("Attack took: "+(TimeUnit.MILLISECONDS.toSeconds(endTime-startTime))+" seconds and "
				+((endTime-startTime) - TimeUnit.SECONDS.toMillis((TimeUnit.MILLISECONDS.toSeconds(endTime-startTime))))+"milliseconds");
	}
}
