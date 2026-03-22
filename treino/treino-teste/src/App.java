public class App {

    public static void dobrarPrimeiro(int[][] tabela) {
        tabela[0][0] *= 2; // dobra o valor do elemento na linha 0, coluna 0    
    }
    public static void main(String[] args) throws Exception {
        // Criando uma matriz 3x3 (3 linhas, 3 colunas) — tudo zerado
        int[][] matriz = new int[3][3];

        // Atribuindo valores manualmente
        matriz[0][0] = 1;
        matriz[0][1] = 2;
        matriz[1][2] = 6;

        // Criando já com valores definidos (cada {} interna é uma linha)
        int[][] tabela = {
                { 1, 2, 3 }, // linha 0
                { 4, 5, 6 }, // linha 1
                { 7, 8, 9 } // linha 2
        };

        // Acessando um elemento
        System.out.println(tabela[1][2]); // linha 1, coluna 2 → imprime 6


        for (int i = 0; i < tabela.length; i++) { // percorre linhas
            for (int j = 0; j < tabela[i].length; j++) { // percorre colunas
                System.out.print(tabela[i][j] + " ");
            }
            System.out.println(); // pula linha ao terminar cada linha da matriz
        }
        
        dobrarPrimeiro(tabela);
        System.out.println("Após dobrar o primeiro elemento:");
        for (int i = 0; i < tabela.length; i++) {
            for (int j = 0; j < tabela[i].length; j++) {
                System.out.print(tabela[i][j] + " ");
            }
            System.out.println();
        }
    }
}
