
public class Directive extends Node {

    private String name;
    private Operand StringOperand;
    private String code;
    private int args;

    public Operand getStringOperand() {
		return StringOperand;
	}
	public void setStringOperand(Operand stringOperand) {
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
    
    public String getCode() 
    { 
    	return code;
    } 
    public void setCode(String code) 
    { 
    	this.code=code;
    }
    public int getArgs() 
    { 
    	return args;
    } 
    public void setArgs(int args) 
    { 
    	this.args=args;
    }
    
    public String toString() 
    { 
    	return name;
    }

}