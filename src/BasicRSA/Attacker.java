package BasicRSA;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class Attacker {
	/* USED FOR SIM1 ******************************/
	public String dAattack(long n, long c, long p){
		int d = 1;
		while((decrypt(n, d, c) != p) && (d < n)){
			d +=1;
		}
		return "Decryption worked for value d = "+d;
	}
	long decrypt(long n, long d, long c){
		BigInteger b = BigInteger.valueOf(c);
		BigInteger newN = BigInteger.valueOf(n);
		b = (b.pow((int) d));
		b = b.mod(newN);
		return (long) b.longValue();
	}
	/* ***********************************************/
	
	/* USED FOR SIM 2 ********************************/
	public String factorAttack(long n, long c, long p){
		ArrayList<Long> factors = findFactors(n);
		System.out.println("Attacker: found the following primes: "+factors);
		for(int i=0; i<factors.size(); ++i)
			for(int j=i+1; j<factors.size(); j++){
				if(decryptUsingPrimes(factors.get(i), factors.get(j), c) == p){
					return "Using primes P = "+factors.get(i)+" and Q = "+factors.get(j)+" Plaintext = "+p;
				}
			}
		return "Decryption failed";
	}
	public ArrayList<Long> findFactors(long n){
		ArrayList<Long> factors = new ArrayList<Long>();
		long factorNumber = 2;
		while(factorNumber < (n/2)+1){
			if((n % factorNumber) == 0){
				factors.add(factorNumber);
			}
			factorNumber +=1;
		}
		return factors;
	}
	long decryptUsingPrimes(long p, long q,long c){
		BasicRSA b = new BasicRSA(p, q);
		return b.decrypt(c);
	}
	/* ***********************************************/
	/* USED FOR SIM 3 ********************************/
	public long generateMessage(long n){
		Random r = new Random();
		return (long)r.nextInt((int) n);
	}
	/* **********************************************/
	/* USED FOR SIM 4 *******************************/
	public long computeEthRoot(long c, long e){
		return (long) Math.pow(c, 1.0/e) +1;
	}
}
