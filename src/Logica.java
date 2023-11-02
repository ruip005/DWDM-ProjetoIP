import java.util.ArrayList;
import java.util.Scanner;
public class Logica {
    Mensagens msn = new Mensagens();
    Scanner isScan = new Scanner(System.in);
    public boolean isString(String value){
        return value.matches("[a-zA-Z]+");
    }
    public String formatNumber(int numero){
        String numeroFormatado = String.format("%04d", numero);
        return numeroFormatado;
    }

    public boolean isNum(String value){
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isEmail(String value){
        return value.contains("@") ? true : false;
    }

    public boolean isPhone(String value){
        return value.length() == 9 ? true : false;
    }

    public boolean isYear(String value){
        return value.length() == 4 ? true : false;
    }

    public boolean isFloat(String value){
        try {
            Float.parseFloat(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void Logica(int op) {
    switch (op) {
        case '1':
            //Inserir e Adicionar aluno
            addStudent();
            // Chamar menu
            msn.menu();
            break;
        case '2':
            //Efetuar Candidatura de residencia (Verificar se pode entrar numa residenecia, e adicionar) ||| feito, adicionarquartos
            break;
        case '3':
            //Atualizar alunos
            break;
        case '4':
            //Apagar alunos
            removeStudent();
            break;
        case '5':
            showAluno();
            msn.menu();
            break;
            //Mostar informação de aluno( por numero)
        case '6':
            break;
            //Lista de ocupação de quartos ||| feito quartosalocados
        case '7':

            msn.menu();
            break;
            //Eliminar a ocupação de quartos ||| feito, removerquartos
        case '*':
            System.out.println("A sair da App...");
            System.exit(0);
            break;
        default:
            System.out.println("Escolha impossível");
            // Chamar menu
            msn.menu();
        }
    }
    private void addStudent(){
        System.out.println("Insira o nome do aluno:");
        String nome = isScan.nextLine();
        while (!isString(nome)) {
            System.out.println("Nome inválido, insira novamente:");
            nome = isScan.nextLine();
        }
        System.out.println("Insira o número do aluno:");
        String numero = isScan.nextLine();
        while (!isNum(numero)) {
            System.out.println("Número inválido, insira novamente:");
            numero = isScan.nextLine();
        }
        System.out.println("Insira o curso do aluno:");
        String curso = isScan.nextLine();
        while (!isString(curso)) {
            System.out.println("Curso inválido, insira novamente:");
            curso = isScan.nextLine();
        }
        System.out.println("Insira o ano de matricula do aluno:");
        String anoMatricula = isScan.nextLine();
        while (!isYear(anoMatricula)) {
            System.out.println("Ano inválido, insira novamente:");
            anoMatricula = isScan.nextLine();
        }
        System.out.println("Insira a morada do aluno:");
        String morada = isScan.nextLine();
        System.out.println("Insira o telefone do aluno:");
        String telefone = isScan.nextLine();
        while (!isPhone(telefone)) {
            System.out.println("Telefone inválido, insira novamente:");
            telefone = isScan.nextLine();
        }
        System.out.println("Insira o email do aluno:");
        String email = isScan.nextLine();
        while (!isEmail(email)) {
            System.out.println("Email inválido, insira novamente:");
            email = isScan.nextLine();
        }
        System.out.println("Insira a média do aluno:");
        Float media = isScan.nextFloat();
        while (!isFloat(String.valueOf(media))) {
            System.out.println("Média inválida, insira novamente:");
            media = isScan.nextFloat();
        }
        Aluno novoAluno = new Aluno(nome, Integer.parseInt(numero), curso, Integer.parseInt(anoMatricula), morada, Integer.parseInt(telefone), email, media);
        Aluno.addAluno(novoAluno);
        System.out.println("Aluno adicionado com sucesso!");
    }
    private void removeStudent() {
        boolean existe = Aluno.isAlunoEmpty() ? false : true;
        if(!existe){
            System.out.println("Não existe nenhum aluno na base de dados!");
            msn.menu();
            return;
        } else {
            System.out.println("Insira o número do aluno:");
            String numero = isScan.nextLine();
            while (!isNum(numero)) {
                System.out.println("Número inválido, insira novamente:");
                numero = isScan.nextLine();
            }
            Aluno.delAluno(Integer.parseInt(numero));
            msn.menu();
        }
    }

    private void updateStudent(){
        System.out.println("Insira o número do aluno:");
        String numero = isScan.nextLine();
        while (!isNum(numero)) {
            System.out.println("Número inválido, insira novamente:");
            numero = isScan.nextLine();
        }
        Aluno aluno = Aluno.getAluno(Integer.parseInt(numero));
        msn.printAluno(aluno);
    }
    public void showAluno(){

        boolean existe = !Aluno.isAlunoEmpty();
        if(!existe){
            System.out.println("Não existe nenhum aluno na base de dados!");
            msn.menu();
        } else {
            System.out.println ("Insira o numero do aluno");
            String numero = isScan.nextLine();
            while (!isNum(numero)) {
                System.out.println("Número inválido, insira novamente:");
                numero = isScan.nextLine();
            }
            Aluno aluno = Aluno.getAluno(Integer.parseInt(numero));
            if(aluno != null){
                System.out.println("Número: " + aluno.getNumero());
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Curso: " + aluno.getCurso());
                System.out.println("Ano de Matrícula: " + aluno.getAnoMatricula());
                System.out.println("Morada: " + aluno.getMorada());
                System.out.println("Telefone: " + aluno.getTelefone());
                System.out.println("Email: " + aluno.getEmail());
                System.out.println("Media: " + aluno.getMedia());
                System.out.println("Pontos: " + aluno.getPontos());
            } else {
                System.out.println("Numero de aluno não existe");
            }
        }
    }
}