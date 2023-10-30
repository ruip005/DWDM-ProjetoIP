import java.util.ArrayList;
import java.util.Scanner;

 class alunos {
     ArrayList<Aluno> listadealunos =new ArrayList<Aluno>();
     Scanner iscan= new Scanner(System.in);

     System.out.println ("Insira o numero do aluno");

     int numero = iscan.nextInt();
     boolean found = false;

        for (Aluno aluno : listadealunos) {
         if (aluno.getNumero() == numero) {
             System.out.println("Número: " + aluno.getNumero());
             System.out.println("Nome: " + aluno.getNome());
             System.out.println("Curso: " + aluno.getCurso());
             System.out.println("Ano de Matrícula: " + aluno.getAnoMatricula());
             System.out.println("Morada: " + aluno.getMorada());
             System.out.println("Telefone: " + aluno.getTelefone());
             System.out.println("Email: " + aluno.getEmail());
             System.out.println("Media: "+ aluno.getMedia());
             System.out.println("Pontos: "+ aluno.getPontos());
             found = true;
             break;
         }
         if (!found) {
             System.out.println("Aluno não encontrado.");

         }
     }

 }

