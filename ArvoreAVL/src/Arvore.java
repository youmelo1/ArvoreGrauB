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
		return no.getNome();
	}

	private String maiorValor(No no) {
		while (no.getDireito() != null) {
			no = no.getDireito();
		}
		return no.getNome();
	}



	public No excluir(String nome, No no){
		
		int comparacao = nome.compareTo(raiz.getNome());


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
					no.setNome(maiorValorPelaEsquerda);


					no.setEsquerdo(excluir(maiorValorPelaEsquerda, no.getEsquerdo()));

				} else {

					String menorValorPelaDireita = menorValor(no.getDireito());
					no.setNome(menorValorPelaDireita);

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
			if(raiz.getNome()==nome) {
				raiz=null;
			}
		}else if(quant==2) {

			if(raiz.getNome()==nome) {
				if(raiz.getEsquerdo()==null) {
					raiz = raiz.getDireito();
				}else {
					raiz = raiz.getEsquerdo();
				}
			}else {
				if(raiz.getEsquerdo()!= null) {
					if(raiz.getEsquerdo().getNome()==nome) {
					raiz.setEsquerdo(vazio);
					}
				}else if(raiz.getDireito()!= null) {
					if(raiz.getDireito().getNome()==nome) {
					raiz.setDireito(vazio);
					}
				}
			}
		}


	}





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




	public void inserir(String  nome) {
		raiz = inserirDepois(nome, raiz);

	}


	public No inserirDepois(String nome, No no) {
		
		if(no!=null) {
			int comparacao = nome.compareTo(no.getNome());
			if(comparacao<0) {
				no.setEsquerdo(inserirDepois(nome, no.getEsquerdo()));
			}else if(comparacao>0) {
				no.setDireito(inserirDepois(nome, no.getDireito()));
			}else {
				return no;
			}
		}else {
			no = new No(nome);
		}
		

		no = fazerRotacoes(no);
		return no;
	}


	public No procurar(String nome, No no) {

		
		if(no!=null) {
			int comparacao = nome.compareTo(no.getNome());
			if(comparacao==0) {
				System.out.println("Valor est� na �rvore :)");
				System.out.println();
				return no;
			}
			if(comparacao>0) {
				return procurar(nome, no.getDireito());
			}else {
				return procurar(nome, no.getEsquerdo());

			}
		}
		System.out.println("Valor n�o est� na �rvore :(");
		
		return null;
		
	}

	public List<String> listaNomes(String prefixo) {
        List<String> nomes = new ArrayList<>();
        procurarNomes(raiz, prefixo, nomes);
        return nomes;
    }

    public void procurarNomes(No no, String prefixo, List<String> nomes) {
    	
    	
        if (no == null) {
            return;
        }

        if (no.getNome().startsWith(prefixo)) {
        	nomes.add(no.getNome());
        }

        if (prefixo.compareTo(no.getNome()) <= 0) {
            procurarNomes(no.getEsquerdo(), prefixo, nomes);
        }

        procurarNomes(no.getDireito(), prefixo, nomes);
    }


	public void emOrdem(No n) {
		if(n != null) {
			emOrdem(n.getEsquerdo());
			System.out.print(n.getNome()+" ");
			emOrdem(n.getDireito());
		}
	}
	public void preOrdem(No n) {
		if(n != null) {
			System.out.print(n.getNome()+" ");
			preOrdem(n.getEsquerdo());
			preOrdem(n.getDireito());
		}
	}
	public void posOrdem(No n) {
		if(n != null) {
			posOrdem(n.getEsquerdo());
			posOrdem(n.getDireito());
			System.out.print(n.getNome()+" ");
		}	
	}

	public void imprimirEmOrdem() {
		emOrdem(raiz);
		System.out.println();
	}

	public void imprimirPreOrdem() {
		preOrdem(raiz);
		System.out.println();
	}

	public void imprimirPosOrdem() {
		posOrdem(raiz);
		System.out.println();
	}



}
