import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aluno {
    int numero;
    String nome;
    String curso;
    int anoMatricula;
    String morada;
    int telefone;
    String email;
    float media;
    float pontos;
    static ArrayList<Aluno> alunos = new ArrayList<Aluno>(); // Vai criar uma base de dados de alunos
    //HashMap<Integer, ArrayList<String>> disciplinas = new HashMap<Integer, ArrayList<String>>(); // Vai criar uma base de dados de disciplinas unica para cada aluno (nao posso duplicar o numero)
    //Map<Integer, Map<String, Float>> notas = new HashMap<>(); // Criar uma base de dados de notas para cada alun
    public Aluno(String nome, int numero, String curso, int anoMatricula, String morada, int telefone, String email,float media) {
        this.nome = nome;
        this.numero = numero;
        this.curso = curso;
        this.anoMatricula = anoMatricula;
        this.morada = morada;
        this.telefone = telefone;
        this.email = email;
        this.media = media;
        this.pontos = pontos;
        System.out.println("Aluno criado!");
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public float getPontos() {
        return media*10;
    }

    public void setPontos(float pontos) {
        this.pontos = media*10;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getAnoMatricula() {
        return anoMatricula;
    }

    public void setAnoMatricula(int anoMatricula) {
        this.anoMatricula = anoMatricula;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static void addAluno(Aluno student){
        alunos.add(student);
    }

    public static void delAluno(int numero){
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getNumero() == numero){
                alunos.remove(i);
                System.out.println("Aluno apagado!");
                return ;
            }
        }
        System.out.println("Aluno não encontrado!");
    }

    public static Aluno getAluno(int numero) {
        for (Aluno aluno : alunos) {
            if (aluno.getNumero() == numero) {
                return aluno;
            }
        }
        return null;
    }

    public static boolean isAlunoEmpty(){
        return alunos.isEmpty();
    }
}