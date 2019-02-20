package mediator;

public class  Test {

	   public static void main(String[] args) {
	      AirTrafficControl controller = new AirTrafficControlImpl();
	      Aircraft a1 = new Aircraft("1234", controller);
	      Aircraft a2 = new Aircraft("2345", controller);
	      Aircraft a3 = new Aircraft("3456", controller);
	      Aircraft a4 = new Aircraft("4567", controller);
	       a1.setAltitude(100);
	       a1.setFlightNumber("EI123");
	       a1.soar(100);
	       a2.setAltitude(100);
	       a2.setFlightNumber("EI124");
	       a2.soar(100);
	       a3.setAltitude(100);
	       a3.setFlightNumber("EI125");
	       a3.soar(200);
	       a4.setAltitude(100);
	       a4.setFlightNumber("EI126");
	       a4.soar(400);
	   }

	}