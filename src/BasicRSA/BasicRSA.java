package BasicRSA;

import java.math.BigInteger;
import java.util.Random;

public class BasicRSA {
	long p;
	long q;
	long n;
	long t;
	long e;
	long d;
	public BasicRSA(){
		p = getPrime();
		q = getPrime();
		n = q*p;
		t = lcm(p-1, q-1);
		calculateED((float)t);
	}
	public BasicRSA(long p, long q){
		this.p = p;
		this.q = q;
		n = q*p;
		t = lcm(p-1, q-1);
		calculateED((float)t);
	}
	public int getPrime(){
		while(true){
			Random r = new Random();
			int p = r.nextInt(10000);
			if(isPrime(p))
				return p;
		}
	}
	public boolean isPrime(long p){
		return ((Math.pow(2, p-1) % p) == 1);
	}
	long gcd(long f, long g){
		if(g == 0) return f;
		return gcd(g, f%g);
	}
	long lcm(long f, long g){
		return ((f*g)/(gcd(f, g)));
	}
	boolean calculateED(float t){
		float eValues[] = {3, 5, 7, 11, 13, 17, 19, 23};
		for(int i=0; i<eValues.length; ++i){
			if(Math.ceil((t+1)/eValues[i]) == (t+1)/eValues[i]){
				e = (long) eValues[i];
				d = (long) ((t+1)/eValues[i]);
				return true;
			}
		}
		e = -1;
		d = -1;
		return false;
	}
	public String getPublicKey(){
		return "("+n+", "+e+")";
	}
	public String getPrivateKey(){
		return "("+p+", "+q+", "+t+", "+d+")";
	}
	public long encrypt(long m){
		BigInteger b = BigInteger.valueOf(m);
		BigInteger newN = BigInteger.valueOf(n);
		b = (b.pow((int) e));
		b = b.mod(newN);
		return (long) b.longValue();
	}
	public long decrypt(long c){
		BigInteger b = BigInteger.valueOf(c);
		BigInteger newN = BigInteger.valueOf(n);
		b = (b.pow((int) d));
		b = b.mod(newN);
		return (long) b.longValue();
	}
	public long getN(){
		return n;
	}
	public long getE(){
		return e;
	}
}
