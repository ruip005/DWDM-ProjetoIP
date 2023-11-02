
import java.util.Scanner;

public class Mensagens {
    Scanner isScan = new Scanner(System.in);
    public void welcome(){
        Aluno.LoadData();
        Quartos.LoadData();
        System.out.println("#######################################");
        System.out.println("##                                   ##");
        System.out.println("##          Bem vindo ao IPV         ##");
        System.out.println("##                                   ##");
        System.out.println("#######################################");
        System.out.println("Pressiona enter para continuar");
        isScan.nextLine();
        menu();
    }

    public void menu() {
            System.out.println("########################################");
            System.out.println("##                                    ##");
            System.out.println("## 1 - Adicionar Aluno                ##");
            System.out.println("## 2 - Candidatura a residência       ##");
            System.out.println("## 3 - Atualizar Pontos               ##");
            System.out.println("## 4 - Remover Aluno de BD            ##");
            System.out.println("## 5 - Informação sobre um aluno      ##");
            System.out.println("## 6 - Lista de quartos ocupados      ##");
            System.out.println("## 7 - Atualizar ocupação de quartos  ##");
            System.out.println("## 8 - Salvar dados                   ##");
            System.out.println("## * - Sair                           ##");
            System.out.println("##                                    ##");
            System.out.println("########################################");
            System.out.println("##                                    ##");
            System.out.println("##         Insere a sua opção         ##");
            System.out.println("##                                    ##");
            System.out.println("########################################");

            Logica log = new Logica();
            String caso = isScan.nextLine();
            if (log.isNum(caso)) {
                log.Logica(caso.charAt(0));
            } else {
                System.out.println("Opção inválida");
                menu();
            }
    }

    public static void printAluno(Aluno aluno){
        System.out.println("#######################################");
        System.out.print(aluno);
        System.out.println("#######################################");
    }
}