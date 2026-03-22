public class Minesweeper {
    public static void main(String[] args) {
        int linhas = Integer.parseInt(args[0]);
        int colunas = Integer.parseInt(args[1]);
        int minas = Integer.parseInt(args[2]);
        
        boolean[][] temMina = new boolean[linhas][colunas];
        
        int minasColocadas = 0;
        while (minasColocadas < minas) {
            int i = (int) (Math.random() * linhas);
            int j = (int) (Math.random() * colunas);
            
            if (!temMina[i][j]) {
                temMina[i][j] = true;
                minasColocadas++;
            }
        }
        
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (temMina[i][j]) {
                    System.out.print("*");
                } else {
                    int contador = 0;
                    
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ni = i + di;
                            int nj = j + dj;
                            
                            if (ni >= 0 && ni < linhas && nj >= 0 && nj < colunas) {
                                if (temMina[ni][nj]) {
                                    contador++;
                                }
                            }
                        }
                    }
                    
                    System.out.print(contador);
                }
                
                if (j < colunas - 1) {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
