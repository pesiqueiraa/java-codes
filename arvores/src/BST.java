public class BST {

    // Início: classe que representa um nó da árvore
    private class No {
        private int chave;
        private No esq;
        private No dir;

        public No(int chave) {
            this.chave = chave;
            this.esq = null;
            this.dir = null;
        }
    } // Fim: classe que representa um nó da árvore

    private No raiz; // raiz da árvore do TAD

    public BST() {
        raiz = null;
    }

    public void inserirIter(int novaChave) {
        No no = new No(novaChave);
        if (raiz == null) {
            raiz = no;
        } else {
            boolean inseriu = false;
            No temp = raiz;
            while (!inseriu) {
                if (novaChave < temp.chave) {
                    if (temp.esq == null) {
                        temp.esq = no;
                        inseriu = true;
                    } else {
                        temp = temp.esq;
                    }
                } else if (novaChave > temp.chave) {
                    if (temp.dir == null) {
                        temp.dir = no;
                        inseriu = true;
                    } else {
                        temp = temp.dir;
                    }
                }
            }
        }
    }

    public void inserirRec(int novaChave) {
        raiz = inserirRec(raiz, novaChave);
    }

    private No inserirRec(No raizSubArv, int novaChave) {
        if (raizSubArv == null)
            return new No(novaChave);
        else if (novaChave < raizSubArv.chave)
            raizSubArv.esq = inserirRec(raizSubArv.esq, novaChave);
        else if (novaChave > raizSubArv.chave)
            raizSubArv.dir = inserirRec(raizSubArv.dir, novaChave);
        return raizSubArv;
    }

    public boolean buscarIter(int alvo) {
        No raizSubArv = raiz;
        while (raizSubArv != null) {
            if (alvo == raizSubArv.chave)
                return true;
            else if (alvo < raizSubArv.chave)
                raizSubArv = raizSubArv.esq;
            else
                raizSubArv = raizSubArv.dir;
        }
        return false;
    }

    public boolean buscarRec(int alvo) {
        return buscarRec(raiz, alvo);
    }

    private boolean buscarRec(No raizSubArv, int alvo) {
        if (raizSubArv == null)
            return false;
        else if (alvo == raizSubArv.chave)
            return true;
        else if (alvo < raizSubArv.chave)
            return buscarRec(raizSubArv.esq, alvo);
        else
            return buscarRec(raizSubArv.dir, alvo);
    }

    


    public static void main(String[] args) {
        BST arv = new BST();
        arv.inserirRec(5);
        arv.inserirRec(8);
        arv.inserirRec(2);
        arv.inserirRec(1);
        arv.inserirRec(6);
        System.out.println(arv.buscarIter(5));
        System.out.println(arv.buscarIter(1));
        System.out.println(arv.buscarIter(8));
        System.out.println(arv.buscarIter(3));
        System.out.println(arv.buscarIter(9));

        System.out.println(arv.buscarRec(5));
        System.out.println(arv.buscarRec(1));
        System.out.println(arv.buscarRec(8));
        System.out.println(arv.buscarRec(3));
        System.out.println(arv.buscarRec(9));
    }

}
