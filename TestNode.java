
public class TestNode {

	public static void main(String[] args) 
	{
		Node n1 = new Position(1);
        
        Mnemonic m2 = new Mnemonic();
        m2.setName("add");
        m2.setOpCode(2);
        Node n2 = m2;
        
        

        //expected output
        System.out.println("Test Position");
        System.out.println("n1: [1,0] n2: opCode: 2 Mnemonic: add");


        //actual output
        System.out.print("n1: "+n1.toString());
        System.out.print(" n2: "+m2.toString());
        System.out.println();


	}

}
