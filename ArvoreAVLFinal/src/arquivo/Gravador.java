package arquivo;
public class Gravador { //Objeto onde guardamos os atributos recebidos no csv
	 	String cpf;
	    String rg;
	    String nome;
	    String data;
	    String cidade;

	    public Gravador (String cpf, String rg, String nome, String data, String cidade){
	        this.cpf = cpf;
	        this.rg = rg;
	        this.nome = nome;
	        this.data = data;
	        this.cidade = cidade;
    }
}
