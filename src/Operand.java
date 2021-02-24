public class Operand {
	private Label label;
	private Address address;
	private Offset offset;
	private String operand;
	
	public Operand () {
		
	}
	public Operand(String operand) 
	{ 
		this.operand=operand;
	}
	public Operand(Label label, Address address, Offset offset) {
		this.label = label;
		this.address = address;
		this.offset = offset;
	}
	public Label getLabel() {
		return label;
	}
	public void setLabel(Label label) {
		this.label = label;
	}
	public Address getAdddress() {
		return address;
	}
	public void setAdddress(Address address) {
		this.address = address;
	}
	public Offset getOffset() {
		return offset;
	}
	public void setOffset(Offset offset) {
		this.offset = offset;
	}
	
	
	public void setOperand(String operand) 
	{ 
		this.operand=operand;
	} 
	public String getOperand() 
	{ 
		return operand;
	}
	
	public String toString()
	{
		if(label != null)
			return label.toString();
		if(address != null)
			return address.toString();
		if(operand != null) 
			return operand;
		return offset.toString();
		
		
	}
	
}