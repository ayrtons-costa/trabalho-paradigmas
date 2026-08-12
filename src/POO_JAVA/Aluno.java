package POO_JAVA;
// Classe base que representa um aluno.
// Armazena as informações comuns a todos os alunos,
// independentemente do nível de ensino.
public class Aluno {

    // Atributos da classe
    private String nome;
    private double nota1;
    private double nota2;

    // Construtor da classe.
    // Inicializa o nome e as duas notas do aluno.
    public Aluno(String nome, double nota1, double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }


    // Define um novo nome para o aluno.
    public void setNome(String nome) {

        this.nome = nome;
    }

    // Retorna o nome do aluno.
    public String getNome() {
        return nome;
    }


    // Define a primeira nota do aluno.
    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    // Retorna a primeira nota do aluno.
    public double getNota1() {
        return nota1;
    }

    // Define a segunda nota do aluno.
    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    // Retorna a segunda nota do aluno.
    public double getNota2() {
        return nota2;
    }

    // Calcula e retorna a média das duas notas.
    public double calcularMedia() {
        return (nota1 + nota2) /2;
    }

    // Verifica a situação do aluno com base na média.
    // Este método pode ser sobrescrito pelas subclasses,
    // permitindo regras diferentes para cada nível de ensino.
    public String verificarSituacao() {
        if (calcularMedia() >= 7) {
            return "Aprovado";
        }
        else {
            return "Reprovado";
        }
    }

}
