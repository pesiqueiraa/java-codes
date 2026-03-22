public class Pilha {

    private int[] elementos;
    private int topo; 
    private int capacidade;

    // construtor 
    public Pilha(int capacidade) {
        this.elementos = new int[capacidade];
        this.topo = -1; // -1 indica pilha vazia
        this.capacidade = capacidade;
    }

    public Pilha() {
        this(10);
    }

    public boolean vazia() {
        return topo == -1;
    }

    public boolean cheia() {
        return topo == capacidade -1;
    }

    // add elemento no topo da pilha 
    public void push(int elemento) {
        if(cheia()) {
            System.out.println("Num da pra colocar nao");
            return;
        } 
        elementos[++topo] = elemento;
    }

    // remove e retorna o elemento do topo
    public int pop() {
        if(vazia()) {
            System.out.println("ta vaziaaa");
            return -1;
        }
        return elementos[topo--];
    }

    // retorna o topo da lista
    public int topo() {
        if(vazia()) {
            System.out.println("ta vaziaaaa");
            return -1;
        }
        return elementos[topo];
    }

    public int tamanho() {
        return topo + 1;
    }

    public void limpar() {
        topo = -1;
    }

    public static void main(String[] args) {
        Pilha pilha = new Pilha(5);
        
        // Teste 1: Verificando se está vazia
        System.out.println("Pilha vazia? " + pilha.vazia());
        
        // Teste 2: Adicionando elementos
        System.out.println("\n--- Adicionando elementos ---");
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);
        System.out.println("Elementos adicionados: 10, 20, 30, 40");
        System.out.println("Tamanho da pilha: " + pilha.tamanho());
        
        // Teste 3: Verificando o topo
        System.out.println("\n--- Verificando o topo ---");
        System.out.println("Elemento do topo: " + pilha.topo());
        
        // Teste 4: Removendo elementos
        System.out.println("\n--- Removendo elementos ---");
        System.out.println("Pop: " + pilha.pop());
        System.out.println("Pop: " + pilha.pop());
        System.out.println("Tamanho após 2 pops: " + pilha.tamanho());
        
        // Teste 5: Limpando a pilha
        System.out.println("\n--- Limpando a pilha ---");
        pilha.limpar();
        System.out.println("Pilha vazia? " + pilha.vazia());
        
        // Teste 6: Tentando fazer pop em pilha vazia
        System.out.println("\n--- Teste de erro ---");
        pilha.pop();
    }   
}
