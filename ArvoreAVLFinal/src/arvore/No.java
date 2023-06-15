package arvore;
public class No {
	
	private int altura, index;
	private No esquerdo, direito;
	private String info;
	
	public No(String info, int index) {
		this.info = info;
		altura = 1;
		esquerdo = null;
		direito = null;
		this.index = index;
	}
	
	public String getInfo() {
		return info;
	}
	public int getAltura() {
		return altura;
	}
	public void setInfo(String info) {
		this.info = info;
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

	public int getIndex() {
		return index;
	}

	
	
	
}
