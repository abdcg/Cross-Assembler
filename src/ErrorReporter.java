import java.util.ArrayList;

public class ErrorReporter {
    // errorArray saves all the errors that the lexer finds
    private ArrayList<ErrorMessage> errorArray;

    // constructor
    public ErrorReporter() {
        this.errorArray = new ArrayList<ErrorMessage>();
    }

    // void method that adds an error to the errorArray list
    public void addError(ErrorMessage em) {
        this.errorArray.add(em);
    }
    
    public boolean isEmpty(ErrorReporter error) 
    { 
    	if(errorArray.isEmpty()) 
    	{ 
    		return true;
    	} 
    	return false;
    }
    
    // void methods that prints all errors in the list
    public void printAllErrors() {
        for (int i = 0; i < errorArray.size(); i++) {
            System.out.print(errorArray.get(i).getErrorMessage()+" ");
        }
    }

}