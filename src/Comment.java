public class Comment extends Node {
	private String comment;

	
	public Comment(String a)
	{
		comment = a;
	}
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String toString() 
	{ 
		return comment;
	}
}