import java.io.*;
import java.util.*;
public class Quartos {
    Mensagens msg = new Mensagens();
    private Scanner isScan = new Scanner(System.in);

    static HashMap<Integer, String> kuartus = new HashMap<Integer, String>();

    //CASO 2
    public static int qtdBasciso() {
        int value = 0;
        for (Map.Entry<Integer, String> entry : kuartus.entrySet()) {
            if (entry.getValue().equals("Basico")) {
                value++;
            }
        }
        return value;
    }

    public static int qtdSup() {
        int value = 0;
        for (Map.Entry<Integer, String> entry : kuartus.entrySet()) {
            if (entry.getValue().equals("Superior")) {
                value++;
            }
        }
        return value;
    }

    public boolean alreadyQuarto(int numeroAluno) {
        Aluno aluno = Aluno.getAluno(numeroAluno);
        String quarto = kuartus.get(numeroAluno);
        if (quarto == null) {
            System.out.println("Aluno não tem quarto.");
            return false;
        } else {
            System.out.println("Aluno já tem quarto.");
            return true;
        }
    }

    //CASO 2
    public void adicionarquartos(int numeroAluno) {
        Aluno aluno = Aluno.getAluno(numeroAluno);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }
        if (alreadyQuarto(numeroAluno)) {
            msg.menu();
            return;
        }
        System.out.println("O aluno tem " + aluno.getPontos() + " pontos.");
        System.out.println("Que tipo de quarto deseja?");
        System.out.println("1- Quarto básico(110 Pontos)");
        System.out.println("2- Quarto superior(140 Pontos)");
        String escolhaQuarto = isScan.nextLine(); // to do - verificar se é numero
        while (!Logica.isNum(escolhaQuarto)) {
            System.out.println("Número inválido, insira novamente:");
            escolhaQuarto = isScan.nextLine();
        }
        switch (escolhaQuarto.charAt(0)) {
            case '1':
                if (qtdBasciso() >= 40) {
                    System.out.println("Não há quartos básicos disponíveis.");
                    msg.menu();
                } else if (aluno.getPontos() > 110) {
                    kuartus.put(numeroAluno, "Basico");
                    //qtdBasciso();
                    System.out.println("Quarto básico alocado.");
                    aluno.setPontos(aluno.getPontos() - 110);
                    msg.menu();
                } else {
                    System.out.println("Pontos insuficientes para um quarto básico.");
                    msg.menu();
                }
                break;
            case '2':
                if (qtdSup() >= 15) {
                    System.out.println("Não há quartos superiores disponíveis.");
                    msg.menu();
                } else if (aluno.getPontos() > 140) {
                    kuartus.put(numeroAluno, "Superior");
                    System.out.println("Quarto superior alocado.");
                    aluno.setPontos(aluno.getPontos() - 140);
                    msg.menu();
                } else {
                    System.out.println("Pontos insuficientes para um quarto superior.");
                    msg.menu();
                }
                break;
            default:
                System.out.println("Escolha inválida.");
                msg.menu();
                break;
        }
    }

        public void listarQuartos() {
            System.out.println("Quartos básicos ocupados: " + qtdBasciso() +" /40");
            System.out.println("Quartos superiores ocupados: " + qtdSup() +" /15");
            msg.menu();
        }

    //CASO 3
        public void whoQuarto(int numero) {
            Aluno aluno = Aluno.getAluno(numero);
            if (aluno == null) {
                System.out.println("Aluno não encontrado.");
                return;
            }
            String quarto = kuartus.get(numero);
            if (quarto == null) {
                System.out.println("Aluno não tem quarto.");
                return;
            } else System.out.println(quarto.equals("Basico") ? "Quarto básico" : "Quarto superior");
        }

        //CASO 7
        private void removerlocados () {
            char caso;

            do {
                System.out.println("Escolha a categoria de quartos que deseja remover:");
                System.out.println("1- Quartos Básicos");
                System.out.println("2- Quartos Superiores");
                System.out.println("*- Sair");

                caso = isScan.next().charAt(0);

                switch (caso) {
                    case '1':
                        System.out.println("Insira o número de quartos que deseja remover:");
                        int rbas = isScan.nextInt();
                        if (rbas <= qtdBasciso()) {
                            //qtd -= rbas; to do - remover quartos
                            System.out.println("Número de quartos básicos alocados agora é: " + qtdBasciso());
                            msg.menu();
                        } else {
                            System.out.println("Removeu mais quartos básicos do que o disponível.");
                            msg.menu();
                        }
                        break;

                    case '2':
                        System.out.println("Insira o número de quartos que deseja remover:");
                        int rsup = isScan.nextInt();
                        if (rsup <= qtdSup()) {
                            //superior -= rsup; to do - remover quartos
                            System.out.println("Número de quartos superiores alocados agora é: " + qtdSup());
                            msg.menu();
                        } else {
                            System.out.println("Removeu mais quartos superiores do que o disponível.");
                            msg.menu();
                        }
                        break;

                    case '*':
                        msg.menu();
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        msg.menu();
                }
            } while (caso != '*');
        }

    //Save
    public void SaveData(){
        try {
            File arquivo = new File("rooms.txt");
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            } else {
                arquivo.delete();
                arquivo.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo));

            // Iterar pelo HashMap e escrever os pares chave-valor no arquivo
            for (Map.Entry<Integer, String> entry : kuartus.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void LoadData() {
        try {
            File arquivo = new File("rooms.txt");
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            BufferedReader reader = new BufferedReader(new FileReader(arquivo));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                int key = Integer.parseInt(parts[0]);
                String value = parts[1];
                kuartus.put(key, value);
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

