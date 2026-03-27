import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * IMPORTANT:
 * O nome da classe deve ser "Main" para que a sua solução execute
 * Class name must be "Main" for your solution to execute
 * El nombre de la clase debe ser "Main" para que su solución ejecutar
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BST tree;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int instancias = Integer.parseInt(br.readLine());

        StringBuilder output = new StringBuilder();

        int i, nos;
        for (i = 0; i < instancias; i++) {
            nos = Integer.parseInt(br.readLine());
            // instanciar árvore
            tree = new BST();

            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                // inserir na árvore o valor obtido com st.nextToken()
                tree.inserirRec(Integer.parseInt(st.nextToken()));
            }

            output.append("Case ").append(i + 1).append(":\n");

            StringBuilder sb = new StringBuilder();

            tree.preOrdem(sb);
            output.append("Pre.: ").append(sb.toString().trim()).append("\n");

            sb.setLength(0);
            tree.emOrdem(sb);
            output.append("In..: ").append(sb.toString().trim()).append("\n");

            sb.setLength(0);
            tree.posOrdem(sb);
            output.append("Post: ").append(sb.toString().trim()).append("\n\n");
        }
        System.out.print(output);

    }
}

class NoArv { // Classe que representa um nó da árvore
    int chave;
    NoArv esq;
    NoArv dir;

    public NoArv(int chave) {
        this.chave = chave;
        esq = null;
        dir = null;
    }
}

class BST { //classe que representa a árvore
    NoArv raiz;

    public void inserirRec(int novaChave) {
        raiz = inserirRec(raiz, novaChave);
    }

    private NoArv inserirRec(NoArv raizSubArv, int novaChave) {
        if (raizSubArv == null)
            return new NoArv(novaChave);
        else if (novaChave < raizSubArv.chave)
            raizSubArv.esq = inserirRec(raizSubArv.esq, novaChave);
        else if (novaChave > raizSubArv.chave)
            raizSubArv.dir = inserirRec(raizSubArv.dir, novaChave);
        return raizSubArv;
    }

    public void preOrdem(StringBuilder sb) {
        preOrdem(raiz, sb);
    }

    private void preOrdem(NoArv no, StringBuilder sb) {
        if (no != null) {
            sb.append(no.chave).append(" ");
            preOrdem(no.esq, sb);
            preOrdem(no.dir, sb);
        }

    }

    public void emOrdem(StringBuilder sb) {
        emOrdem(raiz, sb);
    }

    private void emOrdem(NoArv no, StringBuilder sb) {
        //sb.append(no.chave).append(" ");
        if(no != null) {
            emOrdem(no.esq, sb);
            sb.append(no.chave).append(" ");
            emOrdem(no.dir, sb);
        }

    }

    public void posOrdem(StringBuilder sb) {
        posOrdem(raiz, sb);
    }

    private void posOrdem(NoArv no, StringBuilder sb) {
        //sb.append(no.chave).append(" ");
        if(no != null) {
            posOrdem(no.esq, sb);
            posOrdem(no.dir, sb);
            sb.append(no.chave).append(" ");
        }
    }

}
