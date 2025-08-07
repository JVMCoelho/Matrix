import java.io.IOException;

public class MultiplicadorMatrix {

    // Função pra multiplicar dois números (pra não fazer direto a conta)
    public static int multiplicar(int a, int b) {
        return a * b;
    }

    // Função pra somar dois números (pra deixar tudo separado mesmo)
    public static int somar(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws IOException {
        // Lê o arquivo e pega as matrizes
        int[][] matrizA = LeitorArquivo.lerMatrizDoArquivo("src/matriz.txt", 0);
        int[][] matrizB = LeitorArquivo.lerMatrizDoArquivo("src/matriz.txt", 1);

        // Tamanho da matriz (NxN)
        int n = matrizA.length;

        // Cria uma nova matriz do mesmo tamanho pra guardar o resultado
        int[][] resultado = new int[n][n];

        System.out.println("\n📌 Passo a passo da multiplicação:\n");

        // Percorre cada linha (i) e coluna (j) da matriz resultado
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int soma = 0;
                for (int k = 0; k < n; k++) {
                    int mult = multiplicar(matrizA[i][k], matrizB[k][j]);
                    soma = somar(soma, mult);

                    System.out.println("A[" + i + "][" + k + "] * B[" + k + "][" + j + "] = "
                            + matrizA[i][k] + " * " + matrizB[k][j] + " = " + mult
                            + " ➜ soma parcial: " + soma);
                }
                resultado[i][j] = soma;
            }
        }
    }
}
