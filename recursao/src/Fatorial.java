public class Fatorial {

    public int fat(int n) {
        if (n == 0) {
            return 1;
        }
        return n * fat(n - 1);
    }

    public static void main(String[] args) {   
        Fatorial fatorial = new Fatorial();
        System.out.println("Teste 1: " + fatorial.fat(2));        
        System.out.println("Teste 2: " + fatorial.fat(5));        
        System.out.println("Teste 3: " + fatorial.fat(3));        
        System.out.println("Teste 4: " + fatorial.fat(7));        



    }
}
