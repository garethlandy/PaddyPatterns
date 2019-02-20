package memento;

public class Test {

	   public static void main(String[] args) {
	      Book b=new Book("Art of Programming Vol-I", "Donald Knuth");

	      BookCaretaker bc=new BookCaretaker();
	      bc.setMemento(b.createUndo());

	      System.out.println(b.toString());

	      b.setTitle("Art of Pogramming Vol II");
	      bc.setMemento(b.createUndo());

	      System.out.println(b.toString());

	      b.setAuthor("AAA");
	      System.out.println(b.toString());

	      b.undo(bc.getMemento());
	      System.out.println(b.toString());

	      b.undo(bc.getMemento());
	      System.out.println(b.toString());

	   }

	}