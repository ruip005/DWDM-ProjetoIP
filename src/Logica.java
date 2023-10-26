public class Logica {
    public void Logica(char op) {
    switch (op) {
        case '1':
            //Adicionar aluno
            break;
        case '2':
            break;
            //Efetuar Candidatura de residencia (Verificar se pode entrar numa residenecia, e adicionar)
        case '3':
            break;
            //Atualizar alunos
        case '4':
            break;
            //Apagar alunos
        case '5':
            break;
            //Mostar informação de aluno( por numero)
        case '6':
            break;
            //Lista de ocupação de quartos
        case '7':
            break;
            //Eliminar a ocupação de quartos
        case '*':
            System.out.println("A sair da App...");
            System.exit(0);
            break;
        default:
            System.out.println("Escolha impossível");
            // Chamar menu
            Mensagens msn = new Mensagens();
            msn.menu();
        }
    }
}
