package observer;

public class SMSObserver extends Observer {

	   public SMSObserver(Account account) {
	         this.account = account;
	         this.account.add(this);
	      }

	      @Override
	      public void update() {
	         System.out.println("SMS: AccountNo:#"
	            + this.account.getAccountNo() + " Balance: $"
	            + this.account.getBalance());
	   }

	}