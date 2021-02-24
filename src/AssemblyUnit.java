import java.util.ArrayList;

public class AssemblyUnit extends Node
{
	private ArrayList<Node> AssemblyUnit = new ArrayList<Node>();
	
    // Method to insert a new node 
    public void push(Node data) 
    { 
        AssemblyUnit.add(data);
    }
    
    //Method to remove item from head of AssemblyUnit
    public Node pop()
    {
		Node temp = AssemblyUnit.get(AssemblyUnit.size()-1);
		
		AssemblyUnit.remove(AssemblyUnit.size()-1);
		
		return temp;
    }
  
    //Get size
    public int getSize()
    {
    	return AssemblyUnit.size();
    }
    
    // Method to print the LinkedList. 
    public String toString() 
    {  
    	String b = "AssemblyUnit = { ";
    	// Traverse through the LinkedList 
        for(int i = AssemblyUnit.size()-1; i >= 0; i--) 
        { 
            // Print the data at current node
        	b = b + AssemblyUnit.get(i) + ", ";
        }
        
        b = b.substring(0, b.length()-2);
        
        return (b+" }");
    }
    
    public ArrayList getArrayList() 
    {  
        return AssemblyUnit;
    }
}