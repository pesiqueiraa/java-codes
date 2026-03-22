public class Fila {
    private int[] elementos; // Array para armazenar elementos
    private int inicio; // Índice que aponta para o PRIMEIRO elemento
    private int fim; // Índice que aponta para o ÚLTIMO elemento
    private int quantidade; // Quantos elementos tem na fila
    private int capacidade; // Tamanho máximo

    // construtor
    public Fila(int elemento) {
        this.elementos = new int[capacidade];
        this.capacidade = capacidade;
        this.inicio = 0;
        this.fim = 0;
        this.quantidade = 0;
    }

    // construtor padrão

    public Fila() {
        this(10);
    }

    // Verifica se está vazia
    public boolean vazia() {
        return quantidade == 0;
    }

    // Verifica se está cheia
    private boolean cheia() {
        return quantidade == capacidade;
    }

    public void enfileirar(int elemento) {
        if (cheia()) {
            System.out.println("ta cheeeeia");
            return;
        }
        elementos[fim] = elemento;
        fim = (fim + 1) % capacidade;
        quantidade++;
    }

    public static void main(String[] args) {

    }
}
