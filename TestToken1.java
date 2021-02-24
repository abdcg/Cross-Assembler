
public class TestToken1 
{
	public static void main(String[] args) 
	{ 
		Token1 t1 = new Token1(); 
		Token1 t2 = new Token1();
		Token1 t3 = new Token1(); 
		
		
		//making Mnemonics
		Mnemonic mnem1 = new Mnemonic(0, "halt"); 
		Mnemonic mnem2 = new Mnemonic(1, "pop"); 
		Mnemonic mnem3 = new Mnemonic(2, "dup"); 
		
		//making Addresses 
		Address add1 = new Address(0); 
		Address add2 = new Address(1); 
		Address add3 = new Address(2); 
		
		//making Position
		Position pos1 = new Position(1); 
		Position pos2 = new Position(2); 
		Position pos3 = new Position(3); 
		
		//making Offset 
		Offset off1 = new Offset(0); 
		Offset off2 = new Offset(0); 
		Offset off3 = new Offset(0); 
		
		//making Label 
		Label lab1 = new Label(); 
		Label lab2 =  new Label(); 
		Label lab3 =  new Label(); 
		
		//making Comment 
		Comment com1 =  new Comment("This is a comment"); 
		Comment com2 =  new Comment(); 
		Comment com3 =  new Comment("This is the second comment"); 
		
		
		//setting values of t1, t2, t3 
		t1.setMnem(mnem1); 
		t1.setAddress(add1); 
		t1.setPosition(pos1); 
		t1.setOffset(off1); 
		t1.setLabel(lab1); 
		t1.setComment(com1); 
		
		t2.setMnem(mnem2); 
		t2.setAddress(add2); 
		t2.setPosition(pos2); 
		t2.setOffset(off2); 
		t2.setLabel(lab2); 
		t2.setComment(com2); 
		
		t3.setMnem(mnem3); 
		t3.setAddress(add3); 
		t3.setPosition(pos3); 
		t3.setOffset(off3); 
		t3.setLabel(lab3); 
		t3.setComment(com3);
		
		
		//expected output
        System.out.println("Test Token1"); 
        System.out.println("t1: [Mnemonic: opCode: 0 Mnemonic: halt] [Operand: null] [Address: 0] [position: [1,0]] [Offset: 0] [Label: null] [Comment: This is a comment]t2: [Mnemonic: opCode: 1 Mnemonic: pop] [Operand: null] [Address: 1] [position: [2,0]] [Offset: 0] [Label: null] [Comment: null]t3: [Mnemonic: opCode: 2 Mnemonic: dup] [Operand: null] [Address: 2] [position: [3,0]] [Offset: 0] [Label: null] [Comment: This is the second comment]");
        
        
      //actual output
        System.out.print("t1: "+t1.toString());
        System.out.print("t2: "+t2.toString());
        System.out.println("t3: "+t3.toString());

	}
}
