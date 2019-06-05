import java.util.ArrayList;
public class Pangrama {
	private ArrayList<Character> letras;
	private int erros;
	public Pangrama(ArrayList<Character> letras, int erros){
		this.letras= letras;
		this.erros=erros;
	}
	
	public ArrayList<Character> getLetras() {
		return letras;
	}

	public void setLetras(ArrayList<Character> letras) {
		this.letras = letras;
	}

	public int getErros() {
		return erros;
	}

	public void setErros(int erros) {
		this.erros = erros;
	}

	public boolean checkPangrama(ArrayList<Character> tentativa){
		boolean correto=true;
		char c1,c2=0;
		int n = 0;
		
		while(n<letras.size()) {
			
			c1= letras.get(n);
			if(n<tentativa.size()) {
				c2= tentativa.get(n);}
				else { 
					while(n<(letras.size())-1) { 
						this.erros++; 
						n++; }
					}
			
		if(c1!=c2) {
			correto= false;
			this.erros++;
		}else{
			correto= true;
			}
		n++;
		}if(tentativa.size()> n) {
			while(tentativa.size()>n) {
			this.erros++;
			n++;
			}
		}
		n=0;
		return correto;
	}

}