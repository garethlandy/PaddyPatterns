package visitor;

public class ComputerPartsPrintVisitor implements VisitorBase {

	   @Override
	   public void visit(CPU cpu) {
	      System.out.println(cpu.getSpecification());
	   }

	   @Override
	   public void visit(MotherBoard mb) {
	      System.out.println(mb.getSpecification());

	   }

	   @Override
	   public void visit(RAM ram) {
	      System.out.println(ram.getSpecification());
	   }

	}
