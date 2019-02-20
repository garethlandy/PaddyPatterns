package statePatternTest;

public class NoCash implements ATMState{
	
	ATMMachine atmMachine;
	
	public NoCash(ATMMachine newATMMachine) {
		
		atmMachine = newATMMachine;
	}

	@Override
	public void insertCard() {
		System.out.println("We dont have any money");
		
	}

	@Override
	public void ejectCard() {
		System.out.println("We dont have any money.. enter your card");
		
	}

	@Override
	public void insertPin(int pinInserted) {
		System.out.println("We dont have any money");
		
	}

	@Override
	public void requestCash(int cashToWithdraw) {
		System.out.println("We dont have any money");
		
	}

}
