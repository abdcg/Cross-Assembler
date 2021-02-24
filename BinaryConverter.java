
import javax.sound.sampled.Line;
import java.io.*;
import java.util.Scanner;

public class BinaryConverter {

    private PrintWriter pw;
    private PrintWriter pw2;
    private AssemblyUnit br; // Create a BufferedReader object to read from input files

    public BinaryConverter(AssemblyUnit list, String fileName,String fileName2, Administrator admin) {

        try {
            br = list;
            pw = new PrintWriter(new FileOutputStream(fileName));// to remove asm from name.asm and add .exe
            pw2= new PrintWriter(new FileOutputStream(fileName2));
            fileCreate(br, pw,pw2, admin);


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




    public void fileCreate(AssemblyUnit list, PrintWriter p,PrintWriter p2, Administrator admin) throws IOException // Declare the IOException exception
    {
        // Read line by line from input file and copy it to output file
        LineStatement s;
        int count=0;
        int count1=0;
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

            if(s.getInstruction()!=null)
            { p.print("00"+Integer.toBinaryString(s.getInstruction().getMnemonic().getOpCode())+" ");//error in accessing data
            }
            else
            {    array[count1]=s;
                count1++; }

            p2.print(Integer.toHexString(s.getInstruction().getMnemonic().getOpCode())+" ");
            count++;



            if(count<length)
                s=(LineStatement) a1.pop();

            else
                s=null;
        }

        for(int i=0;i<count1;i++)
            p.print(array[i].getInstruction().getDirective().getCode());
        // Must close the file
        p.close();
        p2.close();


    }


}
