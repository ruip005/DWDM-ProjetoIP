
import java.util.Scanner;

public class Mensagens {
    Scanner isScan = new Scanner(System.in);
    public void welcome(){
        System.out.println("#######################################");
        System.out.println("##                                   ##");
        System.out.println("##          Bem vindo ao IPV         ##");
        System.out.println("##                                   ##");
        System.out.println("#######################################");
        System.out.println("Pressiona enter para continuar");
        isScan.nextLine();
        menu();
    }
public static void invalido(){

}

    public void menu() {
        while (true){
            System.out.println("#######################################");
            System.out.println("##                                   ##");
            System.out.println("## 1- Adicionar Aluno                ##");
            System.out.println("## 2- Candidatura a residência       ##");
            System.out.println("## 3- Atualizar Pontos               ##");
            System.out.println("## 4- Remover Aluno de BD            ##");
            System.out.println("## 5- Informação sobre um aluno      ##");
            System.out.println("## 6- Lista de quartos ocupados      ##");
            System.out.println("## 7- Atualizar ocupação de quartos  ##");
            System.out.println("## *-Sair                            ##");
            System.out.println("##                                   ##");
            System.out.println("#######################################");
            System.out.println("##                                   ##");
            System.out.println("##        Insere a sua opção         ##");
            System.out.println("##                                   ##");
            System.out.println("#######################################");
            char caso = isScan.next().charAt(0);
            if (caso == '*') {
                System.exit(0);
            } else {
            Logica logica = new Logica();
            logica.Logica(caso);

            }
        }
    }
}