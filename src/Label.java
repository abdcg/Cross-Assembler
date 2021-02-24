public class Label extends Node{
	private String name;
	private int address;
	private boolean pair = false;

	public Label() {} 
	
	public Label(String name) 
	{ 
		this.name =name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPair() {
		return pair;
	}

	public void setPair(boolean pair) {
		this.pair = pair;
	} 
	
	public void setAddress(int address) 
	{ 
		this.address=address;
	} 
	public int getAddress() 
	{ 
		return address;
	}
	public String toString() 
	{ 
		return name;
	}
	
}