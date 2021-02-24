public class SourceFile {
    
	String file_name; // for the file name
    String extension_type; // for the extension 

    public SourceFile(String FileName, String ExtensionType) // constructor
    {

        file_name = FileName;
        extension_type = ExtensionType;

    }

    public String getFile_name() { // gets the file name
        return file_name;
    }

    public String getExtension_type(){ // gets the extenstion type
        return extension_type;
    }

    public void setFile_name(String file_name) { // sets file name 
        this.file_name = file_name;
    }
    public void setExtension_type(String extension_type) { // sets extension type 
        this.extension_type = extension_type;
    }
    public String toString(){
        return "filename: "+file_name+" extension: "+extension_type;
    }
}
