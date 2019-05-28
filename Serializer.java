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
        String written = frame.getTextArea().getText();
    }

    void closeFile(){

    }
}