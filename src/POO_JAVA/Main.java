import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // Scanner responsável por receber entradas do usuário via teclado
        Scanner entrada = new Scanner(System.in);

        // Pergunta quantos alunos serão cadastrados no sistema
        System.out.print("Quantos alunos serão avaliados? ");
        int qtdAlunos = entrada.nextInt();
        entrada.nextLine(); // limpa o buffer do teclado

        // Cria um array de objetos Aluno com o tamanho informado pelo usuário
        Aluno[] alunos = new Aluno[qtdAlunos];

        // Loop responsável por cadastrar cada aluno
        for (int i = 0; i < qtdAlunos; i++) {

            System.out.println("---------------INFORMAÇÕES DO ALUNO---------------");
            System.out.println("Aluno(a) " + (i + 1));

            // Entrada do nome do aluno
            System.out.print("Nome do Aluno: ");
            String nome = entrada.nextLine();

            double nota1 = 0;
            double nota2 = 0;

            // Validação da primeira nota (aceita apenas valores entre 0 e 10)
            while (true) {
                try {
                    System.out.print("Nota 1: ");
                    nota1 = entrada.nextDouble();
                    entrada.nextLine();

                    if (nota1 >= 0 && nota1 <= 10) {
                        break; // sai do loop se a nota for válida
                    } else {
                        System.out.println("Nota inválida! Digite de 0 a 10.\n");
                    }

                } catch (Exception erro) {
                    // Captura erros como letras ou símbolos ao invés de números
                    System.out.println("Campo inválido! Digite apenas números.\n");
                    entrada.nextLine(); // limpa entrada inválida
                }
            }

            // Validação da segunda nota (mesma lógica da primeira)
            while (true) {
                try {
                    System.out.print("Nota 2: ");
                    nota2 = entrada.nextDouble();
                    entrada.nextLine();

                    if (nota2 >= 0 && nota2 <= 10) {
                        break;
                    } else {
                        System.out.println("Nota inválida! Digite de 0 a 10.\n");
                    }

                } catch (Exception erro) {
                    System.out.println("Campo inválido! Digite apenas números.\n");
                    entrada.nextLine();
                }
            }

            // Escolha do tipo de aluno (define regras diferentes de aprovação)
            System.out.println(" ");
            System.out.println("Escolha o nivel escolar do aluno(a): ");
            System.out.println("OBS: Alunos do Ensino Médio com média acima de 5: Aprovado.");
            System.out.println("Alunos do Ensino Superior com média acima de 6: Aprovado.");
            System.out.println("Digite [1] - Ensino Médio");
            System.out.println("Digite [2] - Ensino Superior");

            int nivelEscolar = entrada.nextInt();
            entrada.nextLine();

            // Criação de objetos usando POLIMORFISMO (herança)
            if (nivelEscolar == 1) {
                alunos[i] = new AlunoEnsinoMedio(nome, nota1, nota2);
            } else {
                alunos[i] = new AlunoEnsinoSuperior(nome, nota1, nota2);
            }
        }

        // Ordena os alunos por nome em ordem alfabética
        Arrays.sort(alunos, (a, b) ->
                a.getNome().compareTo(b.getNome())
        );

        System.out.println("---------------MÉDIA FINAL DOS ALUNOS---------------");
        System.out.println(" ");

        double somaMedias = 0; // soma das médias para calcular média geral da turma
        double maiorNota = 0;  // armazena a maior nota encontrada
        double menorNota = 10; // inicia com valor máximo possível

        // Percorre todos os alunos para exibir dados e calcular estatísticas
        for (int j = 0; j < qtdAlunos; j++) {

            // Calcula média individual do aluno
            double mediaAluno = alunos[j].calcularMedia();

            // Recupera notas individuais
            double nota1 = alunos[j].getNota1();
            double nota2 = alunos[j].getNota2();

            // Coloca as notas em um array para facilitar comparação
            double[] notas = {nota1, nota2};

            // Verifica maior e menor nota entre todas as notas dos alunos
            for (int k = 0; k < notas.length; k++) {
                if (notas[k] > maiorNota) {
                    maiorNota = notas[k];
                }
                if (notas[k] < menorNota) {
                    menorNota = notas[k];
                }
            }

            // Exibe informações do aluno
            System.out.println("Aluno(a) " + alunos[j].getNome());
            System.out.println("Media: " + mediaAluno);

            // Soma as médias para cálculo final da turma
            somaMedias += mediaAluno;

            // Situação do aluno (polimorfismo: comportamento muda por classe)
            System.out.println("Situação: " + alunos[j].verificarSituacao());

            System.out.println(" ");
        }

        // Cálculo da média geral da turma
        System.out.println("---------------ESTATÍSTICAS GERAIS DA TURMA---------------");
        System.out.println(" ");

        double mediaGeral = somaMedias / qtdAlunos;

        // Exibição das estatísticas finais
        System.out.println("Média geral da Turma: " + mediaGeral);
        System.out.println("Maior nota da turma: " + maiorNota);
        System.out.println("Menor nota da turma: " + menorNota);
    }

}