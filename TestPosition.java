public class TestPosition {

    // the purpose of this class is to test the Position class

    //a group of Position objects are created
    public static void main(String[] args) {
        Position p1 = new Position(1);
        Position p2 = new Position(2);
        Position p3 = new Position(3);
        Position p4 = new Position(65535);

        //expected output
        System.out.println("Test Position");
        System.out.print("p1[1,0]");
        System.out.print(" p2[2,0]");
        System.out.print(" p3[3,0]");
        System.out.println(" p4[65535,0]");


        //actual output
        System.out.print("p1"+p1.toString());
        System.out.print(" p2"+p2.toString());
        System.out.print(" p3"+p3.toString());
        System.out.println(" p4"+p4.toString());


    }
    
}
