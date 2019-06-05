public class Teclas{
	private int id;
	private String value = "";
	private int vkCode;

	public Teclas(int i, String v, int vk){
		this.id = i;
		this.value = v;
		this.vkCode = vk;
	}
	public Teclas(){
		this.id = 999;
		this.value = "none";
		this.vkCode = 999;
	}

	public String getNome(){
		return value;
	}
}