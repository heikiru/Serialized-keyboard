import java.io.Serializable;

public class DataInput implements Serializable {
    
    private String whatsWritten; // Needs a class to serialize and another to deserialize!

    public DataInput(){ 
        this.whatsWritten = "";
    }

    public DataInput(String s){
        setWhatsWritten(s);
    }

    public void setWhatsWritten(String s){
        whatsWritten = s;
    }
    
    public String getWhatsWritten() {
	    return whatsWritten;
	}
}