package POO_JAVA;

// Classe que representa um aluno do Ensino Médio.
// Herda todos os atributos e métodos da classe Aluno.
public class AlunoEnsinoMedio extends Aluno {

    // Construtor da classe.
    // Recebe nome e notas e repassa essas informações
    // para o construtor da classe pai (Aluno).
    public AlunoEnsinoMedio(String nome, double nota1, double nota2) {

        super(nome,nota1,nota2);
    }

    // Sobrescreve o método verificarSituacao() da classe Aluno.
    // No Ensino Médio, o aluno é aprovado se a média for maior
    // ou igual a 5, caso contrário é reprovado.
    @Override
    public String verificarSituacao() {
        if (calcularMedia() >= 5) {
            return "Aprovado";
        }
        else {
            return "Reprovado";
        }
    }
}


