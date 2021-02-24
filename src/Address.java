public class Address extends Node {
	int address;

	public Address(int address) {
		
		this.address = address;
	}

	public Address() {
		// TODO Auto-generated constructor stub
	}


	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
	}
	
	public String toString() 
	{ 
		return Integer.toString(address);
	}
}