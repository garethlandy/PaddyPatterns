package strategy;

public class DefensiveMode implements SoldierBehavior {

	   @Override
	   public void stance() {
	      System.out.println("Attack only when attacked.");

	   }
	}