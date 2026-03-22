import java.util.Scanner;

public class Fibo {


    public int fibo(int n) {
        if (n == 1 || n == 0) {
            return n;
        }

        return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        Fibo calculadora = new Fibo();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite um valor para n (n >= 0): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                return;
            }

            int n = scanner.nextInt();

            if (n < 0) {
                System.out.println("n deve ser maior ou igual a 0.");
                return;
            }

            int resultado = calculadora.fibo(n);
            System.out.println("fibo(" + n + ") = " + resultado);
        }
    }
}
