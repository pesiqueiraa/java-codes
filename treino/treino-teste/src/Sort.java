public class Sort {

    public static void separarImparesPares(int[] array) {


    }

    public static void imprimirArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Criando um array de exemplo
        int[] array = { 15, 8, 24, 3, 10, 7, 22, 5, 14, 2, 11, 6 };

        System.out.println("Array original:");
        imprimirArray(array);

        // Separando impares à esquerda e pares à direita
        separarImparesPares(array);

        System.out.println("\nArray após separação (ímpares esquerda, pares direita):");
        imprimirArray(array);
    }
}
