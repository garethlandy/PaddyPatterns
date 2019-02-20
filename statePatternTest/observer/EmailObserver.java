package observer;

public class EmailObserver extends Observer{

	   public EmailObserver(Account account) {
	      this.account = account;
	      this.account.add(this);
	   }

	   @Override
	   public void update() {
	      System.out.println("EMAIL: AccountNo:#"
	         + this.account.getAccountNo() + " Balance: $"
	         + this.account.getBalance());
	   }
	}