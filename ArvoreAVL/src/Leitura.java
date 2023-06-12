import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Leitura 
{   
     String[] nomes = new String[100];
     String[] cpf = new String[100];
     String[] data = new String[100];
     Gravador[] gravados = new Gravador[100];
    public Gravador[] read(File arq, Arvore b, int cod) 
    {       
        File file = arq;
        
        res[] r = new res[100];
  
        int i = 0;
        try{
            Scanner sc = new Scanner(file);
           
            while(sc.hasNextLine())
            {   
                
                String leitura = sc.nextLine();
                // quebra os dados trazidos do arquivo dentro do array
                String[] a = leitura.split(";");
                // Armazena os 3 dados desejados para trabalhar nome, cpf, data
                res re = new res(a[0], a[1], a[2]);
                // Gravador vai receber e transformar cada informação de cada pessoa
                Gravador g = new Gravador(a[0], a[1], a[2], a[3]);
                gravados[i] = g;
                r[i] = re;
                nomes[i] = r[i].nome;
                cpf[i] = r[i].cpf;
                data[i] = r[i].data;
                //System.out.println(nomes[i]);
                //System.out.println(r[i].nome);
                //System.out.println(r[i].cpf);
                //System.out.println(r[i].data);
                String nome = r[i].nome;
                String cpf = r[i].cpf;
                String data = r[i].data;
                
                if(cod == 1){
                   
                    b.inserir(nome);
                } else if(cod == 2){
                    b.inserir(cpf);
                } else {
                    b.inserir(data);
                }
                //System.out.println(b.getRaiz());
                i++;
            }
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        } 

        return gravados;
    }

    public String retorna(int index) 
    {
        return "Nome:"+ gravados[index].nome + "cpf:"+ gravados[index].cpf + "Rg:" + gravados[index].rg + "data:"+ gravados[index].data;
    }   

}