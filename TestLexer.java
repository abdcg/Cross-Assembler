import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class TestLexer
{
	public static void main(String[] args) throws IOException
	{ 
		  	System.out.println("Test Lexer ");						 //Test Identification 
		  	
		  	File srcFile = null ; 
			String srcFilename = "<srcFilename>"; 
		
			srcFilename = "C:\\Users\\abdcg\\Desktop\\School\\Concordia\\Semester 4\\SOEN 341\\Project B\\Sprint 2\\Aladdin Test.txt"; 
			srcFile = new File(srcFilename);
			FileReader fr  = new FileReader(srcFile); 
	        BufferedReader br = new BufferedReader(fr);
	        String line;  
	        
	        //make obj of type lexer 
	        Lexer lexy = new Lexer();
	        String total = "";
	        
	        while((line = br.readLine()) != null) 
	        { 
	        	total += (line + "\n");
	        }  
	        
	        //testing first pass 
	       // System.out.println("Lexer first pass lex method"); 
	        
	        List<Lexer.Token> tokens = Lexer.lex(total);
	        for(Lexer.Token t : tokens) { 
	       	 
	            System.out.print(t + " ");
	        }  
	        /*
	        System.out.println();
	        System.out.println("MNUMONIC_NAMES<!br.i5> OPERAND<Label> EOL MNUMONIC_NAMES<halt> COMMENTS<;this is a comment> EOL MNUMONIC_NAMES<pop> EOL MNUMONIC_NAMES<dup> EOL MNUMONIC_NAMES<exit> EOL MNUMONIC_NAMES<ret> EOL MNUMONIC_NAMES<not> EOL MNUMONIC_NAMES<or> EOL LABELS<Label> EOL MNUMONIC_NAMES<xor> EOL MNUMONIC_NAMES<neg> EOL MNUMONIC_NAMES<inc> EOL MNUMONIC_NAMES<dec> EOL MNUMONIC_NAMES<add> EOL MNUMONIC_NAMES<sub> EOL MNUMONIC_NAMES<mul> EOL MNUMONIC_NAMES<div> EOL MNUMONIC_NAMES<rem> EOL MNUMONIC_NAMES<shl> EOL MNUMONIC_NAMES<shr> EOL MNUMONIC_NAMES<teq> EOL MNUMONIC_NAMES<tne> EOL MNUMONIC_NAMES<tlt> EOL MNUMONIC_NAMES<tgt> EOL MNUMONIC_NAMES<tle> EOL MNUMONIC_NAMES<tge> EOL MNUMONIC_NAMES<halt> EOL MNUMONIC_NAMES<ldc.i3> OPERAND<0> EOL "); 
	        System.out.println();
	      */
	        
	        //testing second pass 
	        //System.out.println("Lexer second pass lex method");
	        List<Lexer.Token> test = Lexer.lex2(tokens);
	        for(Lexer.Token t : test) { 
	       	 
	            System.out.print(t + " ");
	        } 
	        System.out.println(); 
	        System.out.println("MNUMONIC_NAMES<br.i5> OPERAND<Label> OFFSETS<??> EOL LABELS<Label> EOL MNUMONIC_NAMES<halt> COMMENTS<;this is a comment> EOL MNUMONIC_NAMES<pop> EOL MNUMONIC_NAMES<dup> EOL DIRECTIVE<.exit> EOL MNUMONIC_NAMES<ret> EOL MNUMONIC_NAMES<not> EOL MNUMONIC_NAMES<or> EOL MNUMONIC_NAMES<br.i5> OPERAND<Label> OFFSETS<-8> EOL MNUMONIC_NAMES<xor> EOL MNUMONIC_NAMES<neg> EOL MNUMONIC_NAMES<inc> EOL MNUMONIC_NAMES<dec> EOL MNUMONIC_NAMES<add> EOL MNUMONIC_NAMES<sub> EOL MNUMONIC_NAMES<mul> EOL MNUMONIC_NAMES<div> EOL MNUMONIC_NAMES<rem> EOL MNUMONIC_NAMES<shl> EOL MNUMONIC_NAMES<shr> EOL MNUMONIC_NAMES<teq> EOL MNUMONIC_NAMES<tne> EOL MNUMONIC_NAMES<tlt> EOL MNUMONIC_NAMES<tgt> EOL MNUMONIC_NAMES<tle> EOL MNUMONIC_NAMES<tge> EOL MNUMONIC_NAMES<halt> EOL MNUMONIC_NAMES<ldc.i3> OPERAND<1> EOL MNUMONIC_NAMES<br.i5> OPERAND<Label> OFFSETS<0> EOL LABELS<Label> EOL MNUMONIC_NAMES<halt> COMMENTS<;this is a comment> EOL MNUMONIC_NAMES<pop> EOL MNUMONIC_NAMES<dup> EOL DIRECTIVE<.exit> EOL MNUMONIC_NAMES<ret> EOL MNUMONIC_NAMES<not> EOL MNUMONIC_NAMES<or> EOL MNUMONIC_NAMES<br.i5> OPERAND<Label> OFFSETS<-8> EOL MNUMONIC_NAMES<xor> EOL MNUMONIC_NAMES<neg> EOL MNUMONIC_NAMES<inc> EOL MNUMONIC_NAMES<dec> EOL MNUMONIC_NAMES<add> EOL MNUMONIC_NAMES<sub> EOL MNUMONIC_NAMES<mul> EOL MNUMONIC_NAMES<div> EOL MNUMONIC_NAMES<rem> EOL MNUMONIC_NAMES<shl> EOL MNUMONIC_NAMES<shr> EOL MNUMONIC_NAMES<teq> EOL MNUMONIC_NAMES<tne> EOL MNUMONIC_NAMES<tlt> EOL MNUMONIC_NAMES<tgt> EOL MNUMONIC_NAMES<tle> EOL MNUMONIC_NAMES<tge> EOL MNUMONIC_NAMES<halt> EOL MNUMONIC_NAMES<ldc.i3> OPERAND<1> EOL ");
	        
	        
	       
	        
	}
}
