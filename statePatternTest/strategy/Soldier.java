package strategy;

public class Soldier {
	   private SoldierBehavior behavior;
	   private String type;

	   public Soldier(SoldierBehavior behavior, String type) {
	      super();
	      this.behavior = behavior;
	      this.type = type;
	   }

	   public void stance() {
	      System.out.println(type);
	      behavior.stance();
	   }
	}
