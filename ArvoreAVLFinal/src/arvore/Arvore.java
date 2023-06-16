package arvore;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Arvore {

	private No raiz;

	public Arvore() {
	}

	public No getRaiz() {
		return raiz;
	}
	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}

	public boolean arvoreVazia() {
		return raiz==null;
	}

	public int altura(No no) {
		return (no != null) ? no.getAltura() : 0;
	}

	public int fatorBalanceamento(No no) {
		return altura(no.getEsquerdo()) - altura(no.getDireito());
	}

	public void alturaNova(No no) {
		int maiorValor = Math.max(altura(no.getEsquerdo()), altura(no.getDireito()));
		no.setAltura(maiorValor + 1);
	}







	public String menorValor(No no){
		while(no.getEsquerdo() != null) {
			no = no.getEsquerdo();
		}
		return no.getInfo();
	}

	private String maiorValor(No no) {
		while (no.getDireito() != null) {
			no = no.getDireito();
		}
		return no.getInfo();
	}


/*
 	public No excluir(String nome, No no){
		
		int comparacao = nome.compareTo(raiz.getInfo());


		arvoreDuasFolhasOuMenos(nome);

		if (no == null) {
			return null;
		}


		if (comparacao<0) {
			no.setEsquerdo(excluir(nome, no.getEsquerdo()));

		} else if (comparacao>0) {
			no.setDireito(excluir(nome, no.getDireito()));

		} else {


			if (no.getEsquerdo() == null) {
				return no.getDireito();


			} else if (no.getDireito() == null) {
				return no.getEsquerdo();


			} else {


				if (no.getEsquerdo().getAltura() > no.getDireito().getAltura()) {

					String maiorValorPelaEsquerda = maiorValor(no.getEsquerdo());
					no.setInfo(maiorValorPelaEsquerda);


					no.setEsquerdo(excluir(maiorValorPelaEsquerda, no.getEsquerdo()));

				} else {

					String menorValorPelaDireita = menorValor(no.getDireito());
					no.setInfo(menorValorPelaDireita);

					no.setDireito(excluir(menorValorPelaDireita, no.getDireito()));

				}
			}
		}
		alturaNova(no);

		return fazerRotacoes(no);
	}


	public void arvoreDuasFolhasOuMenos(String nome) {
		int quant = tamanhoDaArvore(raiz);
		No vazio = null;

		
		

		if(quant==1) {
			if(raiz.getInfo()==nome) {
				raiz=null;
			}
		}else if(quant==2) {

			if(raiz.getInfo()==nome) {
				if(raiz.getEsquerdo()==null) {
					raiz = raiz.getDireito();
				}else {
					raiz = raiz.getEsquerdo();
				}
			}else {
				if(raiz.getEsquerdo()!= null) {
					if(raiz.getEsquerdo().getInfo()==nome) {
					raiz.setEsquerdo(vazio);
					}
				}else if(raiz.getDireito()!= null) {
					if(raiz.getDireito().getInfo()==nome) {
					raiz.setDireito(vazio);
					}
				}
			}
		}


	}
*/




	public int tamanhoDaArvore(No no) {
		if (no == null) {
			return 0;
		}

		int quantEsquerdo = tamanhoDaArvore(no.getEsquerdo());
		int quantDireito = tamanhoDaArvore(no.getDireito());

		return (1 + quantEsquerdo + quantDireito);


	}



	public No rotacaoSimplesEsquerda(No no) {
		No noDireito  = no.getDireito();
		no.setDireito(noDireito.getEsquerdo());
		noDireito.setEsquerdo(no);

		alturaNova(no);
		alturaNova(noDireito);

		return noDireito;
	}

	public No rotacaoSimplesDireita(No no) {
		No noEsquerdo  = no.getEsquerdo();
		no.setEsquerdo(noEsquerdo.getDireito());
		noEsquerdo.setDireito(no);


		alturaNova(no);
		alturaNova(noEsquerdo);

		return noEsquerdo;
	}


	public No rotacaoDuplaEsquerda(No no) {
		no.setDireito(rotacaoSimplesDireita(no.getDireito()));
		return rotacaoSimplesEsquerda(no);
	}

	public No rotacaoDuplaDireita(No no) {
		no.setEsquerdo(rotacaoSimplesEsquerda(no.getEsquerdo()));;
		return rotacaoSimplesDireita(no);
	}





	public No fazerRotacoes(No no) {

		if(fatorBalanceamento(no) <-1) {

			if(fatorBalanceamento(no.getDireito()) < 0) {
				no = rotacaoSimplesEsquerda(no);

			}else {
				no = rotacaoDuplaEsquerda(no);
			}

		}

		if(fatorBalanceamento(no) >1) {

			if(fatorBalanceamento(no.getEsquerdo()) > 0) {
				no = rotacaoSimplesDireita(no);

			}else {
				no = rotacaoDuplaDireita(no);
			}

		}

		alturaNova(no);
		return no;
	}




	public void inserir(String  nome, int index) {
		raiz = inserirDepois(nome, raiz, index);

	}


	public No inserirDepois(String info, No no,  int index) {
		
		if(no!=null) {
			int comparacao = info.compareTo(no.getInfo());
			if(comparacao<0) {
				no.setEsquerdo(inserirDepois(info, no.getEsquerdo(), index));
			}else if(comparacao>0) {
				no.setDireito(inserirDepois(info, no.getDireito(), index));
			}else {
				return no;
			}
		}else {
			no = new No(info, index);
		}
		

		no = fazerRotacoes(no);
		return no;
	}


	
	
	public int procurarPeloCPF(String cpf, No no) {   //Busca cpfs na arvore recursivamente

		 
		if(no!=null) {
			int comparacao = cpf.compareTo(no.getInfo());
			if(comparacao==0) {
				//retorna o indice do nó cujo CPF é o mesmo que o usuário inseriu
				return no.getIndex();
			}
			if(comparacao>0) {
				return procurarPeloCPF(cpf, no.getDireito());
			}else {
				return procurarPeloCPF(cpf, no.getEsquerdo());

			}
		}
		
		
		return -1;
		
	}

	public List<Integer> listaIndices(String prefixo) { //método para retornar a lista de índices que o procurarNomesPorPrefixo achou
        List<Integer> indices = new ArrayList<>();
        procurarNomesPorPrefixo(raiz, prefixo, indices);
        return indices;
    }

    public void procurarNomesPorPrefixo(No no, String prefixo, List<Integer> indices) { //Realiza uma busca por prefixos(nomes) 
    	
    	
        if (no == null) {
            return;
        }

        if (no.getInfo().startsWith(prefixo)) {
		//se o nó tiver o mesmo começo igual ao prefixo, adiciona o indice da pessoa na lista
        	indices.add(no.getIndex());
        }

        if (prefixo.compareTo(no.getInfo()) <= 0) {
        	procurarNomesPorPrefixo(no.getEsquerdo(), prefixo, indices);
        }

        procurarNomesPorPrefixo(no.getDireito(), prefixo, indices);
    }


   
    public List<Integer> listaIndicesDatas(String dataInicio, String dataFim){//método para retornar a lista de índices que o procurarDatas achou
    	List<Integer> indices = new ArrayList<>();
    	procurarDatas(dataInicio, dataFim, raiz, indices);
    	return indices;
    }
    
    
//busca as datas comparando elas no formato de string utiliznado o metodo compareTo
    public void procurarDatas(String dataInicio, String dataFim, No no, List<Integer> indices) {
    	String dataI = inverteDatas(dataInicio);
    	String dataF = inverteDatas(dataFim);
    	
    	if (no == null) {
            return;
        }
    	
    	if (no.getInfo().compareTo(dataI) >= 0 && no.getInfo().compareTo(dataF)<=0) {
		//se tiver no intervalo, adiciona o indice da pessoa na lista
        	indices.add(no.getIndex());

    	}
    	
    	if (no.getInfo().compareTo(dataI)>0) {
    		procurarDatas(dataInicio, dataFim, no.getEsquerdo(), indices);
    	}
    	
    	 if (no.getInfo().compareTo(dataF)<0) {
    	        procurarDatas(dataInicio, dataFim, no.getDireito(), indices);
    	 }
    }
    
   
    public String inverteDatas(String data) {
    	String f = "";
        for(int x = 0; x<1; x++)
        {
	//recebe uma String no formato DD/MM/AAAA
	//inverte as datas para ser possivel comparar-las com o compare
        // Inverte deixando na ordem ano/mes/dia
            f += data.charAt(6);
            f+= data.charAt(7);
              f+= data.charAt(8);
                f+= data.charAt(9);
              f+= data.charAt(5);
              f+= data.charAt(3);
                f+= data.charAt(4);
                f+= data.charAt(2);
                f+= data.charAt(0);
                f+= data.charAt(1);
        }
		return f;
	//retorna a data no novo formato
    }
    
    
    
    
}
