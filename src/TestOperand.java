public class TestOperand {
    //the purpose of this program is to test the Operand class
    public static void main(String[] args) {
        //creating Operand object
        Operand o1 = new Operand(new Label("label 1"), new Address(5), new Offset(0));
        Operand o2 = new Operand(null, null, new Offset(1));
        Operand o3 = new Operand(null, new Address(7), null);
        System.out.println("Test Operand class");
        System.out.println("label 1 1 7");
        System.out.print(o1.toString() +" ");
        System.out.print(o2.toString() +" ");
        System.out.println(o3.toString());


    }
    
}
