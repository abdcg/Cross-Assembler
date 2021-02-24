public class Position extends Node {
    // private fields holding the location of the error in line, column format
    private int line;
    private int column;

    public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	//constructor
     public Position( int line) 
     { 
    	 this.line=line;
     }  
     
     //static method to create position
     
     public Position() {
		// TODO Auto-generated constructor stub
	}

	public static Position createLinePosition(int line) 
     { 
    	 return new Position(line);
     }
    /*
    // constructor
    public Position(int line, int column) {
        this.line = line;
        this.column = column;
    }
    

    //public static method that creates a position object
    public static Position create(int line, int column) {
        return new Position(line, column);
    }
    */

    //returns line of position
    public int getLineNumber() {
        return this.line;
    }

    //return column number of position
    public int getColumnNumber() {
        return this.column;
    }

    //prints the position object in nice format
    public String toString() {
        return ("[" + getLineNumber() + "," + getColumnNumber() + "]");
    }

}