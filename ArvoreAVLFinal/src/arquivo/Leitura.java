package arquivo;
import java.io.IOException;
import java.util.Scanner;

import arvore.Arvore;

import java.io.File;

public class Leitura 
{   
     String[] nomes = new String[100];
     String[] cpf = new String[100];
     String[] data = new String[100];
     Gravador[] gravados = new Gravador[100];
    public Gravador[] read(File arq, Arvore nm, Arvore cp, Arvore dt) 
    {       
        File file = arq;
        
        Informacoes[] r = new Informacoes[100];
  
        int i = 0;
        try{
            Scanner sc = new Scanner(file);
           
            while(sc.hasNextLine())
            {   
                
                String leitura = sc.nextLine();
                // quebra os dados trazidos do arquivo dentro do array
                String[] a = leitura.split(";");
                // Armazena os 3 dados desejados para trabalhar nome, cpf, data
                Informacoes re = new Informacoes(a[0], a[1], a[2]);
                // Gravador vai receber e transformar cada informação de cada pessoa
                Gravador g = new Gravador(a[0], a[1], a[2], a[3], a[4]);
                gravados[i] = g;
                r[i] = re;
                nomes[i] = r[i].nome;
                cpf[i] = r[i].cpf;
                data[i] = r[i].data;
            
                String nome = r[i].nome;
                String cpf = r[i].cpf;
                String data = r[i].data;
                
                nm.inserir(nome, i);
                cp.inserir(cpf, i);
                dt.inserir(data, i);
                
                
                i++;
            }
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        } 

        return gravados;
    }

    public String retornaDados(int index) 
    {
        return ">"+gravados[index].nome + "; Cpf: "+ gravados[index].cpf + "; Rg: " + gravados[index].rg + "; Data de nascimento: "+ gravados[index].data+ "; Cidade natal: "+ gravados[index].cidade;
    }   
    
}