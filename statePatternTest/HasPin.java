package statePatternTest;

public class HasPin implements ATMState{
	
	ATMMachine atmMachine;
	
	public HasPin(ATMMachine newATMMachine) {
		
		atmMachine = newATMMachine;
	}

	@Override
	public void insertCard() {
		System.out.println("You cant enter more than one card");
		
	}

	@Override
	public void ejectCard() {
		System.out.println("Card Ejected");
		atmMachine.setATMState(atmMachine.getNoCardState());
		
	}

	@Override
	public void insertPin(int pinInserted) {
		System.out.println("Pin Already entered");
		
	}

	@Override
	public void requestCash(int cashToWithdraw) {
		
		if(cashToWithdraw > atmMachine.cashInMachine) 
		{
			
			System.out.println("Dont have amount!!");
			System.out.println("Card Ejected");
			atmMachine.setATMState(atmMachine.getNoCardState());
			
			
		}else
		{
			System.out.println(cashToWithdraw + " is provided by the machine");
			atmMachine.setCashInMachine(atmMachine.cashInMachine - cashToWithdraw);
			System.out.println("Card Ejected");
			atmMachine.setATMState(atmMachine.getNoCardState());
			
			
			if(atmMachine.cashInMachine <= 0) {
				atmMachine.setATMState(atmMachine.getNoCashState());
				
			}
		}
		
	}

}
