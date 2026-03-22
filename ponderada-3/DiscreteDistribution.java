public class DiscreteDistribution {
    public static void main(String[] args) {
        int n = args.length - 1; // taman de args
        int m = Integer.parseInt(args[0]);
        int[] pesos = new int[n];

        for (int i = 0; i < n; i++) {
            pesos[i] = Integer.parseInt(args[i + 1]);
        }

        int[] somasAcumuladas = new int[n + 1];
        somasAcumuladas[0] = 0; // S0 = 0      
        
       for (int i = 1; i <= n; i++) {
            somasAcumuladas[i] = somasAcumuladas[i - 1] + pesos[i - 1];
        }

        int somaTotal = somasAcumuladas[n];

        for (int j = 0; j < m; j++) {
            int r = (int) (Math.random() * somaTotal);
            
            for (int i = 1; i <= n; i++) {
                if (somasAcumuladas[i - 1] <= r && r < somasAcumuladas[i]) {
                    System.out.print(i + " ");
                }
            }
        }

    }
}