
public class Token1 
{
	private Mnemonic mnem; 
	private Address address; 
	private Position position; 
	private Offset offset; 
	private Label label;
	private Comment comment;
	private Operand operand;
	
	
	public Token1() {} 
	
	public void setMnem(Mnemonic mnem) 
	{ 
		this.mnem = mnem;
	} 
	public Mnemonic getMnemonic() 
	{ 
		return mnem;
	} 
	
	public void setAddress( Address address) 
	{ 
		this.address = address;
	}
	public Address getAddress() 
	{ 
		return address;
	} 
	
	public void setPosition(Position position) 
	{ 
		this.position = position;
	} 
	public Position getPosition() 
	{ 
		return position;
	} 
	
	public void setOffset(Offset offset) 
	{ 
		this.offset =offset;
	} 
	public Offset getOffset() 
	{ 
		return offset;
	} 
	
	public void setLabel(Label label) 
	{ 
		this.label = label;
	}
	public Label getLabel() 
	{ 
		return label;
	}
	
	public void setComment(Comment comment) 
	{ 
		this.comment = comment;
	}
	public Comment getComment() 
	{ 
		return comment;
	}  
	
	public void setOperand(Operand operand) 
	{ 
		this.operand = operand;
	} 
	public Operand getOperand() 
	{ 
		return operand;
	}
	public String toString() 
	{ 
		return "[Mnemonic: "+mnem+"] [Operand: "+operand+"] [Address: "+address+"] [position: "+position+"] [Offset: "+offset+"] [Label: "+label+"] [Comment: "+comment+"]";
	}
	
}
