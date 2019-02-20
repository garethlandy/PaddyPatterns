package visitor;

import java.util.ArrayList;
import java.util.List;

public class Computer implements PartsBase {

	   private List<PartsBase> parts = new ArrayList<>();

	   public Computer(List<PartsBase> parts) {
	      super();
	      this.parts = parts;
	   }

	   @Override
	   public void accept(VisitorBase visitor) {
	      for (PartsBase p : parts) {
	         p.accept(visitor);
	      }
	   }

	}