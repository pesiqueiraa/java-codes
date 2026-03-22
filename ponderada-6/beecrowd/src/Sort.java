public class Sort {

    public static void separarImparesPares(int[] array) {
        int qtdImpares = 0;
        int qtdPares = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                qtdPares++;
            } else {
                qtdImpares++;
            }
        }

        int[] impares = new int[qtdImpares];
        int[] pares = new int[qtdPares];

        int iImp = 0; 
        int iPar = 0; 

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                pares[iPar] = array[i];
                iPar++;
            } else {
                impares[iImp] = array[i];
                iImp++;
            }
        }

        // Copiar para o array original (primeiro os impares )

        for (int i = 0; i < impares.length; i++) {
            array[i] = impares[i];
        }
        
        for (int i = 0; i < pares.length; i++){
            array[impares.length + 1] = pares[i];
        }

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
