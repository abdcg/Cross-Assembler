public class Instruction extends Node {
	Mnemonic mnemonic;
	Operand operand;
	Directive directive;

	public Directive getDirective() {
		return directive;
	}

	public void setDirective(Directive directive) {
		this.directive = directive;
	}

	public Instruction() {
		mnemonic = new Mnemonic();
		operand = new Operand();
	}
	
	public Mnemonic getMnemonic() {
		return mnemonic;
	}
	public void setMnemonic(Mnemonic mnemonic) {
		this.mnemonic = mnemonic;
	}
	
	public Operand getOperand() {
		return operand;
	}
	
	public void setOperand(Operand operand) {
		this.operand = operand;
	}
	
	public Instruction(Mnemonic mnemonic, Operand operand) {
		super();
		this.mnemonic = mnemonic;
		this.operand = operand;
	}

	public Instruction(Mnemonic mnemonic) {
		super();
		this.mnemonic = mnemonic;
	}
	
	public String toString() {
		if(directive != null)
		{
			return "Instruction [directive=" + directive + "]";
		}
		
		if(operand !=null) {
			return "Instruction [mnemonic=" + mnemonic + ", operand=" + operand + "]";
		}
		//System.out.print(operand);
		return "Instruction [mnemonic=" + mnemonic + "]";
	}
	
}