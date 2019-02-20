package strategy;

public class Test {

	   public static void main(String[] args) {
	      Soldier s1 = new Soldier(new DefensiveMode(), "Pikeman");
	      Soldier s2 = new Soldier(new AggresiveMode(), "Militia");
	      Soldier s3 = new Soldier(new ShittingHimselfMode(), "Knight");
	      s1.stance();
	      s2.stance();
	      s3.stance();
	   }
	}