public class TestMnemonic {

    //the purpose of this program is to test the Mnemonic class
  public static void main(String[] args) {
      //create Mnemonic objects
      Mnemonic m1 = new Mnemonic(10,"Mnemonic 1 name");
      Mnemonic m2 = new Mnemonic(20,"Mnemonic 2 name");
      Mnemonic m3 = new Mnemonic(30,"Mnemonic 3 name");

      System.out.println("Testing Mnemonic class");
      System.out.println("opCode: 10 Mnemonic: Mnemonic 1 name opCode: 20 Mnemonic: Mnemonic 2 name opCode: 30 Mnemonic: Mnemonic 3 name");
      System.out.print(m1.toString()+" ");
      System.out.print(m2.toString()+" ");
      System.out.println(m3.toString());

  }  
}
