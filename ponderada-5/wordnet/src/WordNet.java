import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class WordNet {

    // mapa: substantivo -> lista de ids de synsets onde aparece
    private final Map<String, List<Integer>> substantivos;
    // mapa: id do synset -> string do synset
    private final Map<Integer, String> synsets;
    private final SAP sap;

    public WordNet(String arquivoSynsets, String arquivoHiperonimos) {
        if (arquivoSynsets == null || arquivoHiperonimos == null)
            throw new IllegalArgumentException("Argumentos nulos");

        substantivos = new HashMap<>();
        synsets = new HashMap<>();

        lerSynsets(arquivoSynsets);
        Digraph grafo = lerHiperonimos(arquivoHiperonimos);

        // Verificar ciclo
        DirectedCycle detector = new DirectedCycle(grafo);
        if (detector.hasCycle())
            throw new IllegalArgumentException("O grafo contem ciclo, nao e um DAG");

        // Verificar raiz unica
        int raizes = 0;
        for (int v = 0; v < grafo.V(); v++) {
            if (grafo.outdegree(v) == 0) raizes++;
        }
        if (raizes != 1)
            throw new IllegalArgumentException("O grafo nao tem raiz unica");

        sap = new SAP(grafo);
    }

    private void lerSynsets(String arquivo) {
        In in = new In(arquivo);
        while (in.hasNextLine()) {
            String linha = in.readLine();
            String[] campos = linha.split(",");
            int id = Integer.parseInt(campos[0]);
            String synset = campos[1];
            synsets.put(id, synset);

            for (String substantivo : synset.split(" ")) {
                if (!substantivos.containsKey(substantivo))
                    substantivos.put(substantivo, new ArrayList<>());
                substantivos.get(substantivo).add(id);
            }
        }
    }

    private Digraph lerHiperonimos(String arquivo) {
        Digraph grafo = new Digraph(synsets.size());
        In in = new In(arquivo);
        while (in.hasNextLine()) {
            String linha = in.readLine();
            String[] campos = linha.split(",");
            int id = Integer.parseInt(campos[0]);
            for (int i = 1; i < campos.length; i++) {
                int hiperonimo = Integer.parseInt(campos[i]);
                grafo.addEdge(id, hiperonimo);
            }
        }
        return grafo;
    }

    public Iterable<String> nouns() {
        return new TreeSet<>(substantivos.keySet());
    }

    public boolean isNoun(String palavra) {
        if (palavra == null) throw new IllegalArgumentException("Palavra nula");
        return substantivos.containsKey(palavra);
    }

    public int distance(String substantivoA, String substantivoB) {
        validarSubstantivo(substantivoA);
        validarSubstantivo(substantivoB);
        return sap.length(substantivos.get(substantivoA), substantivos.get(substantivoB));
    }

    public String sap(String substantivoA, String substantivoB) {
        validarSubstantivo(substantivoA);
        validarSubstantivo(substantivoB);
        int ancestral = sap.ancestor(substantivos.get(substantivoA), substantivos.get(substantivoB));
        return synsets.get(ancestral);
    }

    private void validarSubstantivo(String s) {
        if (s == null) throw new IllegalArgumentException("Substantivo nulo");
        if (!isNoun(s)) throw new IllegalArgumentException("Nao e um substantivo WordNet: " + s);
    }

    public static void main(String[] args) {
        WordNet wn = new WordNet(args[0], args[1]);
        StdOut.println("Numero de substantivos: " + ((TreeSet<String>) wn.nouns()).size());
        StdOut.println("distance(horse, cat) = " + wn.distance("horse", "cat"));
        StdOut.println("sap(horse, cat) = " + wn.sap("horse", "cat"));
    }
}