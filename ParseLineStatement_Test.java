import java.util.ArrayList;
import java.util.List;

public class ParseLineStatement_Test {



    public static void main(String[] args)
    {

        ErrorReporter r1=new ErrorReporter();
        List<Lexer.Token> list=new ArrayList<Lexer.Token>();
        Lexer.Token t1=new Lexer.Token(Lexer.Type.MNUMONIC_NAMES,"pop");
        Lexer.Token t2=new Lexer.Token(Lexer.Type.EOL,"");
        Lexer.Token t3=new Lexer.Token(Lexer.Type.MNUMONIC_NAMES,"exit");
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t2);
        Lexer.fillTable();
        ParseLineStatement p1=new ParseLineStatement();




        System.out.print("Test ParseLineStatement Class\n");
        System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s\n","Line","Addr","Machine Code","Label","Assembly Code","Comments");
        System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s\n","1","0","1"," ","pop","null");
        System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s\n","2","1","3"," ","exit","null");
        p1.parseLine(list, r1);
        p1.AssemblyCall(r1);






    }
}