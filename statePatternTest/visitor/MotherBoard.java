package visitor;

public class MotherBoard implements PartsBase {
	   private String specification;

	   public String getSpecification() {
	      return specification;
	   }

	   public void setSpecification(String specification) {
	      this.specification = specification;
	   }

	   public MotherBoard(String specification) {
	      super();
	      this.specification = specification;
	   }

	   @Override
	   public void accept(VisitorBase visitor) {
	       visitor.visit(this);
	   }

	}
