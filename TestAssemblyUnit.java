
public class TestAssemblyUnit 
{
	//a group of Position objects are created
    public static void main(String[] args) 
    {
    	
    	AssemblyUnit test = new AssemblyUnit();
    	
    	//Create Mnemonic
        Mnemonic m1 = new Mnemonic();
        m1.setName("div");
        m1.setOpCode(0);
        
        Mnemonic m2 = new Mnemonic();
        m2.setName("add");
        m2.setOpCode(2);
        
        Mnemonic m3 = new Mnemonic();
        m1.setName("enter");
        m1.setOpCode(3);
        
        //Create Operand
        Label l1 = new Label("Op Label");
        Address a1 = new Address(0001);
        Offset o1 = new Offset(6);
        Operand op1 = new Operand(l1, a1, o1);
        
        Label l2 = new Label("Op Label2");
        Address a2 = new Address(0002);
        Offset o2 = new Offset(7);
        Operand op2 = new Operand(l2, a2, o2);
        
        Label l3 = new Label("Op Label3");
        Address a3 = new Address(0003);
        Offset o3 = new Offset(8);
        Operand op3 = new Operand(l3, a3, o3);
        
        //Create Instruction
        Instruction i1 = new Instruction(m1, op1);
        Instruction i2 = new Instruction(m2, op2);
        Instruction i3 = new Instruction(m3, op3);
        
        //Create Label
        Label l4 = new Label("Loop");
        Label l5 = new Label("Loop2");
        Label l6 = new Label("Loop3");
        
        //Create Comment
        Comment c1 = new Comment (" This is a comment");
        Comment c2 = new Comment (" This is a comment2");
        Comment c3 = new Comment (" This is a comment3");
        
        //Create Linestatement
    	LineStatement linestmnt = new LineStatement(l4, i1, c1);
    	LineStatement linestmnt2 = new LineStatement(l5, i2, c2);
    	LineStatement linestmnt3= new LineStatement(l6, i3, c3);
    	
    	AssemblyUnit reverse = new AssemblyUnit();
    	
    	//Push and Pop LineStatements in AssemblyUnit Test
    	test.push(linestmnt);
    	test.push(linestmnt2);
    	test.push(linestmnt3);
    	
    	
    	test.pop();
    	test.pop();
        
    	test.push(linestmnt3);
    	test.push(linestmnt2);
    	
    	System.out.println("Test Assembly Unit");
        System.out.println(test);		// Execution
           
        System.out.println("AssemblyUnit = { LineStatement [label=Loop2, instruction=Instruction [mnemonic=opCode: 2 Mnemonic: add, operand=Op Label2], comment= This is a comment2], LineStatement [label=Loop3, instruction=Instruction [mnemonic=opCode: 0 Mnemonic: null, operand=Op Label3], comment= This is a comment3], LineStatement [label=Loop, instruction=Instruction [mnemonic=opCode: 3 Mnemonic: enter, operand=Op Label], comment= This is a comment] }"); //Expected output


    }

}
