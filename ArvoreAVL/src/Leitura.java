import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Leitura 
{
    public res[] read(File arq, Arvore b, int cod) 
    {       
        File file = arq;
        
        res[] r = new res[100];
        String[] nomes = new String[100];
        String[] cpf = new String[100];
        String[] data = new String[100];
        int i = 0;
        try{
            Scanner sc = new Scanner(file);
           
            while(sc.hasNextLine())
            {   
                
                String leitura = sc.nextLine();
                String[] a = leitura.split(";");
                res re = new res(a[0], a[1], a[2]);
                r[i] = re;
                nomes[i] = r[i].nome;
                cpf[i] = r[i].cpf;
                data[i] = r[i].data;
                System.out.println(nomes[i]);
                System.out.println(r[i].nome);
                System.out.println(r[i].cpf);
                System.out.println(r[i].data);
                if(cod == 1){
                    b.inserir(r[i].nome);
                } else if(cod == 2){
                    b.inserir(r[i].cpf);
                } else {
                    b.inserir(r[i].data);
                }
            }
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        } 

        return r;
    }

}