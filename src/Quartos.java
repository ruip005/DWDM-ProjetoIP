import java.util.ArrayList;
import java.util.Scanner;

public class Quartos {
    private Scanner iscan = new Scanner(System.in);
    private int basico = 0;
    private int superior = 0;

    //CASO 2
    //CASO 2
    public void adicionarquartos(ArrayList<Aluno> listaDeAlunos) {
        for (Aluno aluno : listaDeAlunos) {
            System.out.println("Insira o número do aluno:");
            int numeroAluno = iscan.nextInt();
            float pontos = aluno.getPontos();

            System.out.println("O aluno tem "+ pontos +" pontos.");
            System.out.println("Que tipo de quarto deseja?");
            System.out.println("1- Quarto básico");
            System.out.println("2- Quarto superior");
            int escolhaQuarto = iscan.nextInt();

            switch (escolhaQuarto) {
                case 1:
                    if (basico >= 40) {
                        System.out.println("Não há quartos básicos disponíveis.");
                    } else if (pontos > 110) {
                        basico += 1;
                        System.out.println("Quarto básico alocado.");
                    } else {
                        System.out.println("Pontos insuficientes para um quarto básico.");
                    }
                    break;
                case 2:
                    if (superior >= 15) {
                        System.out.println("Não há quartos superiores disponíveis.");
                    } else if (pontos > 140) {
                        superior += 1;
                        System.out.println("Quarto superior alocado.");
                    } else {
                        System.out.println("Pontos insuficientes para um quarto superior.");
                    }
                    break;
                default:
                    System.out.println("Escolha inválida.");
                    break;
            }
        }
    }


    //CASO 6
    private void quartosalocados() {
        System.out.println("Quantidade de quartos básicos alocados: " + basico);
        System.out.println("Quantidade de quartos superiores alocados: " + superior);
    }


    //CASO 7
    private void removerlocados() {
        char caso;

        do {
            System.out.println("Escolha a categoria de quartos que deseja remover:");
            System.out.println("1- Quartos Básicos");
            System.out.println("2- Quartos Superiores");
            System.out.println("*- Sair");

            caso = iscan.next().charAt(0);

            switch (caso) {
                case '1':
                    System.out.println("Insira o número de quartos que deseja remover:");
                    int rbas = iscan.nextInt();
                    if (rbas <= basico) {
                        basico -= rbas;
                        System.out.println("Número de quartos básicos alocados agora é: " + basico);
                    } else {
                        System.out.println("Removeu mais quartos básicos do que o disponível.");
                    }
                    break;

                case '2':
                    System.out.println("Insira o número de quartos que deseja remover:");
                    int rsup = iscan.nextInt();
                    if (rsup <= superior) {
                        superior -= rsup;
                        System.out.println("Número de quartos superiores alocados agora é: " + superior);
                    } else {
                        System.out.println("Removeu mais quartos superiores do que o disponível.");
                    }
                    break;

                case '*':
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (caso != '*');
    }
}

