package commandPattern;

public class MoveForwardCommand extends CommandBase {

	   public MoveForwardCommand(Soldier soldier) {
	      super(soldier);
	   }

	   @Override
	   public void action() {
	      soldier.moveForward();
	   }

	}
