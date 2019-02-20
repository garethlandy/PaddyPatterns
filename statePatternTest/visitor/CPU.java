package visitor;

public class CPU implements PartsBase {
	   private String specification;

	   public String getSpecification() {
	      return specification;
	   }

	   public void setSpecification(String specification) {
	      this.specification = specification;
	   }

	   public CPU(String specification) {
	      super();
	      this.specification = specification;
	   }

	   @Override
	   public void accept(VisitorBase visitor) {
	      visitor.visit(this);
	   }

	}
