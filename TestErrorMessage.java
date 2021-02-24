public class TestErrorMessage {
    public static void main(String[] args) {

        // the purpose of this class is to test the ErrorMessage class

        // a group of ErrorMessage objects are created

        ErrorMessage em1 = new ErrorMessage(1,  "error1");
        ErrorMessage em2 = new ErrorMessage(2,  "error2");
        ErrorMessage em3 = new ErrorMessage(3,  "error3");

        // expected output
        System.out.println("Test ErrorMessage");
        System.out.println("error1 at [1,0]error2 at [2,0]error3 at [3,0]");

        // actual output

        System.out.print(em1.getErrorMessage());
        System.out.print(em2.getErrorMessage());
        System.out.println(em3.getErrorMessage());

    }

}
