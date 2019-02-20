package iterator;

public class Accelerator implements Iterator {

	   @Override
	   public int accelerate(int currentSpeed) {
	      if (currentSpeed < 60)
	         currentSpeed++;
	      return currentSpeed;
	   }

	   @Override
	   public int deaccelerate(int currentSpeed) {
	      if (currentSpeed > 0)
	         currentSpeed--;
	      return currentSpeed;
	   }

	}
