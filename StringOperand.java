
public class StringOperand extends Operand 
{
	private String Operand;

	public String getOperand() {
		return Operand;
	}

	public void setOperand(String operand) {
		Operand = operand;
	}
	
	public StringOperand()
	{
		
	}
	
	public StringOperand(String a)
	{
		Operand = a;
	}

	public String toString() {
		return "StringOperand [Operand=" + Operand + "]";
	}
	
	

}
