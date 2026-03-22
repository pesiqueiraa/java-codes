public class preencherZerosTeste {
    public static void preencherZeros(int[][] matriz) {
        int linhas = matriz.length;
        int colunas = matriz[0].length; // pega a qtd de itens que tem dentro da primeira linha da matriz, assim
                                        // descobre a qtd de colunas

        // Passo 1: criar "bandeiras" para marcar quais linhas e colunas têm zero
        // Todos começam como false (= nenhuma linha/coluna marcada ainda)
        boolean[] linhaTemZero = new boolean[linhas];
        boolean[] colunaTemZero = new boolean[colunas];

        // Passo 2: percorrer a matriz inteira procurando zeros originais
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (matriz[i][j] == 0) {
                    linhaTemZero[i] = true; // marca a linha i
                    colunaTemZero[j] = true; // marca a coluna j
                }
            }
        }

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (linhaTemZero[i] || colunaTemZero[j]) {
                    matriz[i][j] = 0;
                }
            }
        }
    }

    public static void imprimirMatriz(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.printf("%3d", m[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] matriz = {
                { 1, 2, 3, 4, 5 },
                { 4, 0, 6, 10, 23 },
                { 7, 8, 9, 21, 0 }
        };

        System.out.println("Antes:");
        imprimirMatriz(matriz);

        preencherZeros(matriz);

        System.out.println("\nDepois:");
        imprimirMatriz(matriz);
    }
}
