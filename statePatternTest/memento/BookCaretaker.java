package memento;

import java.util.Stack;

public class BookCaretaker {
	   private Stack<BookMemento> mementos=new Stack<>();
	   public BookMemento getMemento(){
	      return mementos.pop();
	   }
	   public void setMemento(BookMemento bm){
	      mementos.push(bm);
	   }
	}
