import java.util.HashMap;
import java.util.Map;

public class Aluno {
    int numero;
    String nome;
    String curso;
    int anoMatricula;
    String morada;
    int telefone;
    String email;
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

    Map<Integer, Aluno> alunos = new HashMap<>();


}

/*
Aluno aluno1 = new Aluno(1, "Rui", "Rua A, Cidade X", "DWDM", 2003);
        alunos.put(aluno1.getId(), aluno1);

    Aluno aluno2 = new Aluno(2, "Jorge", "Rua B, Cidade Y", "DWDM", 2004);
        alunos.put(aluno2.getId(), aluno2);

    int alunoID = 1;
    Aluno aluno = alunos.get(alunoID);

        if (aluno != null) {
        System.out.println(aluno);
    } else {
    }
 */
