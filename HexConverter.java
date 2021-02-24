import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class HexConverter {

    private PrintWriter pw;
    private AssemblyUnit br; // Create a BufferedReader object to read from input files

    public HexConverter(AssemblyUnit list, String fileName, Administrator admin) {

        try {
            br = list;
            pw = new PrintWriter(new FileOutputStream(fileName));// to remove asm from name.asm and add .exe

            fileCreate(br, pw, admin);


        }

        // At this moment, both streams exist, so call the method to copy the file
        // However, possible IOException may still occur while reading the input file

        catch (FileNotFoundException e) {
            System.out.println("Problem opening files. Cannot proceed to copy.");
            System.out.println("Program will terminate.");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Error: An error has occurred while reading from the " + fileName + " file. ");
            System.out.println("Program will terminate.");
            System.exit(0);
        }

        System.out.println("File created");

    }




    public void fileCreate(AssemblyUnit list, PrintWriter p, Administrator admin) throws IOException // Declare the IOException exception
    {
        // Read line by line from input file and copy it to output file
        LineStatement s;
        int count=0;
        AssemblyUnit a1 =new AssemblyUnit();
        int length=list.getSize();
        if(admin.getOption()=="v")
        {
            for(int i=0;i<length;i++)
            {
                System.out.println("x");
            }
        }
        for (int i=0;i<length;i++)
            a1.push(list.pop());
        s=(LineStatement)a1.pop();
        LineStatement[] array=new LineStatement[a1.getSize()];

        while (s != null) // The readLine() method returns null when it is EOF
        {
            ////**** DEVIN HERE IS WHERE THE LINES ARE WRITTEN IN NEW FILE USE YOUR BINARY METHOD HERE*******/


            { p.print(Integer.toHexString(s.getInstruction().getMnemonic().getOpCode())+" ");//error in accessing data
            }


            count++;
            if(count<length)
                s=(LineStatement) a1.pop();
            else
                s=null;
        }
        // Must close the file
        p.close();


    }

}
