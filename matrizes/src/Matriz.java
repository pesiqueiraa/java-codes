public class Matriz {
    // // Exibir soma de matriz
    // public void exibirMatriz(int[][] matriz) {
    //     int n = matriz.length;
    //     for (int i = 0; i < n; i++) {
    //         int soma = 0;
    //         for (int j = 0; j < matriz[i].length; j++) {
    //             soma += matriz[i][j];
    //             System.out.println(matriz[i][j] + " ");
    //         }

    //         System.out.println(soma);
    //         System.out.println();
    //     }
    // }


    public int maiorNumero(int[][] matriz){
        int linhas = matriz.length;
        int colunas = matriz[0].length;
        int maior = 0;

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++){
                if (matriz[i][j] > maior) {
                    maior = matriz[i][j];
                }
            }
        }

        return maior;

    }

    public static void main(String[] args) {
        Matriz matrizes = new Matriz();

        int[][] matrizTeste = {
                { 12, -5, 23, 7, -9 },
                { -15, 34, -2, 180, 0 },
                { 9, -27, 45, -11, 6 },
                { 3, 8, -19, 22, -30 },
                { -14, 1, 5, -6, 17 }
        };

        // matrizes.exibirMatriz(matrizTeste);
        System.out.println("==========================================");
        System.out.println(matrizes.maiorNumero(matrizTeste)); 
    }
}
