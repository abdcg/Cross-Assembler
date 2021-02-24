
public class Directive extends Node {

    private String name;
    private StringOperand StringOperand;


    public StringOperand getStringOperand() {
		return StringOperand;
	}
	public void setStringOperand(StringOperand stringOperand) {
		StringOperand = stringOperand;
	}
	public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Directive() {

    }
    public Directive(String name) {
        this.name=name;
    }
    
    public String toString() 
    { 
    	return "Directive: "+ name;
    }

}