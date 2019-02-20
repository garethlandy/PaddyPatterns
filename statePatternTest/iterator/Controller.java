package iterator;

public class Controller {
	   private int currentSpeed;
	   private Accelerator accelerator;
	   public Controller(Accelerator accelerator){
	      this.accelerator=accelerator;
	      this.currentSpeed=0;
	   }

	   public int paddleDown(){
	      currentSpeed=accelerator.accelerate(currentSpeed);
	      return currentSpeed;
	   }

	   public int paddleUp(){
	      currentSpeed=accelerator.deaccelerate(currentSpeed);
	      return currentSpeed;
	   }

	}