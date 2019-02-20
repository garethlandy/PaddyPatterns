package mediator;

public interface AirTrafficControl {
	   void registerFlight(Aircraft aircraft);
	   void sendMessage(Aircraft aircraft);
	}