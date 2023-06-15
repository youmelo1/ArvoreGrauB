package ui;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import arquivo.Gravador;
import arquivo.Leitura;
import arvore.Arvore;

public class Menu {

		private Scanner sc =  new Scanner(System.in);
		private File file = new File("E:\\Usuários\\User1\\Desktop\\prog exer\\Java\\Java eclipse\\ArvoreAVLFinal\\src\\test.txt");
		private Arvore arvoreNomes = new Arvore();
		private Arvore arvoreCPF = new Arvore();
		private Arvore arvoreData = new Arvore();
		private Leitura l = new Leitura();
		private Gravador[] g =  l.read(file, arvoreNomes, arvoreCPF, arvoreData);
		// O retorno da função retorna é o array de objetos 
		// Cada nodo vai ter um indice referente a sua posição no array
		
		
		
		public void menu(){
			System.out.println("Árvore binária de busca, para escolher uma funcionalidade, é preciso digitar o número da opção.");
			opcoes();
			
			int escolha = sc.nextInt();
			
			while(escolha != 0) {
				switch(escolha) {
				case 1:
					consultarCPF();
					opcoes();
					escolha = sc.nextInt();
					break;
					
				case 2:
					consultarPorPrefixo();
					opcoes();
					escolha = sc.nextInt();
					break;
					
				case 3:
					consultarPorData();
					opcoes();
					escolha = sc.nextInt();
					break;
					
				default:
					System.out.println("Essa não é uma opção disponível!");
					opcoes();
					escolha = sc.nextInt();
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		public void opcoes() {
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("1) Consultar pessoa pelo seu CPF");
			System.out.println("2) Consultar todas as pessoas por um prefixo");
			System.out.println("3) Consultar todas as pessoas por um intervalo de data de nascimento");
			System.out.println("0) Sair");
			System.out.println("-----------------------------------------------------------------------");
		}
		
		public void consultarCPF() {
			System.out.println("Qual seria o CPF da pessoa?: ");
			sc.nextLine();
			String cpf = sc.nextLine();
			int index = arvoreCPF.procurarPeloCPF(cpf, arvoreCPF.getRaiz());
			
			if(index>=0) {
				System.out.println(l.retornaDados(index));
			}else {
				System.out.println("CPF não está na árvore :(");
			}
			
		}
		
		public void consultarPorPrefixo() {
			System.out.println("Qual seria o prefixo para buscar as pessoas?: ");
			sc.nextLine();
			String prefixo = sc.nextLine();
			List<Integer> indicesEncontrados = arvoreNomes.listaIndices(prefixo);
			
			if(indicesEncontrados.size() != 0) {
				for(int index : indicesEncontrados) {
					System.out.println(l.retornaDados(index));
				}
			}else {
				System.out.println("Nenhuma pessoa foi encontrada começando com '" + prefixo + "':");
			}
		}
		
		public void consultarPorData(){
			System.out.println("Para não quebrar o código, é necessário que se insira as datas pelo formato DD/MM/AAAA");
			System.out.println("Qual seria a data inicial do intervalo?: ");
			sc.nextLine();
			String dataInicio = sc.nextLine();
			System.out.println("Qual seria a data final do intervalo?: ");
			String dataFim = sc.nextLine();
			
			List<Integer> indicesEncontrados = arvoreData.listaIndicesDatas(dataInicio, dataFim);
			
			if(indicesEncontrados.size() != 0){
				for(int index : indicesEncontrados) {
					System.out.println(l.retornaDados(index));
				}
			}else{
				System.out.println("Nenhuma pessoa foi encontrada com a data de nascimento entre as datas inseridas");
			}
			
			
		}
		
		
		
		
		
		
		
		
}
