package construcao.model;

public class Tinta extends Produto{
	
	private String cor;
	private double rendimento;

	public Tinta(int id, String nome, int categoria, float preco, String cor,double rendimento) {
		super(id, nome, categoria, preco);
		this.cor = cor;
		this.rendimento = rendimento;
 	}
	
	
	
	
	public String getCor() {
		return cor;
	}




	public void setCor(String cor) {
		this.cor = cor;
	}




	public double getRendimento() {
		return rendimento;
	}




	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}




	public void visualizar() {
		super.visualizar();
		 System.out.println("Cor: " + cor);
		 System.out.println("Rendimento: " + rendimento + " L");
	}
	

}
