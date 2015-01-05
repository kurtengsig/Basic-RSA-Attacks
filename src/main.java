import BasicRSA.Attacker;
import BasicRSA.BasicRSA;
import BasicRSA.Simulation1;
import BasicRSA.Simulation2;
import BasicRSA.Simulation3;
import BasicRSA.Simulation4;


public class main {

	public static void main(String[] args) {
		Simulation1 sim1 = new Simulation1();
		sim1.execute();
		Simulation2 sim2 = new Simulation2();
		sim2.execute();
		Simulation3 sim3 = new Simulation3();
		sim3.execute();
		Simulation4 sim4 = new Simulation4();
		sim4.execute();
	}

}
