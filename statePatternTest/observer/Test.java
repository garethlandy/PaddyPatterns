package observer;

public class Test {
	 
	   public static void main(String[] args) {
	      Account a=new Account("1122",5000.00f);
	      new SMSObserver(a);
	      new EmailObserver(a);
	      a.deposit(200.0f);
	      a.withdraw(300.0f);

	   }

	}