package arquivo;
import java.io.IOException;
import java.util.Scanner;

import arvore.Arvore;

import java.io.File;

public class Leitura 
{   
     // Arrays que armazenarão dados provenientes do arquivo de dados
     String[] nomes = new String[100];
     String[] cpf = new String[100];
     String[] data = new String[100];
     Gravador[] gravados = new Gravador[100];
     
    public Gravador[] read(File arq, Arvore cp, Arvore nm, Arvore dt) 
    {       
        File file = arq;
        
        Informacoes[] r = new Informacoes[100];
  
        int i = 0;
        try{
            Scanner sc = new Scanner(file);
           
            while(sc.hasNextLine())
            {   
                // Scanner que vai ler as linhas do 
                String leitura = sc.nextLine();
                // quebra os dados trazidos do arquivo dentro do array, separando por ';'
                String[] a = leitura.split(";");
                // Armazena os 3 dados desejados para trabalhar nome, cpf, data
                Informacoes re = new Informacoes(a[0], a[2], a[3]);
                // Gravador vai receber e transformar cada informação de cada pessoa
                Gravador g = new Gravador(a[0], a[1], a[2], a[3], a[4]);
                gravados[i] = g;
                r[i] = re;
                nomes[i] = r[i].nome;
                cpf[i] = r[i].cpf;
                data[i] = r[i].data;
                
                String u = data[i];
                String f = "";
                 // Aqui refatoramos a entrada de datas, a fim de formata-la como ANO/MES/DIA a fim de poder fazer comparações como String
                for(int x = 0; x<1; x++)
                {
                    f += u.charAt(6);
                    f+= u.charAt(7);
                      f+= u.charAt(8);
                        f+= u.charAt(9);
                      f+= u.charAt(5);
                      f+= u.charAt(3);
                        f+= u.charAt(4);
                        f+= u.charAt(2);
                        f+= u.charAt(0);
                        f+= u.charAt(1);
                }
                
                String nome = r[i].nome;
                String cpf = r[i].cpf;
                
                // Inserção nas instancias de arvore
                nm.inserir(nome, i);
                cp.inserir(cpf, i);
                dt.inserir(f, i);
                
                
                i++;
            }
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        } 

        return gravados;
    }
     
     // Metodo que retorna os dados das respectiva pesquisas
    public String retornaDados(int index) 
    {
        return ">"+gravados[index].nome + "; Cpf: "+ gravados[index].cpf + "; Rg: " + gravados[index].rg + "; Data de nascimento: "+ gravados[index].data+ "; Cidade natal: "+ gravados[index].cidade;
    }   
    
}
