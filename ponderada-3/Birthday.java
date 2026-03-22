public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        
        int[] contagem = new int[n + 2];
        
        for (int t = 0; t < trials; t++) {
            boolean[] aniversarios = new boolean[n];
            int pessoas = 0;
            
            while (true) {
                int dia = (int) (Math.random() * n);
                pessoas++;
                
                if (aniversarios[dia]) {
                    break;
                }
                
                aniversarios[dia] = true;
            }
            
            contagem[pessoas]++;
        }
        
        int acumulado = 0;
        
        for (int i = 1; i < contagem.length; i++) {
            acumulado += contagem[i];
            double fracao = (double) acumulado / trials;
            System.out.println(i + "\t" + contagem[i] + "\t\t" + fracao);
            
            if (fracao >= 0.5) {
                break;
            }
        }
    }
}
