import java.io.File;
import java.util.Scanner;

public class PrincipalArvore {
	public static void main(String[] args) {
		//InterfaceUsuario i = new InterfaceUsuario();
		File file = new File("C:\\Users\\55519\\Desktop\\GB\\ArvoreGrauB\\ArvoreAVL\\src\\test.txt");
		Arvore a = new Arvore();
		//i.mensagens();
		
		Leitura l = new Leitura();
		Gravador[] g =  l.read(file, a , 1);
		String c = l.retorna(0);
		System.out.println(c);

		for(Gravador gr : g)
		{   
			if(gr != null){
				System.out.println(gr.cpf);
			}
	
		}

		System.out.println(g[0].nome);

	

		
		
		
	}
}
