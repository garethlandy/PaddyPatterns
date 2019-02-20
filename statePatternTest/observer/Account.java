package observer;

import java.util.ArrayList;
import java.util.List;

public class Account {
	   private String accountNo;
	   private List<Observer> observers = new ArrayList<>();
	   private float balance;

	   public Account(String accno, float amount) {
	      this.accountNo=accno;
	      balance = amount;
	   }

	   public String getAccountNo() {
	      return accountNo;
	   }

	   public float getBalance() {
	      return balance;
	   }

	   public float withdraw(float amount) {
	      float val=0.0f;
	      if (balance < amount)
	         val=0;
	      else {
	         balance = balance - amount;
	         val=balance;
	      }
	      notifyAllObservers();
	      return val;
	   }

	   public void deposit(float amount) {
	      balance += amount;
	      notifyAllObservers();
	   }

	   public void add(Observer o) {
	      observers.add(o);
	   }

	   public void notifyAllObservers() {
	      for (Observer o : observers) {
	         o.update();
	      }
	   }

	}