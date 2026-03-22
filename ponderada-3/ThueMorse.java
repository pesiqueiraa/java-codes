public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        
        int[] sequencia = new int[n];
        sequencia[0] = 0;
        
        int length = 1;
        while (length < n) {
            for (int i = 0; i < length && length + i < n; i++) {
                sequencia[length + i] = 1 - sequencia[i];
            }
            length *= 2;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sequencia[i] == sequencia[j]) {
                    System.out.print("+");
                } else {
                    System.out.print("-");
                }
                if (j < n - 1) {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}