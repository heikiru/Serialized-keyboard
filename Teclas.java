import java.awt.event.KeyEvent;

public class Teclas{
	private int id;
	private String value;
	private int vkCode;

	private final String[] nomesTeclas = {"~", "1", "2", "3", "4", "5", "6", "7", "8", "9",
		"0", "-", "+", "Backspace", "Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P",
		"[", "]", "\\", "Caps", "A", "S", "D", "F", "G", "H", "J", "K", "L", ":", "*",
		"Enter", "Shift", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "?", "^", " ", "<",
		"v", ">"};
	private final int[] vkTeclas = {222, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 45, 61, 8, 
			9, 81, 87, 69, 82, 84, 89, 85, 73, 79, 80, 91, 93, 92, 20, 65, 83, 68,
			70, 71, 72, 74, 75, 76, 59, 8, 10, 16, 90, 88, 67, 86, 66, 78, 77, 44,
			46, 47, 38, 32, 37, 40, 39};

	public Teclas(int i, String v, int vk){
		this.id = i;
		this.value = v;
		this.vkCode = vk;
	}

	public int getIDbyVk(int vk){
		int id = 0;
		for(int i=0; i<vkTeclas.length; i++){
			if(vkTeclas[i] == vk){ id = i; }
		}
		return id;
	}
}