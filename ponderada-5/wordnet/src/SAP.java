import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SAP {

    private final Digraph grafo;

    public SAP(Digraph G) {
        if (G == null) throw new IllegalArgumentException("Grafo nulo");
        grafo = new Digraph(G);
    }

    private void validarVertice(int v) {
        if (v < 0 || v >= grafo.V())
            throw new IllegalArgumentException("Vertice fora do intervalo: " + v);
    }

    private void validarIteravel(Iterable<Integer> vertices) {
        if (vertices == null) throw new IllegalArgumentException("Iteravel nulo");
        for (Integer v : vertices) {
            if (v == null) throw new IllegalArgumentException("Vertice nulo no iteravel");
            validarVertice(v);
        }
    }

    private boolean iteravelVazio(Iterable<Integer> it) {
        return !it.iterator().hasNext();
    }

    // Retorna par {comprimento, ancestral} para dois conjuntos de vertices
    private int[] calcularSAP(Iterable<Integer> conjV, Iterable<Integer> conjW) {
        if (iteravelVazio(conjV) || iteravelVazio(conjW)) return new int[]{ -1, -1 };
        BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(grafo, conjV);
        BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(grafo, conjW);

        int menorDist = Integer.MAX_VALUE;
        int ancestral = -1;

        for (int v = 0; v < grafo.V(); v++) {
            if (bfsV.hasPathTo(v) && bfsW.hasPathTo(v)) {
                int dist = bfsV.distTo(v) + bfsW.distTo(v);
                if (dist < menorDist) {
                    menorDist = dist;
                    ancestral = v;
                }
            }
        }

        return new int[]{ menorDist == Integer.MAX_VALUE ? -1 : menorDist, ancestral };
    }

    public int length(int v, int w) {
        validarVertice(v);
        validarVertice(w);
        return calcularSAP(java.util.Collections.singletonList(v),
                           java.util.Collections.singletonList(w))[0];
    }

    public int ancestor(int v, int w) {
        validarVertice(v);
        validarVertice(w);
        return calcularSAP(java.util.Collections.singletonList(v),
                           java.util.Collections.singletonList(w))[1];
    }

    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        validarIteravel(v);
        validarIteravel(w);
        return calcularSAP(v, w)[0];
    }

    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        validarIteravel(v);
        validarIteravel(w);
        return calcularSAP(v, w)[1];
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        SAP sap = new SAP(G);
        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            int comprimento = sap.length(v, w);
            int ancestral = sap.ancestor(v, w);
            StdOut.printf("length = %d, ancestor = %d\n", comprimento, ancestral);
        }
    }
}