package mediator;

public class Aircraft {

	   private AirTrafficControl controller;

	   private int altitude;
	   private String flightNumber;

	   public Aircraft(String fno, AirTrafficControl a) {
	      flightNumber = fno;
	      controller = a;
	   }

	   public int getAltitude() {
	      return altitude;
	   }

	   public void setAltitude(int altitude) {
	      this.altitude = altitude;
	      this.controller.sendMessage(this);
	   }

	   public String getFlightNumber() {
	      return flightNumber;
	   }

	   public void setFlightNumber(String flightNumber) {
	      this.flightNumber = flightNumber;
	   }

	   public void soar(int height) {
	      this.altitude += height;
	   }

	   public void receiveMessage(Aircraft ra){
	      System.out.println(ra.flightNumber+" is at same altitude as yours!");
	   }

	}