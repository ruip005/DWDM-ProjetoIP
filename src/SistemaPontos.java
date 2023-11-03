import java.util.Scanner;

public class SistemaPontos {
    Mensagens msg = new Mensagens();
    Scanner iscan = new Scanner(System.in);

    public void sistemaPontos(int numeroAluno) {
        Aluno aluno = Aluno.getAluno(numeroAluno);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            msg.menu();
            return;
        }

        System.out.println("#########################");
        System.out.println("##                     ##");
        System.out.println("## 1-Remover Pontos    ##");
        System.out.println("## 2-Adicionar Pontos  ##");
        System.out.println("##                     ##");
        System.out.println("#########################");
        String caso = iscan.nextLine();
        while (!Logica.isNum(caso)) {
            System.out.println("Número inválido, insira novamente:");
            caso = iscan.nextLine();
        }
        switch (caso.charAt(0)) {
            case '1':
                while (true) {
                    System.out.println("O aluno tem " + aluno.getPontos() + " pontos.");
                    System.out.println("Que tipo de serviço deseja utilizar?");
                    System.out.println("1- Sala de convivio (3 pontos) ");
                    System.out.println("2- Lavandaria (2 pontos)           ");
                    System.out.println("3- Limpeza de Quartos (5 pontos)             ");
                    System.out.println("4- Televisão por cabo ou canais especiais (8 pontos) ");
                    System.out.println("6-Sair");
                    String pontosAdicionar = iscan.nextLine();
                    while (!Logica.isNum(pontosAdicionar)) {
                        System.out.println("Número inválido, insira novamente:");
                        pontosAdicionar = iscan.nextLine();
                    }
                    switch (pontosAdicionar.charAt(0)) {
                        case '1':
                            aluno.setPontos(aluno.getPontos() - 3);
                            System.out.println("Pontos Removidos com sucesso. Pontos totais: " + aluno.getPontos());
                            break;
                        case '2':
                            aluno.setPontos(aluno.getPontos() - 2);
                            System.out.println("Pontos Removidos com sucesso. Pontos totais: " + aluno.getPontos());
                            break;
                        case '3':
                            aluno.setPontos(aluno.getPontos() - 5);
                            System.out.println("Pontos Removidos com sucesso. Pontos totais: " + aluno.getPontos());
                            break;
                        case '4':
                            aluno.setPontos(aluno.getPontos() - 8);
                            System.out.println("Pontos Removidos com sucesso. Pontos totais: " + aluno.getPontos());
                            break;
                        case '6':
                            msg.menu();
                        default:
                            System.out.println("Opção Invalida");
                    }
                }

            case '2':
                while (true) {
                    System.out.println("O aluno tem " + aluno.getPontos() + " pontos.  ");
                    System.out.println("Que tipo de atividade quer fazer ?                ");
                    System.out.println("1- Participação em Atividades Acadêmicas, com contribuição(6 pontos )   ");
                    System.out.println("2- Participação em Atividades Acadêmicas (5 pontos)                     ");
                    System.out.println("3- Organização de Atividades Acadêmicas (2 pontos )                    ");
                    System.out.println("4- Participação em Clubes Académicos (4 pontos)                       ");
                    System.out.println("5- Participação em Competições Acadêmicas (4 pontos)                  ");
                    System.out.println("6-Sair");
                    String pontosRemover = iscan.nextLine();
                    while (!Logica.isNum(pontosRemover)) {
                        System.out.println("Número inválido, insira novamente:");
                        pontosRemover = iscan.nextLine();
                    }
                    switch (pontosRemover.charAt(0)) {
                        case '1':
                            aluno.setPontos(aluno.getPontos() + 6);
                            System.out.println("Pontos adicionados com sucesso. Pontos totais: " + aluno.getPontos());

                            break;
                        case '2':
                            aluno.setPontos(aluno.getPontos() + 2);
                            System.out.println("Pontos adicionados com sucesso. Pontos totais: " + aluno.getPontos());


                            break;
                        case '3':
                            aluno.setPontos(aluno.getPontos() + 5);
                            System.out.println("Pontos adicionados com sucesso. Pontos totais: " + aluno.getPontos());
                            break;
                        case '4':
                            aluno.setPontos(aluno.getPontos() + 8);
                            System.out.println("Pontos adicionados com sucesso. Pontos totais: " + aluno.getPontos());
                            break;
                        case '6':
                            msg.menu();
                        default:
                            System.out.println("Opção Invalida");
                            break;
                    }
                }

        }
    }
}




