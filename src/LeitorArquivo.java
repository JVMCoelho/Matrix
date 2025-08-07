import java.io.*;
import java.util.*;

public class LeitorArquivo {

    public static int[][] lerMatrizDoArquivo(String nomeArquivo, int numeroMatriz) throws IOException {
        List<int[][]> matrizes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            List<int[]> linhasMatriz = new ArrayList<>();

            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) {
                    matrizes.add(linhasMatriz.toArray(new int[0][]));
                    linhasMatriz.clear();
                    continue;
                }
                String[] numeros = linha.trim().split("\\s+");
                int[] linhaNumeros = new int[numeros.length];
                for (int i = 0; i < numeros.length; i++) {
                    linhaNumeros[i] = Integer.parseInt(numeros[i]);
                }
                linhasMatriz.add(linhaNumeros);
            }
            if (!linhasMatriz.isEmpty()) {
                matrizes.add(linhasMatriz.toArray(new int[0][]));
            }
        }

        return matrizes.get(numeroMatriz);
    }
}
