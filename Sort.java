import java.util.Random;

public class Sort {
	
	private String[] setas = {"^",">","<","v"};
	private Random random;
	
	public String random_char() {
		random = new Random();
		int number = random.nextInt(4);
		System.out.println(setas[number]);
		return setas[number];
	}
	/*
	public static void main(String[] args) {
		Sort s = new Sort();
		s.random_char();
	}*/
}