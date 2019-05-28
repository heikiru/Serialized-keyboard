import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serializer {
    
    private ObjectOutputStream output;
    private Frame frame;

    void openFile(){
        try {
            output = new ObjectOutputStream(new FileOutputStream("data_input.ser"));
        } catch (IOException ioe){
            System.err.println("ERROR OPENING FILE.");
        }   
    }

    void addRecord(){
        DataInput dataInput;
        try {
            dataInput = new DataInput(frame.get_Whole_textArea);
            output.writeObject(dataInput);
        } catch (IOException ioexc) {
            System.err.println("ERROR WRITING TO FILE.");
            return;
        }
    }

    void closeFile(){
        try {
            if (output != null)
                output.close();
        } catch (IOException exc) {
            System.err.println("ERROR CLOSING FILE.");
            System.exit(1);
        }
    }
}
