package hey;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
public class Main {
	public static void main(String[] args){
		

	    StringToChar sc = new StringToChar();
		Frame f = new Frame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000, 1000);
		f.setVisible(true);

		String p= f.get_Whole_textArea();
		
		
		ArrayList<Character> teste= sc.stringToChar(p);
		
		Pangrama pan = f.getSelectedPan();
		
		pan.checkPangrama(teste);
		System.out.println(pan.getErros());

	}
}