import java.util.Scanner;

public class InterfaceUsuario 
{

    public void mensagens(){
        int valor = 0;
        Scanner scanner = new Scanner(System.in);
        Arvore a = new Arvore();
        while(valor != 7){
            System.out.println("###Digite:\n 1 para inserir valor\n 2 para excluir valor\n 3 para acessar modos de impressão da arvore\n 4 para procurar valor na arvore\n 7 para sair\n -------------------------------------------------------");
            valor = scanner.nextInt();
            while(valor > 4 || valor < 1)
            {
            System.out.println("###Digite:\n 1 para inserir valor\n 2 para excluir valor\n 3 para acessar modos de impressão da arvore\n 4 para procurar valor na arvore\n 7 para sair\n -------------------------------------------------------");
            valor = scanner.nextInt();
            }
        String input;
        if(valor == 1)
        {
            System.out.println("###Digite o valor que deseja inserir na árvore");
            scanner.nextLine();
            input = scanner.nextLine();
            
            a.inserir(input);
        } else if(valor == 2){
            System.out.println("###Digite o valor que deseja excluir da árvore");
            scanner.nextLine();
            input = scanner.nextLine();
            a.excluir(input, a.getRaiz());
        } else if(valor == 3){
            int selec;
            System.out.println("###Digite:\n 1 para ordem\n 2 para pre ordem\n 3 para pos ordem\n");
            selec = scanner.nextInt();
            while(selec > 3 || selec < 1)
            {
                System.out.println("###Digite:\n 1 para ordem\n 2 para pre ordem\n 3 para pos ordem\n");
                selec = scanner.nextInt();
            }
            if(selec == 1)
            {
                a.imprimirEmOrdem();
            } else if(selec == 2)
            {
                a.imprimirPreOrdem();
            } else if(selec == 3){
                a.imprimirPosOrdem();
            }
        } else if(valor == 4){
            String proc;
            System.out.println("###Digite um valor para procurar na árvore");
            scanner.nextLine();
            proc = scanner.nextLine();
            a.procurar(proc, a.getRaiz());
        }
        }
        

   }
}
