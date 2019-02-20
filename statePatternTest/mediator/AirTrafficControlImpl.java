package mediator;

import java.util.ArrayList;
import java.util.List;

public class AirTrafficControlImpl implements AirTrafficControl {
	   private List<Aircraft> aircrafts = new ArrayList<>();

	   @Override
	   public void registerFlight(Aircraft aircraft) {
	      if (!aircrafts.contains(aircraft))
	         aircrafts.add(aircraft);

	   }

	   @Override
	   public void sendMessage(Aircraft aircraft) {
	      for (Aircraft a : aircrafts) {
	         if (a != aircraft
	            && (a.getAltitude() - aircraft.getAltitude()) < 1000)
	            a.receiveMessage(aircraft);
	         a.soar(1000);
	      }

	   }

	}
