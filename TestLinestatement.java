
public class TestLinestatement {

	public static void main(String[] args) {
		
		
		
		System.out.println("Test LineStatement");   // Test Identification
		 
			//Create Mnemonic
	        Mnemonic m1 = new Mnemonic();
	        m1.setName("div");
	        m1.setOpCode(0);
	        
	        //Create Operand
	        Label l1 = new Label("Op Label");
	        Address a1 = new Address(0001);
	        Offset o1 = new Offset(6);
	        Operand op1 = new Operand(l1, a1, o1);
	        
	        //Create Instruction
	        Instruction i1 = new Instruction(m1, op1);
	        
	        //Create Label
	        Label l2 = new Label("Loop");
	        
	        //Create Comment
	        Comment c1 = new Comment (" This is a comment");
	        
	        //Create Linestatement
	    	LineStatement linestmnt = new LineStatement(l2, i1, c1);
	        
	        System.out.println(linestmnt);		// Execution
	        
	        System.out.println("LineStatement [label=Loop, instruction=Instruction [mnemonic=opCode: 0 Mnemonic: div, operand=Op Label], comment= This is a comment]"); //Expected output
	        

	}

}
