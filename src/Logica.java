import java.util.ArrayList;
import java.util.Scanner;
public class Logica {
    Mensagens msn = new Mensagens();
    Quartos quartos = new Quartos();
    SistemaPontos pontos = new SistemaPontos();
    Scanner isScan = new Scanner(System.in);
    public boolean isString(String value){
        return value.matches("[a-zA-Z]+");
    }
    public String formatNumber(int numero){
        String numeroFormatado = String.format("%04d", numero);
        return numeroFormatado;
    }

    public static boolean isNum(String value){
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
        if(value.length() == 9) {
            if (value.charAt(0) == '9') {
                if (value.charAt(1) == '1' || value.charAt(1) == '2' || value.charAt(1) == '3' || value.charAt(1) == '6') {
                    return true;
                }else return false;
                } else if(value.charAt(0) == '2') {
                if (value.charAt(1) == '3' && value.charAt(2) == '2') {
                    return true;
                } return false;
            } else return false;
        } else return false;
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

    public void Logica(char op) {
    switch (op) {
        case '1':
            //Inserir e Adicionar aluno
            addStudent();

            // Chamar menu
            msn.menu();
            break;
        case '2':
            if(Aluno.isAlunoEmpty()){
                System.out.println("Não existe nenhum aluno na base de dados!");
                msn.menu();
                return;
            }
            //Candidatura a residencia
            System.out.println("Insira o número do aluno:");
            String numero = isScan.nextLine();
            while (!isNum(numero)) {
                System.out.println("Número inválido, insira novamente:");
                numero = isScan.nextLine();
            }
            if(Aluno.getAluno(Integer.parseInt(numero)) == null){
                System.out.println("Número de aluno não existe!");
                msn.menu();
                return;
            }
            quartos.adicionarquartos(Integer.parseInt(numero));
            //Efetuar Candidatura de residencia (Verificar se pode entrar numa residenecia, e adicionar) ||| feito, adicionarquartos
            break;
        case '3':
            System.out.println("Insira o número do aluno:");
            String numeroAluno = isScan.nextLine();
            while (!isNum(numeroAluno)) {
                System.out.println("Número inválido, insira novamente:");
                numeroAluno = isScan.nextLine();
            }
            pontos.sistemaPontos(Integer.parseInt(numeroAluno));
            //Atualizar alunos
            break;
        case '4':
            //Apagar alunos
            removeStudent();
            msn.menu();
            break;
        case '5':
            showAluno();
            msn.menu();
            break;
            //Mostar informação de aluno( por numero)
        case '6':
            quartos.listarQuartos();
            msn.menu();
            break;
            //Lista de ocupação de quartos ||| feito quartosalocados
        case '7':
            // to do - atualizar ocupação de quartos
            System.out.println("Insira o número do aluno:");
            String numeroAluno2 = isScan.nextLine();
            while (!isNum(numeroAluno2)) {
                System.out.println("Número inválido, insira novamente:");
                numeroAluno2 = isScan.nextLine();
            }
            quartos.updateRooms(Integer.parseInt(numeroAluno2));
            //msn.menu();
            break;
            //Eliminar a ocupação de quartos ||| feito, removerquartos
        case '8':
            Aluno.SaveData();
            quartos.SaveData();
            msn.menu();
            break;
        //Save()
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
        while (!isNum(numero) || numero.length() > 4 ) {
            System.out.println("Número inválido, insira novamente:");
            numero = isScan.nextLine();
        }
        Aluno.getAluno(Integer.parseInt(numero));
        if(Aluno.getAluno(Integer.parseInt(numero)) != null){
            System.out.println("Número de aluno já existe!");
            msn.menu();
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
        while (!isFloat(String.valueOf(media)) || media < 0 || media > 20) {
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
                System.out.println("Número: " + formatNumber(aluno.getNumero()));
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Curso: " + aluno.getCurso());
                System.out.println("Ano de Matrícula: " + aluno.getAnoMatricula());
                System.out.println("Morada: " + aluno.getMorada());
                System.out.println("Telefone: " + aluno.getTelefone());
                System.out.println("Email: " + aluno.getEmail());
                System.out.println("Media: " + aluno.getMedia());
                System.out.println("Pontos: " + (int) aluno.getPontos());
                quartos.whoQuarto(Integer.parseInt(numero));
            } else {
                System.out.println("Número do aluno não existe");
            }
        }
    }
}