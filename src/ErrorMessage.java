public class ErrorMessage {
    //object of type Position holds the position of the error
    private Position position;

    //String holding the error message related to the error
    private String errorMessage;

    //constructor
    public ErrorMessage(int line, String errorMessage) {
        //this.position = new Position(line ,column); 
    	this.position = Position.createLinePosition(line);
        this.errorMessage = errorMessage;
    }

    //public method returns the error message ad the location of the error
    public String getErrorMessage(){
        return this.errorMessage+ " at "+this.position.toString();
    }

    //returns position of error
    public Position getPosition(){
        return this.position;
    }
    
}