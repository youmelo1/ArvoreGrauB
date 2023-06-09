public class No {
	
	private int altura;
	private No esquerdo, direito;
	private String nome;
	
	public No(String nome) {
		this.nome = nome;
		altura = 1;
		esquerdo = null;
		direito = null;
	}
	
	public String getNome() {
		return nome;
	}
	public int getAltura() {
		return altura;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public No getEsquerdo() {
		return esquerdo;
	}
	public void setEsquerdo(No esquerdo) {
		this.esquerdo = esquerdo;
	}
	public No getDireito() {
		return direito;
	}
	public void setDireito(No direito) {
		this.direito = direito;
	}



	
	
	
}
