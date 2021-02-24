public class Offset extends Node  
{
	int numOffset;
	boolean set = false;
	public Offset() 
	{ 
		
	} 
	public Offset(int numOffset)
	{
		set = true;
		this.numOffset =numOffset;
	}
	
	public int getNumOffset() {
		return numOffset;
	}

	public void setNumOffset(int numOffset) {
		this.numOffset = numOffset;
	} 
	public boolean getSet() 
	{ 
		return set;
	}
	
	public String toString() 
	{ 
		return Integer.toString(numOffset);
	}

}