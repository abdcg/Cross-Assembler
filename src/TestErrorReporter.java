public class TestErrorReporter {
    // the purpose of this class is to test the ErrorReporter class
    public static void main(String[] args) {

        // Creating an ErrorReporter
        ErrorReporter reporter = new ErrorReporter();

        // Adding the errors to the reporter
        reporter.addError(new ErrorMessage(1,  "error1"));
        reporter.addError(new ErrorMessage(2,  "error2"));
        reporter.addError(new ErrorMessage(3,  "error3"));

        // expected output

        System.out.println("Test ErrorReporter");
        System.out.print("error1 at [1,0]");
        System.out.print(" error2 at [2,0]");
        System.out.println(" error3 at [3,0] ");

        // actual output

        reporter.printAllErrors();
        System.out.println();

    }
}
