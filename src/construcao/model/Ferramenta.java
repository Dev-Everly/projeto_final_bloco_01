package construcao.model;

public class Ferramenta extends Produto {
	
	private String marca;

	public Ferramenta(int id, String nome, int categoria, float preco, String marca) {
		super(id, nome, categoria, preco);
		this.marca = marca;
 	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void visualizar() {
		super.visualizar();
		System.out.printf("Marca: %s\n", this.marca);
	}
	
	
	

}
