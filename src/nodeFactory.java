public class nodeFactory 
{
	public Node getNode(String type)
	{
		switch(type)
		{
			case "mnemonic":
				return new Mnemonic();
			case "address":
				return new Address();
			case "position":
				return new Position();
			case "offset":
				return new Offset();
			case "label":
				return new Label();
			case "comment":
				return new Comment();		
		}
		
		return null;
	}

}