import java.util.List;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList; 


public class Lexer  
{ 
	
	private static File srcFile = null ; 
	private static String srcFilename = "<srcFilename>"; 
	private static int lineNumber;
	private static SymbolTable table = new SymbolTable(); 
	private static ErrorReporter error= new ErrorReporter(); 
	
	
	
	
	public Lexer() 
	{
		fillTable();
	}
	
	public static enum Type
	{ 
		//This Assembly code has 5 token types (I am a little confused about this, the documentation released does not specify or at least 
		//go into great detail about about addresses and offsets, and even mentions that they are excluded from Cm Assembly, so I'm not sure
		//what to do for those
		MNUMONIC_NAMES, LABELS, ADDRESSES, OFFSETS, COMMENTS, LINE_NUMBER, MACHINE_CODE, EOL, OPERAND, DIRECTIVE, STRINGOPERAND;
	} 
	
	//Passing mnemonics to Symbol Table  
	public static void fillTable() 
	{ 
		
		String[] mnem = Opcode.inherentMnemonics; 
		String[] immediate = Opcode.immediateMnemonics; 
		String[] relative = Opcode.relativeMnemonics;
		for(int i=0; i< mnem.length; i++) 
		{ 
			
			table.populate(mnem[i]); 
			
		} 
		for(int i = 0; i< immediate.length; i++) 
		{ 
			
			table.populate(immediate[i]); 
		} 
		for(int i = 0; i< relative.length; i++) 
		{ 
			
			table.populate(relative[i]); 
		}
	}
	
	
	
	
	//This class creates an object of type token
	public static class Token
	{ 
		public final Type t; 
		public String c; 
		
		//constructor (set type)
		public Token(Type t, String c) 
		{ 
			this.t = t; 
			this.c = c;
		} 
		public String getToken() 
		{ 
			return c;
		}
		
		//toString
		public String toString() 
		{ 
			if(t == Type.MNUMONIC_NAMES) 
			{ 
				return "MNUMONIC_NAMES<" + c + ">";
			} 
			
			if(t == Type.LABELS) 
			{ 
				return "LABELS<" + c + ">";
			}  
			
			if(t == Type.ADDRESSES) 
			{ 
				return "ADDRESSES<" + c + ">";
			} 
			
			if(t == Type.OFFSETS) 
			{ 
				return "OFFSETS<" + c + ">";
			} 
			
			if(t == Type.COMMENTS) 
			{ 
				return "COMMENTS<" + c + ">";
			} 
			if(t == Type.LINE_NUMBER) 
			{ 
				return "LINE_NUMBER<" + c + ">";
			}
			if(t == Type.MACHINE_CODE) 
			{ 
				return "MACHINE_CODE<" + c+ ">";
			} 
			if(t == Type.EOL)
			{ 
				return "EOL";
			}
			if(t == Type.OPERAND)
			{ 
				return "OPERAND<"+c+">";
			} 
			if(t==Type.DIRECTIVE) 
			{ 
				return "DIRECTIVE<"+c+">";
			}
			if(t==Type.STRINGOPERAND) 
			{ 
				return "STRING_OPERAND<"+c+">";
			}
			return t.toString();
		}
	} 
	
	
	
	//Given a String and an index, get the word/atom starting at index (this will be used for mnemonics and labels, 
	//since they are both single words
	public static String getAtom(String s, int i) 
	{ 
		int j = i; 
		while(s.charAt(j) != '\n') 
		{ 
			//while character is a letter, continue
			if(!Character.isWhitespace(s.charAt(j))) 
			{ 
				j++;
			} 
			else 
			{ 
				return s.substring(i, j);
			}
		} 
		return s.substring(i,j);
	} 
	
	//This method will be used to calculate the offset of an immediate instruction 
	
	
	//Given a String and an index, get the comment starting at index
	//I am having trouble with this one, it returns every word except the last letter of the last word 
	//If I remove the -1 from the length, it goes out of bounds.

		public static String getComment(String s, int i) 
		{ 
			int j = i; 
			
			while(j < s.length()) 
			{ 
				//while character is a letter, continue 
				if(s.charAt(j) != '\n') 
				{ 
					j++;
				} 
				else 
				{ 
					return s.substring(i, j);
				}
			} 
		 
			return s.substring(i,j);
			
		}  
		
		public static boolean isInteger(String s) {
		      boolean isValidInteger = false;
		      try
		      {
		         Integer.parseInt(s);
		 
		         // s is a valid integer
		 
		         isValidInteger = true;
		      }
		      catch (NumberFormatException ex)
		      {
		         // s is not an integer
		      }
		 
		      return isValidInteger;
		   }
 
	//method creates and returns a List of Tokens
	//This method performs the first pass of the lexer
	public static List<Token> lex(String input)
	{
		//for(int t=0; t < input.length(); t++) 
		//{
			//lineNumber++;
			List<Token> pass1Result = new ArrayList<Token>(); 
			
			//List<LineStatement> result1 = new ArrayList<LineStatement>();
			
			for(int i = 0;i < input.length();) 
			{ 
				
				switch(input.charAt(i)) 
				{  
					//case comment
					case '\n':
						pass1Result.add(new Token(Type.EOL, "")); 
						lineNumber++;
						i++;
						break;
					
					case ';': 
						String comment = getComment(input, i); 
						i+=comment.length();
						pass1Result.add(new Token(Type.COMMENTS, comment)); 
						//Add the atom to the table of tokens in use as well as part of first pass
						table.addSymbol(comment,"COMMENTS" , lineNumber);
						break;
	
					//If it starts with a number, we know that it will be an operand (either Offset or Address)
					case '0': case '1': case '2': case '3': case '4':
		            case '5': case '6': case '7': case '8': case '9':
		            	String operand = getAtom(input, i);
		            	i += operand.length();
		            	if(pass1Result.get(pass1Result.size()-1).t == Type.MNUMONIC_NAMES) {
		            	pass1Result.add(new Token(Type.OPERAND, operand)); 
		            	table.addSymbol(operand, "OPERAND", lineNumber);
		            	break;
		            	}
		            	else {
		            		pass1Result.add(new Token(Type.LABELS, operand));
		            		break;
		            	}
		            	 
		            
		            //If it is a directive, just scane the atom and add it as a directive.
		            //Modify symbol Table for directives
		            case '.': 
		            	String directive = getAtom(input, i); 
		            	i+=directive.length();
		            	pass1Result.add(new Token(Type.DIRECTIVE, directive));
		            	//pass1Result.add(new Token(Type.STRINGOPERAND, getAtom(input, i+1)));
		            	break;
					
					//if not a comment it is either a label or mnemonic (still uncertain about addresses and offsets)	
					default:  
						//if white space, continue
						if(Character.isWhitespace(input.charAt(i))) 
						{ 
							
							if(input.charAt(i) == '\n') 
							{ 
								lineNumber++;
							} 
							i++;
						}  
						//If it is not a white space, then it is 1 of 3 things; A mnemonic, A label, or an operand 
						//We will first check to see if it has a white space before it, if it does not, we will attempt to
						//process if as a Label. If it is in the preDefinedsymbolTable, then we will throw an error, else
						//we check to see if it is a mnemonic or operand.
						else 
						{ 
							String atom = getAtom(input, i);
							//w represents the previous int, will use to check if previous char is whitespace 
							int w = i-1;
							i += atom.length(); 
							//if previous char is not null, then we will check the char before, else, try to process as a Label
							if(w !=-1) 
							{ 
								//if it is a whitespace before the atom, attempt to process as a mnemonic
								if(input.charAt(w) == ' ' || input.charAt(w) == '\t') 
								{ 
									//check to see if the atom is in the predefined table. If it is, then process
									//as a mnemonic, if not, then process as an operand
									if(SymbolTable.searchPreDefined(atom)) 
									{ 
										pass1Result.add(new Token(Type.MNUMONIC_NAMES, atom)); 
										table.addSymbol(atom, "MNUMONIC_NAMES", lineNumber);
									} 
									//if operand, try to find see if the Label already exists inside the label table, 
									//if so calculate and return offset, if not, set offset to "??"
									else 
									{ 
										Lexer.Type prev = pass1Result.get(pass1Result.size()-1).t;
										//System.out.println("---------------------------"+pass1Result.get(pass1Result.size()-1).t);
										
										//Will add either a Operand or String Operand depending on the previous Token
										if(prev != Lexer.Type.DIRECTIVE)
										pass1Result.add(new Token(Type.OPERAND, atom));
										else
										pass1Result.add(new Token(Type.STRINGOPERAND, atom));
										
										//if it is in the labelTable, then retrieve address and calculate offset
										if(SymbolTable.searchLabelTable(atom)) 
										{ 
											int currAddr = lineNumber; 
											int labelAddr = SymbolTable.getLabel(atom).getAddress(); 
											int offset = labelAddr-currAddr; 
						
											pass1Result.add(new Token(Type.OFFSETS, Integer.toString(offset)));
										} 
										//if not then assign offset as "??"
										else 
										{ 
											if(prev != Lexer.Type.DIRECTIVE)
											pass1Result.add(new Token(Type.OFFSETS, "??"));
										}
									}
								}
								//if there is no whitespace before the atom, attempt to process as a Label
								else 
								{ 
									//if the atom is not in the predefined table (mnemonic) or the label-Table (no repeated labels allowed) 
									//then process as label, else throw error
									if(!SymbolTable.searchPreDefined(atom)) 
									{ 
										//Not in predefined or label table, process as a label
										if(!SymbolTable.searchLabelTable(atom)) 
										{ 
											pass1Result.add(new Token(Type.LABELS,  atom)); 
											table.addLabel(atom, lineNumber);
										}
										//not in predefined table, but in Label table means it is a repeated Label
										else 
										{ 
											error.addError(new ErrorMessage(lineNumber, "Error: Repeated Label"));
										}
									} 
									//is in predefined table, throw error as a mnemonic cannot be in column 1
									else 
									{ 
										error.addError(new ErrorMessage(lineNumber, "Error: This is not proper syntax for a mnemonic. It is located in column 1, when it should be in column 2"));
									}
								}
							} 
							//try to process as a Label
							else 
							{ 
								//if the atom is not in the predefined table (mnemonic) or the label-Table (no repeated labels allowed) 
								//then process as label, else throw error
								if(!SymbolTable.searchPreDefined(atom)) 
								{ 
									//Not in predefined or label table, process as a label
									if(!SymbolTable.searchLabelTable(atom)) 
									{ 
										pass1Result.add(new Token(Type.LABELS,  atom)); 
										table.addLabel(atom, lineNumber);
									}
									//not in predefined table, but in Label table means it is a repeated Label
									else 
									{ 
										error.addError(new ErrorMessage(lineNumber, "Error: Repeated Label"));
									}
								} 
								//is in predefined table, throw error as a mnemonic cannot be in column 1
								else 
								{ 
									error.addError(new ErrorMessage(lineNumber, "Error: This is not proper syntax for a mnemonic. It is located in column 1, when it should be in column 2"));
								}
							}
						}
						break;
				}
			} 
		//}
		//return list from first pass
		return pass1Result;
	} 
	
	
	public static List<Token> lex2(List<Token> pass1Result)
	{ 
		List<Token> lex2 = new ArrayList<Token>(); 
		
		//will keep track of line number
		int count1 = 1; 
		//will loop through the list, it will add the items one by one, or it will 
		//find the offset and add it. If the associated labels cannot be found, then this 
		//method throws 1 error, no associated labels.
		for(int i=0; i<pass1Result.size(); i++) 
		{ 
			//current token
			Token item = pass1Result.get(i);
			
			//if we encounter and end of line (EOL), we increase line number
			if(item.t == Type.EOL) 
			{ 
				count1++; 
			}
			
			//If we encounter an operand, peek ahead, and see if the associated offset if "??" (this offset is saved as next) 
			// if it is then search the label table to see if any associated labels have been added. If they have, then set the offset 
			//if not "throw the error, no associated labels"
			if(item.t == Type.OPERAND && i+1 < pass1Result.size()) 
			{ 
				//adding the operand to lex2 (will be added regardless of anything)
				lex2.add(item);
				
				//This token should represent the offset, if it does not, simply add it to the list, 
				//let the lineParser take care of the formating/grammar
				Token next = pass1Result.get(i+1);
				
				//if next is an offset set to "??", then look through he label Table to see 
				//if the label associated to item has been added. If so calculate the offset, if not 
				//throw the error; "no associated label"
				if(next.t == Type.OFFSETS && next.c.equals("??") )
				{
					//if operand label is in Label Table, calculate offset, then increment i (skip offset
					//set to ??".
					if(SymbolTable.searchLabelTable(item.c)) 
					{
						int currAddr = count1; 
						int labAddr = SymbolTable.getLabel(item.c).getAddress(); 
						int offset = labAddr - currAddr; 
						lex2.add(new Token(Type.OFFSETS, Integer.toString(offset)));
						i++;
					} 
					//else throw error
					else 
					{ 
						System.out.println("I AM HERE "+item.c + " "+ count1);
						error.addError(new ErrorMessage(count1, "Error: No associated Label"));
					}
					
				}
				//if offset is not set to "??", just add it to lex2, then increment i.
				else 
				{ 
					lex2.add(next); 
					i++;
				}
			}
			//if not operand, just add to lex2
			else 
			{ 
				lex2.add(item);
			}
		}
		//return lex2
		return lex2;
		
	}

	
	
	
	//main just to test functionality, will run in terminal/command line
	public static void main(String[] args) throws IOException {
        Administrator a1=new Administrator(args);
	
		
		if(args.length < 1) {
            System.out.println("Usage: java Lexer \"((some Scheme) (code to) lex)\".");
            return;
        }
		
		if(args.length == 2)
	        if (args[1] != null) 
	        { 
	        	//check <src> 
				srcFilename = args[1]; 
				System.out.println("charcount: srcFilename '" + srcFilename + "'"); 
				srcFile = new File(srcFilename); 
				if(!srcFile.canRead()) 
				{ 
					System.out.println("charcount: cannot open srcFile '" + srcFilename + "'"); 
					return;
				}
	        } 
	        else 
			{ 
				System.out.println("charcount: [OK] srcFilename = '" + srcFilename + "'"); 
				
			}
		
		if(args.length == 1)
	        if (args[0] != null) 
	        { 
	        	//check <src> 
				srcFilename = args[0]; 
				System.out.println("charcount: srcFilename '" + srcFilename + "'"); 
				srcFile = new File(srcFilename); 
				if(!srcFile.canRead()) 
				{ 
					System.out.println("charcount: cannot open srcFile '" + srcFilename + "'"); 
					return;
				}
	        } 
	        else 
			{ 
				System.out.println("charcount: [OK] srcFilename = '" + srcFilename + "'"); 
				
			} 
		if(a1.isIsthereoption() && a1.getOption()=="h")
            		new helpOption().printOption(); 
		
		//srcFilename = "Momo.txt";
		//srcFilename = "C:\\Users\\abdcg\\Desktop\\School\\Concordia\\Semester 4\\SOEN 341\\Project B\\Sprint 1\\Lexer test\\Test 2.txt"; 
		//srcFile = new File(srcFilename);
        
        ParseLineStatement verb = new ParseLineStatement(); 
        ParseLineStatement reg = new ParseLineStatement();
		
        FileReader fr  = new FileReader(srcFile); 
        BufferedReader br = new BufferedReader(fr);
        String line;  
        
        //make obj of type lexer 
        Lexer lexy = new Lexer();
        String total = "";
        
        //Making whole file into a String
        while((line = br.readLine()) != null) 
        { 
        	total += (line + "\n");
        } 
         
       //Using and print lex method(first pass result)
       List<Token> tokens = lex(total);
       for(Token t : tokens) { 
      	 
           System.out.println(t);
       }
       
       System.out.println();
       System.out.println();
       System.out.println();
       
       //Using and print lex2 method(second pass result)
       List<Token> test = lex2(tokens);
       for(Token t : test) { 
      	 
           System.out.println(t);
       }
       
       //ParseLineStatement ParseLineStatement = new ParseLineStatement();
       
       //ParseLineStatement.parseLine(test, error); 
       //ParseLineStatement.AssemblyCall(error);
       
       System.out.println();
       System.out.println();
       System.out.println();
       
       //Printing all errors
       //error.printAllErrors();
     
       
       if(a1.isIsthereoption())
        {
            switch(a1.getOption()) {
                case "l":
                    reg.parseLine(test, error);
                    reg.AssemblyCall(error);
                    break;
                case "v":
                    verb.parseLine(tokens, error);
                    verb.AssemblyCall(error);
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    verb.createBinary(a1);
                    break;
                default:
                    reg.parseLine(test, error);
                    reg.createBinary(a1);

            }
        }
       else 
       {
    	   reg.parseLine(test, error);
    	   reg.createBinary(a1);
       }
      
    }
	
}
