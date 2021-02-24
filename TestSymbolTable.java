public class TestSymbolTable {


    public static void main(String args[])
    { 
    	//SymbolTable table = new SymbolTable();
    	
        System.out.println("Test Symbol Table"); 
        
        Lexer.fillTable();
        System.out.println(SymbolTable.printPreDefined());
        System.out.println("{dec=opCode: 18 Mnemonic: dec, ldc.i16=opCode: 218 Mnemonic: ldc.i16, div=opCode: 22 Mnemonic: div, neg=opCode: 16 Mnemonic: neg, ldf.i3=opCode: 0 Mnemonic: ldf.i3, call.i16=opCode: 231 Mnemonic: call.i16, rem=opCode: 23 Mnemonic: rem, trap=opCode: 255 Mnemonic: trap, ret=opCode: 4 Mnemonic: ret, rfu6=opCode: 0 Mnemonic: rfu6, add=opCode: 19 Mnemonic: add, rfu5=opCode: 0 Mnemonic: rfu5, teq=opCode: 26 Mnemonic: teq, rfu7=opCode: 0 Mnemonic: rfu7, rfu2=opCode: 0 Mnemonic: rfu2, rfu1=opCode: 0 Mnemonic: rfu1, rfu4=opCode: 0 Mnemonic: rfu4, rfu3=opCode: 0 Mnemonic: rfu3, br.i16=opCode: 225 Mnemonic: br.i16, ldc.i8=opCode: 217 Mnemonic: ldc.i8, tne=opCode: 27 Mnemonic: tne, decv.u8=opCode: 180 Mnemonic: decv.u8, exit=opCode: 3 Mnemonic: exit, shl=opCode: 24 Mnemonic: shl, ldc.i3=opCode: 144 Mnemonic: ldc.i3, shr=opCode: 25 Mnemonic: shr, sub=opCode: 20 Mnemonic: sub, enter.u8=opCode: 191 Mnemonic: enter.u8, mul=opCode: 21 Mnemonic: mul, ldc.i32=opCode: 219 Mnemonic: ldc.i32, enter.u5=opCode: 112 Mnemonic: enter.u5, ldv.u3=opCode: 160 Mnemonic: ldv.u3, pop=opCode: 1 Mnemonic: pop, ldv.u8=opCode: 177 Mnemonic: ldv.u8, not=opCode: 12 Mnemonic: not, tge=opCode: 31 Mnemonic: tge, br.i5=opCode: 48 Mnemonic: br.i5, br.i8=opCode: 224 Mnemonic: br.i8, and=opCode: 13 Mnemonic: and, xor=opCode: 15 Mnemonic: xor, inc=opCode: 17 Mnemonic: inc, tgt=opCode: 29 Mnemonic: tgt, stv.u3=opCode: 168 Mnemonic: stv.u3, or=opCode: 14 Mnemonic: or, addv.u8=opCode: 176 Mnemonic: addv.u8, stv.u8=opCode: 178 Mnemonic: stv.u8, tle=opCode: 30 Mnemonic: tle, addv.u3=opCode: 152 Mnemonic: addv.u3, halt=opCode: 0 Mnemonic: halt, brf.i5=opCode: 80 Mnemonic: brf.i5, incv.u8=opCode: 179 Mnemonic: incv.u8, brf.i8=opCode: 227 Mnemonic: brf.i8, lda.i16=opCode: 213 Mnemonic: lda.i16, tlt=opCode: 28 Mnemonic: tlt, dup=opCode: 2 Mnemonic: dup}");
        

    }

}
