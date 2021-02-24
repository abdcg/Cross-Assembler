public class LineStatement extends Node{
	Label label;
	Instruction instruction;
	Comment comment;
	Directive dir;
	
	public LineStatement() {
		
	} 
	
	public LineStatement(Label label, Instruction instruction, Comment comment) {
		super();
		this.label = label;
		this.instruction = instruction;
		this.comment = comment;
	} 
	
	
	public LineStatement(Instruction instruction) 
	{ 
		//super(); 
		this.instruction = instruction;
	}
	
	public Label getLabel() {
		return label;
	}
	
	public void setLabel(Label label) {
		this.label = label;
	}
	
	public Instruction getInstruction() {
		return instruction;
	}
	
	public void setInstruction(Instruction instruction) {
		this.instruction = instruction;
	}
	
	public Comment getComment() {
		return comment;
	}
	
	public void setComment(Comment comment) {
		this.comment = comment;
	} 
	
	
	public Directive getDir() {
		return dir;
	}

	public void setDir(Directive dir) {
		this.dir = dir;
	}

	public String toString() {
		return "LineStatement [label=" + label + ", instruction=" + instruction + ", comment=" + comment + "]";
	}
	
	
}
