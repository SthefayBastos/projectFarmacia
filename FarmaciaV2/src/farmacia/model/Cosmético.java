package farmacia.model;

public class Cosmético extends Produto {

	private String fragancia;
	
	public Cosmético(int id, int tipo, String nome, double preco, String fragancia) {
		super(id, tipo, nome, preco);
		this.fragancia = fragancia;
	}

	public String getFragancia() {
		return fragancia;
	}

	public void setFragancia(String fragancia) {
		this.fragancia = fragancia;
	}
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Tipo da fragância: " + this.fragancia);
	}
	
}
