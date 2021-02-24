
public class Check 
{
	public static Boolean isMnem(String s) 
	{ 
		if(s.equals("add") || s.equals("addv") || s.equals("and") || s.equals("br") || s.equals("brf") || s.equals("call") || s.equals("dec") || s.equals("decv") || s.equals("div") || s.equals("dup") || s.equals("enter") || s.equals("halt") || s.equals("inc") || s.equals("incv") || s.equals("ldc") || s.equals("ldv") || s.equals("mul") || s.equals("neg") || s.equals("not") || s.equals("or") || s.equals("pop") || s.equals("rem") || s.equals("ret") || s.equals("shl") || s.equals("shr") || s.equals("sub") || s.equals("stv") || s.equals("teq") || s.equals("tge") || s.equals("tgt") || s.equals("tle") || s.equals("tlt") || s.equals("tne") || s.equals("trap") || s.equals("xor")) 
		{ 
			return true;
		} 
		return false;
	}
}
