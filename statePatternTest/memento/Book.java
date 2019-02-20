package memento;

public class Book {
	   private String title;
	   private String author;

	   public Book(String title, String author) {
	      super();
	      this.title =  title;
	      this.author = author;
	   }
	   public String getTitle() {
	      return title;
	   }
	   public void setTitle(String title) {
	      this.title = title;
	   }
	   public String getAuthor() {
	      return author;
	   }
	   public void setAuthor(String author) {
	      this.author = author;
	   }

	   public BookMemento createUndo(){
	      return new BookMemento(title, author);
	   }

	   public void undo(BookMemento bm){
	      title=bm.getTitle();
	      author=bm.getAuthor();
	   }
	   @Override
	   public String toString() {
	      return "Book [title=" + title + ", author=" + author + "]";
	   }
	}
