import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserializer {
    private ObjectInputStream input;
    public Deserializer() {
        try {
            input = new ObjectInputStream(new FileInputStream("data_input.ser"));
        } catch(IOException ioException) {
            System.err.println("ERROR OPENING FILE.");
        } 
    } 

    public void readRecords(){
        DataInput dataInput;
        System.out.printf("%-10s\n", "Text ");

        try { 
            while (true){
                dataInput = ( DataInput ) input.readObject();
            System.out.printf("%-12s\n", dataInput.getWhatsWritten());
            }
        }
        catch ( EOFException endOfFileException ) {
            return; 
        } 
        catch ( ClassNotFoundException classNotFoundException ) {
            System.err.println("UNABLE TO CREATE OBJECT.");
        } 
        catch ( IOException ioException ) {
            System.err.println("ERROR DURING READING FROM FILE.");
        } 
    } 

    public void closeFile(){
        try {
            if (input != null)
            input.close();
            System.exit(0);
        } // end try
        catch ( IOException ioException )
        {
            System.err.println("ERROR CLOSING FILE.");
            System.exit(1);
        }
    }
} 
