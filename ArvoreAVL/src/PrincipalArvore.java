import java.io.File;
import java.util.Scanner;

public class PrincipalArvore {
	public static void main(String[] args) {
		//InterfaceUsuario i = new InterfaceUsuario();
		File file = new File("C:\\Users\\55519\\Desktop\\GB\\ArvoreGrauB\\ArvoreAVL\\src\\test.txt");
		Arvore nomes = new Arvore();
		Arvore cpf = new Arvore();
		Arvore data = new Arvore();
		//i.mensagens();
		
		Leitura l = new Leitura();
		Gravador[] g =  l.read(file, nomes, cpf, data);
		// O retorno da função retorna é o array de objetos 
		// Cada nodo vai ter um indice referente a sua posição no array
		String c = l.retorna(2);
		System.out.println(c);

		for(Gravador gr : g)
		{   
			if(gr != null){
				System.out.println(gr.cpf);
			}
	
		}

		System.out.println(g[2].nome);

	

		
		
		
	}
}
