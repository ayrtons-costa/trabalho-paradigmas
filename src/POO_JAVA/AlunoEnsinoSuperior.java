
// Classe que representa um aluno do Ensino Superior.
// Herda os atributos e métodos da classe Aluno.
public class AlunoEnsinoSuperior extends Aluno {

    // Construtor da classe.
    // Recebe o nome e as notas do aluno e envia essas
    // informações para o construtor da superclasse (Aluno).
    public AlunoEnsinoSuperior(String nome, double nota1, double nota2) {

        super(nome,nota1,nota2);
    }

    // Sobrescreve o método verificarSituacao() da classe Aluno.
    // No Ensino Superior, o aluno é aprovado se obtiver
    // média maior ou igual a 6.
    @Override
    public String verificarSituacao() {
        if (calcularMedia() >= 6) {
            return "Aprovado";
        }
        else {
            return "Reprovado";
        }
    }

}


