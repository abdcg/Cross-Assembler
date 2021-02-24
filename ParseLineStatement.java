import java.util.ArrayList;
import java.util.List;



public class ParseLineStatement 
{ 
	private   AssemblyUnit unit = new AssemblyUnit();
	private  ArrayList<Mnemonic>parseTable = new ArrayList<Mnemonic>();
	private  SymbolTable symbol = new SymbolTable(); 
	private  ArrayList<LineStatement>parseTabler = new ArrayList<LineStatement>();
	
	public ParseLineStatement() 
	{ 
		
	}
	
	public void parseLine(List<Lexer.Token> lexer, ErrorReporter error) 
	{
		int count = 1;
		for(int i = 0; i < lexer.size(); i++)
		{
			//Initializing variables
			LineStatement line = new LineStatement();
			Instruction inst = new Instruction();
			Mnemonic mne = new Mnemonic();		
			Operand op = new Operand();
			Comment comm = new Comment(); 
			Label lab = new Label();
			Directive dir = new Directive();
			StringOperand str = new StringOperand();
			Boolean itsDir = false;
			
			Boolean checkRange = false;
			Boolean skip = false;
			for(int q = i; q<lexer.size(); q++)
			{
				//a is the String Token passed from lexer
				String a = lexer.get(q).getToken();
				
				//if EOL, then set Mnemonic, set Operand, and increment i.
				if(lexer.get(q).t == Lexer.Type.EOL)
				{	
					if(itsDir) {
						inst.setDirective(dir);
						inst.setOperand(op);
					}
					else {
					inst.setMnemonic(mne);
					inst.setOperand(op);
					}
					i++;
					count++;
					break;
				} 
				
				//if Mnemonic, then set mne name(From lexer [a]) and opCode (from symbolTable)
				if(lexer.get(q).t == Lexer.Type.MNUMONIC_NAMES)
				{
					if(checkRange(a, 0) != null) {
					  checkRange = true; 	
					}
					
					for(int f = 0; f < Opcode.inherentMnemonics.length; f++)
					{
						if(Opcode.inherentMnemonics[f].equalsIgnoreCase(a))
						 skip = true;
					}
					
					mne.setName(a);
					mne.setOpCode(SymbolTable.getOpCode(a));	
				}
				
				if(lexer.get(q).t == Lexer.Type.DIRECTIVE)
				{
					dir.setName(a);
					itsDir = true;
				}
				
				//if Operand, then depending on what the mnemonic of this line is, assign 
				//the operand as either a label, address, or offset
				if(lexer.get(q).t == Lexer.Type.OPERAND || lexer.get(q).t == Lexer.Type.STRINGOPERAND)
				{
					
					if(lexer.get(q).t == Lexer.Type.OPERAND)
					switch(mne.getName()) 
					{ 					
						//if enter.u5, make it an address
						case "enter.u5": 
							 op.setAdddress(new Address(Integer.parseInt(a)));
							break;  
						//if br.i5 or brf.i5, make it a Label
						case "br.i5":  
						case "brf.i5":
						case "br.i8":
						case "br.i16":
						case "brf.i8":
						case "call.i16":
							if(!Character.isDigit(a.charAt(0)))
							 op.setLabel(new Label(a));
							else
							 error.addError(new ErrorMessage(count, "Error: Bad Label"));
							break; 
						//Otherwise make it an offset
						default:
							if(skip)
							{
								error.addError(new ErrorMessage(count, "Error: Label after inherent mnemonic"));
								skip = false;
								break;
							}
							if(checkRange) {
							try 
							{
								if(!(boolean) checkRange(lexer.get(q-1).getToken(), Integer.parseInt(a)))
								{
									error.addError(new ErrorMessage(count, "Error: Operand out of Range"));
									break;
								}
							}
							catch(NumberFormatException e)
							{
								error.addError(new ErrorMessage(count, "Error: Operand not a Integer"));
								break;
							}
								checkRange = false;
							}
							
							op.setOperand(a);		
					}
					else
					{
						//System.out.println(a);
						op.setOperand(a);
					}
				}
				
				if(lexer.get(q).t == Lexer.Type.OFFSETS && !a.equals("??"))
				{
					op.setOffset(new Offset(Integer.parseInt(a)));
				}
				
				//if comments, set comment
				if(lexer.get(q).t == Lexer.Type.COMMENTS)
				{
					comm.setComment(a);
				} 
				
				//if Label, set Label
				if(lexer.get(q).t == Lexer.Type.LABELS) 
				{ 
					if(!Character.isDigit(a.charAt(0)))
						lab.setName(a);
					else
						error.addError(new ErrorMessage(count, "Error: Label starts Digit"));
				}
				
				i = q;
					
			}
			
			line.setLabel(lab);
			line.setInstruction(inst);
			line.setComment(comm); 
			
			
			
			unit.push(line);
		}
		
	}
	
	public static Object checkRange(String a, int i)
	{
			int lowEnd = 0;
			int highEnd = 0;
			
			switch(a)
			{
				case "ldc.i3": 	
					lowEnd= -4; 
					highEnd= 3; 
					break; 
				case "ldv.u3": 
					lowEnd= 0; 
					highEnd=7; 
					break; 
				case "stv.u3":  
					lowEnd= 0; 
					highEnd=7; 
					break; 
				case "addv.u3":  
					lowEnd= 0; 
					highEnd=7; 
					break; 
				case "enter.u5":  
					lowEnd = 0; 
					highEnd =31; 
					break;
				case "addv.u8":
				case "ldv.u8":
				case "stv.u8":
				case "incv.u8":
				case "decv.u8":
				case "enter.u8":
				case "trap":	
					lowEnd = -123;
					highEnd = 127;
					break;
				case "lda.i16":
				case "ldc.i16":
					lowEnd= -32768;
					highEnd= 32767;
					break;
				case "ldc.i32":
					lowEnd= -2147483648;
					highEnd= 2147483647;
					break;
				case "ldc.i8 ":
					lowEnd= -128;
					highEnd= 127;
					break;
				default:
					return null;
			}
			
			if(i<=highEnd && i>= lowEnd)
				return true;
			
		return false;
	}
	
	//Final function executed in program, will either print the table if there are no errors or
    //It will print the list of errors
    public void AssemblyCall(ErrorReporter error)
    {
        //If there are no errors reported, print table
        if(error.isEmpty(error))
        {
            //The function reverse in Assembly unit will reverse the stack into a queue
            //We will ieterate over this queue and print the line of the table line by line.
            ArrayList<LineStatement> c=unit.getArrayList();
            System.out.println();
            System.out.println();
            System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s\n","Line","Addr","Machine Code","Label","Assembly Code","Comments");
            int cheat=0;
            
            //Loop on assembly unit for its size
            for(int i = 0; i < c.size(); i++ )
            {
    
            	//if offset of linestatement is null, set to 0;
                if(c.get(i).getInstruction().getOperand().getOffset()==null) 
                {
                    c.get(i).getInstruction().getOperand().setOffset(new Offset()); 
                }
                try { 
                	
                	//If there is a label, then print "label_name"--->"Comment"
                    if(c.get(i).getLabel().getName() !=null)
                    {
                        cheat--;
                    	System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s\n", " ", " ", " ",c.get(i).getLabel().getName(), " ", c.get(i ).getComment());
                
                    } 
                    
                    //If offset is not 0 or address is not null or label is not null, then print "opCode"--->"Mnemonic Name"--->"Operand"--->"Comment" 
                    else if(c.get(i).getInstruction().getOperand().getOffset().getSet() ==true || c.get(i).getInstruction().getOperand().getAdddress() != null || c.get(i).getInstruction().getOperand().getLabel() != null) 	
                    {
                       //System.out.println((c.get(i).getInstruction().getMnemonic().getName()+" " + c.get(i).getInstruction().getOperand()));
                    	System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s\n", cheat+1, Integer.toHexString(cheat), ((c.get(i).getInstruction().getMnemonic().getOpCode())+" "+c.get(i).getInstruction().getOperand().getOffset()), " ",  (c.get(i).getInstruction().getMnemonic().getName()+" " + c.get(i).getInstruction().getOperand()), c.get(i).getComment());
                    	cheat++;
                    }
                    
                    else if(c.get(i).getInstruction().getDirective() != null)
                    {
                    	System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s\n", cheat+1, Integer.toHexString(cheat), (c.get(i).getInstruction().getMnemonic().getOpCode()), " ",  (c.get(i).getInstruction().getDirective().getName()+" " + c.get(i).getInstruction().getOperand()), c.get(i).getComment());
                    	cheat++;
                    }
                    
                    //Else print "opCode"--->"Mnemonic Name"--->"Comment"
                    else {
                    	//System.out.println((c.get(i).getInstruction().getMnemonic().getName()+" " + c.get(i).getInstruction().getOperand()));
                        
                    	if(c.get(i).getInstruction().getOperand().getOperand() != null)
                    	{
                    		System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s\n", cheat+1, Integer.toHexString(cheat), ((c.get(i).getInstruction().getMnemonic().getOpCode())), " ",  (c.get(i).getInstruction().getMnemonic().getName()+" " + c.get(i).getInstruction().getOperand()), c.get(i).getComment());
                    	}
						
         
                    	else
                    	System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s\n", cheat+1, Integer.toHexString(cheat), (c.get(i).getInstruction().getMnemonic().getOpCode()), " ", c.get(i).getInstruction().getMnemonic().getName(), c.get(i).getComment()); 
                        
                    	cheat++;
                    }
                } 
                //in the case of null pointer, catch the exception and simply skip a line and continue through loop
                catch(NullPointerException e)
                {
                    System.out.println();
                    cheat++;
                    continue;
                }


            }
        }
        //Print list of errors
        else
        {
            error.printAllErrors();
        }
    }
	public void createBinary(Administrator a1)
    {
        BinaryConverter b1=new BinaryConverter(unit, "Binary.exe","Hex.exe",a1);
    }
    
}
