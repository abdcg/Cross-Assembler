public class HexConverterTest {
        public static void main(String args[])
        {
            System.out.print("Test Hex Converter\n");
            System.out.print("File Created\n");
            String[] a=new String[2];
            a[0]="-h";

            Administrator admin=new Administrator(a);
            AssemblyUnit a1=new AssemblyUnit();
            LineStatement l1=new LineStatement();
            LineStatement l2=new LineStatement();
            LineStatement l3=new LineStatement();
            LineStatement l4=new LineStatement();
            Instruction instr=new Instruction();
            Instruction instr2=new Instruction();
            Instruction instr3=new Instruction();
            Instruction instr4=new Instruction();
            Mnemonic m1=new Mnemonic("pop");
            m1.setOpCode(1);
            Mnemonic m2=new Mnemonic("exit");
            m2.setOpCode(3);
            Mnemonic m3=new Mnemonic("teq");
            m3.setOpCode(Opcode.teq);
            instr.setMnemonic(m1);
            instr2.setMnemonic(m2);
            instr4.setMnemonic(m3);
            Directive d1=new Directive();
            d1.setName("Directive");
            d1.setStringOperand(new StringOperand());
            d1.setCode("044");
            instr3.setDirective(d1);
            l1.setInstruction(instr);
            l2.setInstruction(instr2);
            l3.setInstruction(instr3);
            l4.setInstruction(instr4);
            a1.push(l1);
            a1.push(l2);
            a1.push(l3);
            a1.push(l4);

            HexConverter h1=new HexConverter(a1,"Hex.exe",admin);
        }

    }

