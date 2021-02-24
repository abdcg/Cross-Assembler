public class Administrator implements IAdministrator
{
    private boolean isthereoption = true;
    private String option;
    private String file;

    //This constructor will evaluate the arguments passed to it. It will create a administrator object
    //with three components: Boolean isthereoption, String option and  Array of files
    public Administrator(String[]args)
    {

        System.out.println();

        switch(args[0])
        {
            case "-h":
            case "-help":
            case "-?":
                option = "h";
                break;

            case "-l":
            case "-listing":
                option = "l";
                file=args[1];
                break;

            case "-v":
            case "-verbose":
                option = "v";
                file= args[1];
                break;

            default:
                file = args[0];
                isthereoption = false;
                break;

        }

    }

    //Returns true if Administrator holds an option, false if not
    public boolean isIsthereoption() {
        return isthereoption;
    }

    //Returns the type of option requested
    public String getOption() {
        return option;
    }

    //Returns an Array containing all File names
    public String getFiles() {
        return file;
    }


}

