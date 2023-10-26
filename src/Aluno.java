import java.util.ArrayList;

public class Aluno {
    int numero;
    String nome;
    String curso;
    int anoMatricula;
    String morada;
    int telefone;
    String email;
    ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    public Aluno(int numero, String nome, String curso, int anoMatricula, String morada, int telefone, String email) {
        this.numero = numero;
        this.nome = nome;
        this.curso = curso;
        this.anoMatricula = anoMatricula;
        this.morada = morada;
        this.telefone = telefone;
        this.email = email;
        System.out.println("Aluno criado!");
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float media(int n1, int n2){
        return (n1+n2)/2;
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

    public void addAluno(Aluno student){
        alunos.add(student);
    }

    public void delAluno(int numero){
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getNumero() == numero){
                alunos.remove(i);
                System.out.println("Aluno apagado!");
                return ;
            }
        }
        System.out.println("Aluno não encontrado!");
    }

    public Aluno getAlunoPorId(int numero) {
        for (Aluno aluno : alunos) {
            if (aluno.getNumero() == numero) {
                return aluno;
            }
        }
        return null;
    }
}