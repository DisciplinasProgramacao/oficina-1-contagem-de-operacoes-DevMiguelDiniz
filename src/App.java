import java.util.Random;

public class App {
    static int[] tamanhosTesteGrande =  { 125_000, 250_000, 500_000, 1_000_000, 2_000_000 };
    static int[] tamanhosTesteMedio =   {  12_500,  25_000,  50_000,   100_000,   200_000 };
    static int[] tamanhosTestePequeno = {       3,       6,      12,        24,        48 };
    static Random aleatorio = new Random(42);


    static int[] codigo1(int[] vetor) {
        int resposta = 0;
        int operacoes = 0;
        for (int i = 0; i < vetor.length; i += 2) {
            resposta += vetor[i] % 2;
            operacoes++;
        }
        return new int[]{resposta, operacoes};
    }

    static int codigo2(int[] vetor) {
        int contador = 0;
        for (int k = (vetor.length - 1); k > 0; k /= 2) {
            for (int i = 0; i <= k; i++) {
                contador++;
            }

        }
        return contador;
    }

    static int[] codigo3(int[] vetor) {
        int operacoes = 0;
        for (int i = 0; i < vetor.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < vetor.length; j++) {
                operacoes++;
                if (vetor[j] < vetor[menor])
                    menor = j;
            }
            int temp = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = temp;
        }
        return new int[]{operacoes};
    }

    static int[] codigo4(int n) {
        int[] resultadoOperacoes = new int[2];
        resultadoOperacoes[0] = fibonacci(n, resultadoOperacoes);
        return resultadoOperacoes;
    }

    static int fibonacci(int n, int[] resultadoOperacoes) {
        resultadoOperacoes[1]++;
        if (n <= 2)
            return 1;
        else
            return fibonacci(n - 1, resultadoOperacoes) + fibonacci(n - 2, resultadoOperacoes);
    }

    static int[] gerarVetor(int tamanho){
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, tamanho/2);
        }
        return vetor;
        
    }
    public static void main(String[] args) {
        for (int tamanho : tamanhosTesteGrande) {
            int[] vetor = gerarVetor(tamanho);

            long startTime = System.nanoTime();
            int[] resultado1 = codigo1(vetor);
            long endTime = System.nanoTime();
            System.out.println("codigo1 - Tamanho: " + tamanho + ", Resultado: " + resultado1[0] + ", Operações: " + resultado1[1] + ", Tempo: " + (endTime - startTime) + " ns");

            startTime = System.nanoTime();
            int resultado2 = codigo2(vetor);
            endTime = System.nanoTime();
            System.out.println("codigo2 - Tamanho: " + tamanho + ", Resultado: " + resultado2 + ", Tempo: " + (endTime - startTime) + " ns");
        }

        for (int tamanho : tamanhosTesteMedio) {
            int[] vetor = gerarVetor(tamanho);

            long startTime = System.nanoTime();
            int[] resultado3 = codigo3(vetor);
            long endTime = System.nanoTime();
            System.out.println("codigo3 - Tamanho: " + tamanho + ", Operações: " + resultado3[0] + ", Tempo: " + (endTime - startTime) + " ns");
        }

        for (int n : tamanhosTestePequeno) {
            long startTime = System.nanoTime();
            int[] resultado4 = codigo4(n);
            long endTime = System.nanoTime();
            System.out.println("codigo4 - n: " + n + ", Resultado: " + resultado4[0] + ", Operações: " + resultado4[1] + ", Tempo: " + (endTime - startTime) + " ns");
        }
    }
}
