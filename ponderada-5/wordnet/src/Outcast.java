import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Outcast {

    private final WordNet wordnet;

    public Outcast(WordNet wordnet) {
        this.wordnet = wordnet;
    }

    public String outcast(String[] substantivos) {
        String maisDistante = null;
        int maiorDistancia = -1;

        for (String a : substantivos) {
            int somaDistancias = 0;
            for (String b : substantivos) {
                somaDistancias += wordnet.distance(a, b);
            }
            if (somaDistancias > maiorDistancia) {
                maiorDistancia = somaDistancias;
                maisDistante = a;
            }
        }
        return maisDistante;
    }

    public static void main(String[] args) {
        WordNet wordnet = new WordNet(args[0], args[1]);
        Outcast outcast = new Outcast(wordnet);
        for (int t = 2; t < args.length; t++) {
            In in = new In(args[t]);
            String[] substantivos = in.readAllStrings();
            StdOut.println(args[t] + ": " + outcast.outcast(substantivos));
        }
    }
}