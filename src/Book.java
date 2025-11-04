public class Book {

	// GRASP Principle: Information Expert
	// Manages its own state (available or borrowed).
	private String title;
	private boolean isAvailable;
	private String author;

	
	// TODO: implement Book functionality
	public Book(String title, String author) {
		this.title = title;
		this.isAvailable = true;
		this.author = author;

	}
	public String getTitle()
	{
		return title;
	}

	public boolean isAvailable(){

		return isAvailable;
	}


	public String getAuthor(){

		return author;
	}

	public void borrowed(){
		isAvailable = false;
	}

	public void returned(){

		isAvailable = true;
	}

	@Override
	public String toString(){
		String status = isAvailable ? "Available" : "Borrowed";
		return title + " by " + author + " - " + status;
	}
}
