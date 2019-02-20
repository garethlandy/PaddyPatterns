package statePatternTest;

public interface ATMState {
	
	void insertCard();
	void ejectCard();
	void insertPin(int pinInserted);
	void requestCash(int castToWithdraw);

}
