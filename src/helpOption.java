public class helpOption implements IOption {

    static String help = "Usage: lexer <option> <Assembly File>";

    public helpOption() {

    }

    public void printOption()
    {
        System.out.print(help);
        System.out.println();
        System.exit(0);
    }

    public boolean getVerbose() {
        return false;
    }

}
