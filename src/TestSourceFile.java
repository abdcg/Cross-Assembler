public class TestSourceFile {
    //the purpose of this class is to test SourceFile class
 public static void main(String[] args) {
     //creating SourceFile objects 
     SourceFile s1 = new SourceFile("test.txt","txt");
     SourceFile s2 = new SourceFile("test2.asm","asm");
     SourceFile s3 = new SourceFile("test3.exe","exe");

     System.out.println("Test SourceFile");
     System.out.println("filename: test.txt extension: txt filename: test2.asm extension: asm filename: test3.exe extension: exe");
     System.out.print(s1.toString()+" ");
     System.out.print(s2.toString()+" ");
     System.out.println(s3.toString());



 }   
}
