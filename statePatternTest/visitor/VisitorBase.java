package visitor;

public interface VisitorBase {
	   void visit(CPU cpu);
	   void visit(MotherBoard mb);
	   void visit(RAM ram);
	}
