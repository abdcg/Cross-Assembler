public class Mnemonic extends Node {
        private int opCode ;
        private String name;


        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public Mnemonic() {

        }
        public Mnemonic(String name) {
            this.name=name;


        }
        public Mnemonic(int i, String string) {
			opCode = i;
			name = string;
		}
		public int getOpCode() {
            return opCode;
        }
        public void setOpCode(int opCode) {
            this.opCode = opCode;
        } 
        
        public String toString() 
        { 
        	return "opCode: "+opCode+" Mnemonic: "+ name;
        }

    }