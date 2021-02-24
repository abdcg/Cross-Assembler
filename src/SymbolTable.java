import java.util.HashMap;

public class SymbolTable implements ISymbolTable
{
	

	private static HashMap<String, Token1> symbols = new HashMap<String, Token1>();//This will be the pre-poluated table, it will be a String with a boolean expression, called true
	private static HashMap<String, Label> labelSymbol = new HashMap<String, Label>();
    private static HashMap<String, Mnemonic> preDefined = new HashMap<String, Mnemonic>();
    
    
    
    //searches symbols table
    public static boolean searchSymbols(String m) 
    { 
    	if(symbols.containsKey(m)) 
    	{
    		return true;
    	}
    	return false;
    }  
  //searches preDefined table
    public static boolean searchPreDefined(String m) 
    { 
    	if(preDefined.containsKey(m)) 
    	{
    		return true;
    	}
    	return false;
    } 
    //seraches label table
    public static boolean searchLabelTable(String m) 
    { 
    	if(labelSymbol.containsKey(m)) 
    	{
    		return true;
    	}
    	return false;
    } 
    
    
    //This will return the symbol in question. Will be used in lexer on first and second pass 
    //to calculate offsets.
    public static Token1 getSymbols(String s) 
     {
    	return symbols.get(s);
     } 
    
    public static int getOpCode(String s) 
    {
    	//System.out.println(preDefined.toString());
    	return symbols.get(s).getMnemonic().getOpCode();
    }
    
    
   public static void addLabel(String s, int address) 
   { 
	   Label label = new Label(s);
	   label.setAddress(address);
	   labelSymbol.put(s, label);
   } 
   
   
   public static Label getLabel(String s) 
   { 
	   return labelSymbol.get(s);
   }
    
    
    //This function will add the code depending on its Type, defined in the lexer
    //For now, we will pass 2 strings with the name and type of the atom. 
    //Eventually we will implement a factory that will allow us to pass a static object of Token from the 
    //Lexer, so we can compare the enum Type directly.
    //These are the symbols that actually exist within our src file
    public void addSymbol(String name, String type, int address) 
    {
  	  	
  	  	Token1 token = new Token1(); 
  	  	
  	  	//assign address to token 1
  	  	Address addr = new Address(address);
		token.setAddress(addr); 
		
		
  	  	//If it is a mnemonic, then assign the opcode
    	if(type.equals("MNUMONIC_NAMES")) 
    	{ 
    		Mnemonic mnem = new Mnemonic(); 
    		mnem.setName(name);
    		
    		switch (name)
            {
                case "halt": 
                	mnem.setOpCode(Opcode.halt); 
                	break;
                case "pop": 
                	mnem.setOpCode(Opcode.pop); 
                	break;
                case "dup": 
                	mnem.setOpCode(Opcode.dup); 
                	break;
                case "exit": 
                	mnem.setOpCode(Opcode.exit); 
                	break;
                case "ret": 
                	mnem.setOpCode(Opcode.ret); 
                	break;
                case "not": 
                	mnem.setOpCode(Opcode.not); 
                	break;
                case "and": 
                	mnem.setOpCode(Opcode.and); 
                	break;
                case "or": 
                	mnem.setOpCode(Opcode.or); 
                	break;
                case "xor": 
                	mnem.setOpCode(Opcode.xor); 
                	break;
                case "neg": 
                	mnem.setOpCode(Opcode.neg); 
                	break;
                case "inc": 
                	mnem.setOpCode(Opcode.inc); 
                	break;
                case "dec": 
                	mnem.setOpCode(Opcode.dec); 
                	break;
                case "add": 
                	mnem.setOpCode(Opcode.add); 
                	break;
                case "sub": 
                	mnem.setOpCode(Opcode.sub); 
                	break;
                case "mul": 
                	mnem.setOpCode(Opcode.mul); 
                	break;
                case "div": 
                	mnem.setOpCode(Opcode.div); 
                	break;
                case "rem": 
                	mnem.setOpCode(Opcode.rem); 
                	break;
                case "shl": 
                	mnem.setOpCode(Opcode.shl); 
                	break;
                case "shr": 
                	mnem.setOpCode(Opcode.shr); 
                	break;
                case "teq": 
                	mnem.setOpCode(Opcode.teq); 
                	break;
                case "tne": 
                	mnem.setOpCode(Opcode.tne); 
                	break;
                case "tlt": 
                	mnem.setOpCode(Opcode.tlt); 
                	break;
                case "tgt": 
                	mnem.setOpCode(Opcode.tgt); 
                	break;
                case "tle": 
                	mnem.setOpCode(Opcode.tle); 
                	break;
                case "tge":  
                	mnem.setOpCode(Opcode.tge); 
                	break;
                case "br.i5":  
                	mnem.setOpCode(Opcode.br_i5);
                	break;
                case "brf.i5":  
                	mnem.setOpCode(Opcode.brf_i5); 
                	break;
                case "enter.u5": 
                	mnem.setOpCode(Opcode.enter_u5); 
                	break;
                case "ldc.i3":  
                	mnem.setOpCode(Opcode.ldc_i3); 
                	break;
                case "addv.u3":  
                	mnem.setOpCode(Opcode.addv_u3); 
                	break;
                case "ldv.u3":  
                	mnem.setOpCode(Opcode.ldv_u3); 
                	break;
                case "stv.u3": 
                	mnem.setOpCode(Opcode.stv_u3); 
                	break; 
                case "addv.u8": 
                	mnem.setOpCode(Opcode.addv_u8); 
                	break;
                case "ldv.u8": 
                	mnem.setOpCode(Opcode.ldv_u8);  
                	break;
                case "stv.u8": 
                	mnem.setOpCode(Opcode.stv_u8);  
                	break;
                case "incv.u8": 
                	mnem.setOpCode(Opcode.incv); 
                	break;
                case "decv.u8": 
                	mnem.setOpCode(Opcode.decv); 
                	break;
                case "enter.u8": 
                	mnem.setOpCode(Opcode.enter_u8); 
                	break;
                case "lda.i16": 
                	mnem.setOpCode(Opcode.lda_i16);
                	break;
                case "ldc.i8": 
                	mnem.setOpCode(Opcode.ldc_i8);
                	break;
                case "ldc.i16": 
                	mnem.setOpCode(Opcode.ldc_i16); 
                	break;
                case "ldc.i32": 
                	mnem.setOpCode(Opcode.ldc_i32);	
                	break;
                case "br.i8": 
                	mnem.setOpCode(Opcode.br_i8); 
                	break;
                case "br.i16": 
                	mnem.setOpCode(Opcode.br_i16); 
                	break;
                case "brf.i8": 
                	mnem.setOpCode(Opcode.brf_i8); 
                	break;
                case "calls.i16": 
                	mnem.setOpCode(Opcode.calls_i16); 
                	break;
                case "trap": 
                	mnem.setOpCode(Opcode.trap);
                	break;
                	
            } 
    		//assign the mnemonic of the token1
    		token.setMnem(mnem);
        } 
    	/*
    	//if it is a label, just add the label
    	if(type.equals("LABELS")) 
    	{ 
    		Label label = new Label(); 
    		label.setName(name);
    		token.setLabel(label);
    	} 
    	*/
    	//if token is a comment
    	if(type.equals("COMMENTS")) 
    	{ 
    		Comment comment = new Comment(); 
    		token.setComment(comment);
    	} 
    	
    	if(type.equals("OPERAND")); 
    	{ 
    		//Address, Label, offset
    		Operand operand = new Operand(name);  
    		token.setOperand(operand);
    		
    	} 
    	
    	//Finally adds the token (either a label, comment, or mnemonic) to the symbols 
    	//table, with all associated values. We may later replace the Token1 class with 
    	//a design pattern that allows me to store the separate classes by having them extend 
    	//some based class/interface
    	symbols.put(name, token);
  	  	
      } 
    
    
    
    //This function will populate our preDefined table with all predefined mnemonics. 
    //This will allow us to check whether a token is or is not a mnemonic from the lexer by 
    //cross reference.
    public void populate(String atom) 
    { 
    	Token1 toky = new Token1();
    	Mnemonic mnemonic = new Mnemonic();
    	mnemonic.setName(atom);
    	switch (atom)
        {
            case "halt": 
            	mnemonic.setOpCode(Opcode.halt); 
            	break;
            case "pop": 
            	mnemonic.setOpCode(Opcode.pop); 
            	break;
            case "dup": 
            	mnemonic.setOpCode(Opcode.dup); 
            	break;
            case "exit": 
            	mnemonic.setOpCode(Opcode.exit); 
            	break;
            case "ret": 
            	mnemonic.setOpCode(Opcode.ret); 
            	break;
            case "not": 
            	mnemonic.setOpCode(Opcode.not); 
            	break;
            case "and": 
            	mnemonic.setOpCode(Opcode.and); 
            	break;
            case "or": 
            	mnemonic.setOpCode(Opcode.or); 
            	break;
            case "xor": 
            	mnemonic.setOpCode(Opcode.xor); 
            	break;
            case "neg": 
            	mnemonic.setOpCode(Opcode.neg); 
            	break;
            case "inc": 
            	mnemonic.setOpCode(Opcode.inc); 
            	break;
            case "dec": 
            	mnemonic.setOpCode(Opcode.dec); 
            	break;
            case "add": 
            	mnemonic.setOpCode(Opcode.add); 
            	break;
            case "sub": 
            	mnemonic.setOpCode(Opcode.sub); 
            	break;
            case "mul": 
            	mnemonic.setOpCode(Opcode.mul); 
            	break;
            case "div": 
            	mnemonic.setOpCode(Opcode.div); 
            	break;
            case "rem": 
            	mnemonic.setOpCode(Opcode.rem); 
            	break;
            case "shl": 
            	mnemonic.setOpCode(Opcode.shl); 
            	break;
            case "shr": 
            	mnemonic.setOpCode(Opcode.shr); 
            	break;
            case "teq": 
            	mnemonic.setOpCode(Opcode.teq); 
            	break;
            case "tne": 
            	mnemonic.setOpCode(Opcode.tne); 
            	break;
            case "tlt": 
            	mnemonic.setOpCode(Opcode.tlt); 
            	break;
            case "tgt": 
            	mnemonic.setOpCode(Opcode.tgt); 
            	break;
            case "tle": 
            	mnemonic.setOpCode(Opcode.tle); 
            	break;
            case "tge":  
            	mnemonic.setOpCode(Opcode.tge); 
            	break;
            case "br.i5":  
            	mnemonic.setOpCode(Opcode.br_i5);
            	break;
            case "brf.i5":  
            	mnemonic.setOpCode(Opcode.brf_i5); 
            	break;
            case "enter.u5": 
            	mnemonic.setOpCode(Opcode.enter_u5); 
            	break;
            case "ldc.i3":  
            	mnemonic.setOpCode(Opcode.ldc_i3); 
            	break;
            case "addv.u3":  
            	mnemonic.setOpCode(Opcode.addv_u3); 
            	break;
            case "ldv.u3":  
            	mnemonic.setOpCode(Opcode.ldv_u3); 
            	break;
            case "stv.u3": 
            	mnemonic.setOpCode(Opcode.stv_u3); 
            	break; 
            case "addv.u8": 
            	mnemonic.setOpCode(Opcode.addv_u8); 
            	break;
            case "ldv.u8": 
            	mnemonic.setOpCode(Opcode.ldv_u8);  
            	break;
            case "stv.u8": 
            	mnemonic.setOpCode(Opcode.stv_u8);  
            	break;
            case "incv.u8": 
            	mnemonic.setOpCode(Opcode.incv); 
            	break;
            case "decv.u8": 
            	mnemonic.setOpCode(Opcode.decv); 
            	break;
            case "enter.u8": 
            	mnemonic.setOpCode(Opcode.enter_u8); 
            	break;
            case "lda.i16": 
            	mnemonic.setOpCode(Opcode.lda_i16);
            	break;
            case "ldc.i8": 
            	mnemonic.setOpCode(Opcode.ldc_i8);
            	break;
            case "ldc.i16": 
            	mnemonic.setOpCode(Opcode.ldc_i16); 
            	break;
            case "ldc.i32": 
            	mnemonic.setOpCode(Opcode.ldc_i32);	
            	break;
            case "br.i8": 
            	mnemonic.setOpCode(Opcode.br_i8); 
            	break;
            case "br.i16": 
            	mnemonic.setOpCode(Opcode.br_i16); 
            	break;
            case "brf.i8": 
            	mnemonic.setOpCode(Opcode.brf_i8); 
            	break;
            case "calls.i16": 
            	mnemonic.setOpCode(Opcode.calls_i16); 
            	break;
            case "trap": 
            	mnemonic.setOpCode(Opcode.trap);
            	break;
        }
    	toky.setMnem(mnemonic);
    	symbols.put(atom, toky);
    	preDefined.put(atom, mnemonic);
    } 
    
    public void setOffset(String s, int i) 
    { 
    	Offset offset = new Offset(); 
    	offset.setNumOffset(i);
    	symbols.get(s).setOffset(offset); 
    	
    } 
    
    public static String printSymbols() 
    { 
    	return symbols.toString();
    }


    public static String printPreDefined() 
    { 
    	return preDefined.toString();
    }
}