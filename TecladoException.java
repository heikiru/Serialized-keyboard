public class TecladoException extends Exception {
	
	private String msg;

	public TecladoException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public String toString() {
		return msg;
	}
}

// try{

// }catch(TecladoException e){
// 	e.toString();
// 	e.getMessage();
// }