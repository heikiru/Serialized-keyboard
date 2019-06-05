import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serializer {
    
    private ObjectOutputStream output;

    public Serializer() {
        try {
            output = new ObjectOutputStream(new FileOutputStream("data_input.ser", true));
        } catch (IOException ioe){
            System.err.println("ERROR OPENING FILE.");
        }   
    }

    void addRecord(String text) {
        DataInput dataInput;
        try {
            dataInput = new DataInput(text);
            output.writeObject(dataInput);
        } catch (IOException ioe) {
            System.err.println("ERROR WRITING TO FILE.");
            return;
        }
    }

    void closeFile(){
        try {
            output.close();
        } catch (IOException ioe) {
            System.err.println("ERROR CLOSING FILE.");
            System.exit(1);
        }
    }
}