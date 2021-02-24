
public class TestInstruction {

	public static void main(String[] args) {
		
		System.out.println("Test Instruction ");						 //Test Identification
		
		
		Label label = new Label("Loop");
		Address address = new Address(0001);
		Offset offset = new Offset(6);
		Operand operand = new Operand(label, address, offset);
		Mnemonic mnemonic = new Mnemonic(56, "add");
		
		
		System.out.println(new Instruction(mnemonic, operand)); 		// Execution
		
		System.out.println("Instruction [mnemonic=opCode: 56 Mnemonic: add, operand=Loop]");					   //Expected output 
		 

	}

}
