package commandPattern;

import java.util.HashMap;

public class Controller {
	   private HashMap<String, CommandBase> commands = new HashMap<>();

	   public Controller(HashMap<String, CommandBase> commands) {
	      super();
	      this.commands = commands;
	   }

	   public void executeAction(String commandString) {
	      if (!commands.containsKey(commandString))
	         System.out.println("Invalid Action!!!");
	      else
	         commands.get(commandString).action();
	   }
}


