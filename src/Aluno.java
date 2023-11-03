import java.io.*;
import java.util.ArrayList;

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
    public Aluno(String nome, int numero, String curso, int anoMatricula, String morada, int telefone, String email, float media) {
        this.nome = nome;
        this.numero = numero;
        this.curso = curso;
        this.anoMatricula = anoMatricula;
        this.morada = morada;
        this.telefone = telefone;
        this.email = email;
        this.media = media;
        this.pontos = media * 10;
        //System.out.println("Aluno criado!");
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
        return this.pontos;
    }

    public void setPontos(float pontos) {
        this.pontos = pontos;
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

    public static void addAluno(Aluno student) {
        alunos.add(student);
    }

    public static void delAluno(int numero) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getNumero() == numero) {
                alunos.remove(i);
                System.out.println("Aluno apagado!");
                return;
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

    public static boolean isAlunoEmpty() {
        return alunos.isEmpty();
    }

    public static void SaveData() {
        try {
            File arquivo = new File("users.txt");
            if (arquivo.exists()) {
                arquivo.delete();
            }
            arquivo.createNewFile();

            FileWriter fileWriter = new FileWriter(arquivo);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 0; i < alunos.size(); i++) {
                Aluno aluno = alunos.get(i);
                bufferedWriter.write("NO: " + aluno.getNumero());
                bufferedWriter.newLine();
                bufferedWriter.write("NAME: " + aluno.getNome());
                bufferedWriter.newLine();
                bufferedWriter.write("COURSE: " + aluno.getCurso());
                bufferedWriter.newLine();
                bufferedWriter.write("YEAR: " + aluno.getAnoMatricula());
                bufferedWriter.newLine();
                bufferedWriter.write("ADDRESS: " + aluno.getMorada());
                bufferedWriter.newLine();
                bufferedWriter.write("PHONE: " + aluno.getTelefone());
                bufferedWriter.newLine();
                bufferedWriter.write("EMAIL: " + aluno.getEmail());
                bufferedWriter.newLine();
                bufferedWriter.write("AVERAGE: " + aluno.getMedia());
                bufferedWriter.newLine();
                bufferedWriter.write("POINTS: " + aluno.getPontos());
                bufferedWriter.newLine();
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

            System.out.println("Dados dos alunos salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao guardar dados:\n" + e);
        }
    }

    public static void LoadData() {
        try {
            File arquivo = new File("users.txt");
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            if (!arquivo.exists()) {
                System.out.println("Arquivo de dados de alunos não encontrado.");
                return;
            }

            FileReader fileReader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            int no = 0;
            String name = null;
            String course = null;
            int year = 0;
            String address = null;
            int phone = 0;
            String email = null;
            float average = 0;
            float points = 0;

            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith("NO: ")) {
                    no = Integer.parseInt(line.substring(4).trim());
                } else if (line.startsWith("NAME: ")) {
                    name = line.substring(6).trim();
                } else if (line.startsWith("COURSE: ")) {
                    course = line.substring(8).trim();
                } else if (line.startsWith("YEAR: ")) {
                    year = Integer.parseInt(line.substring(6).trim());
                } else if (line.startsWith("ADDRESS: ")) {
                    address = line.substring(9).trim();
                } else if (line.startsWith("PHONE: ")) {
                    phone = Integer.parseInt(line.substring(7).trim());
                } else if (line.startsWith("EMAIL: ")) {
                    email = line.substring(7).trim();
                } else if (line.startsWith("AVERAGE: ")) {
                    average = Float.parseFloat(line.substring(9).trim());
                    points = average * 10;
                } else if (line.isEmpty()) {
                    // Quando uma linha em branco é encontrada, cria um objeto Aluno e adiciona à lista
                    Aluno aluno = new Aluno(name, no, course, year, address, phone, email, average);
                    alunos.add(aluno);
                }
            }

            bufferedReader.close();

            System.out.println("Dados dos alunos carregados com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao carregar dados dos alunos:\n" + e);
        }
    }
}