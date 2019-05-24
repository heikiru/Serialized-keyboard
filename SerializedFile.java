import java.io.File;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SerializedFile {
    
    private boolean enterPressed;
    private Scanner scan = new Scanner(System.in);
    File ser;

    public void createFile() { // Responsible for creating file. Verifies if it exists!
        System.out.println("Choose a place to save your progress ");
        String path = analysePath(scan.nextLine()); // Gets path
        ser = new File(path);
    }

    public void recordProgress(){
        SetClass setter = new SetClass();
        if(enterPressed){
            if(ser.exists()){
                try {
                    while(scan.hasNext()) {
                        setter.setWords(scan.next());
                    }
                } catch (NoSuchElementException nsee){
                    System.err.println("CANNOT USE ELEMENT WRITTEN");
                }
            } else {
                System.err.println("CANNOT ACCESS FILE. PLEASE CREATE ONE");
            }
        }
    }

    public void closeFile(){
        if(ser != null){
            ser.close();
        }
    }

    private class KeyHandler implements KeyAdapter {
        public void keyPressed(KeyEvent e){
            if (e.getKeyCode() == 13) // Enter
                enterPressed = true;
        }
    }
}
