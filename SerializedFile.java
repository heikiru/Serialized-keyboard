import java.io.File;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class SerializedFile {
    
    private boolean enterPressed;
    private Scanner scan = new Scanner(System.in);
    File ser;

    public void createFile() { // Responsible for creating file. Verifies if it exists!
        System.out.println("Choose a place to save your progress! ");
        String path = analysePath(scan.nextLine()); // Gets path
        ser = new File(ser);
    }

    public void recordProgress(){
        SetClass objForHere = new SetClass();
        if(ser.exists() {
            Sytem.out.printf();
        } else {

        }
    }

    private class KeyHandler implements KeyAdapter {
        public void keyPressed(KeyEvent e){
            if (e.getKeyCode() == 13) // Enter
                enterPressed = true;
        }
    }
}