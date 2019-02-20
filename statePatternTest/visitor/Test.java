package visitor;

import java.util.ArrayList;
import java.util.List;

public class Test {

	   public static void main(String[] args) {
	      List<PartsBase> spec=new ArrayList<>();
	      spec.add(new CPU("Core 2 Duo"));
	      spec.add(new MotherBoard("Intel GVSR"));
	      spec.add(new RAM("4 GB"));

	      VisitorBase vb=new ComputerPartsPrintVisitor();
	      Computer c=new Computer(spec);
	      c.accept(vb);
	   }

	}
