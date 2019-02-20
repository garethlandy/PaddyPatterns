package strategy;

public class AggresiveMode implements SoldierBehavior {

	   @Override
	   public void stance() {
	      System.out.println("Attack enemy at sight.");
	   }
	}