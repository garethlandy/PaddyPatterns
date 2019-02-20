package commandPattern;

import java.util.HashMap;

public class Test {
	   public static void main(String[] args) {
	      HashMap<String, CommandBase> sc1 = new HashMap<>();
	      Soldier s1 = new Soldier();
	      sc1.put("forward", new MoveForwardCommand(s1));
	      sc1.put("back", new MoveBackwardCommand(s1));
	      sc1.put("jump", new JumpCommand(s1));
	      sc1.put("duck", new DuckCommand(s1));
	      sc1.put("shoot", new ShootCommand(s1));
	      Controller control1 = new Controller(sc1);
	      control1.executeAction("duck");
	      control1.executeAction("jump");
	      control1.executeAction("forward");
	      control1.executeAction("shoot");
	      control1.executeAction("back");
	      control1.executeAction("adsgh");
	   }
	}
