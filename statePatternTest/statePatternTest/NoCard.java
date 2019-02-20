package statePatternTest;

public class NoCard implements ATMState {
	
ATMMachine atmMachine;
	
	public NoCard(ATMMachine newATMMachine) {
		
		atmMachine = newATMMachine;
	}

	@Override
	public void insertCard() {
		System.out.println("Please eneter a PIN");
		atmMachine.setATMState(atmMachine.getYesCardState());
		
	}

	@Override
	public void ejectCard() {
		System.out.println("Card Ejected");
		atmMachine.setATMState(atmMachine.getNoCardState());
		
	}

	@Override
	public void insertPin(int pinInserted) {
		System.out.println("Please eneter a Card first");
		
	}

	@Override
	public void requestCash(int cashToWithdraw) {
		System.out.println("Please eneter a Card first");
		
	}

}
