import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE / 2;

    // retorna array de distâncias mínimas a partir do nó início
    static int[] dijkstra(List<int[]>[] grafo, int inicio, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[inicio] = 0;

        PriorityQueue<int[]> fila = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        fila.offer(new int[]{0, inicio});

        while (!fila.isEmpty()) {
            int[] atual = fila.poll();
            int d = atual[0], u = atual[1];

            if (d > dist[u]) continue; // entrada desatualizada, ignora

            for (int[] aresta : grafo[u]) {
                int v = aresta[0], peso = aresta[1];
                if (dist[u] + peso < dist[v]) {
                    dist[v] = dist[u] + peso;
                    fila.offer(new int[]{dist[v], v});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        while (!(n == 0 && m == 0)) {

            int s = scanner.nextInt(), d = scanner.nextInt();

            List<int[]>[] grafo    = new ArrayList[n];
            List<int[]>[] grafoInv = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                grafo[i]    = new ArrayList<>();
                grafoInv[i] = new ArrayList<>();
            }

            int[][] arestas = new int[m][3];
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt(), v = scanner.nextInt(), p = scanner.nextInt();
                arestas[i] = new int[]{u, v, p};
                grafo[u].add(new int[]{v, p});
                grafoInv[v].add(new int[]{u, p}); // grafo invertido para Dijkstra a partir de D
            }

            // Distâncias mínimas de S até todos os nós
            int[] distS = dijkstra(grafo, s, n);

            // Distâncias mínimas de qualquer nó até D (Dijkstra no grafo invertido a partir de D)
            int[] distD = dijkstra(grafoInv, d, n);

            int menorCaminho = distS[d];
            if (menorCaminho == INF) {
                System.out.println(-1);
                n = scanner.nextInt();
                m = scanner.nextInt();
                continue;
            }

            Set<Long> proibidas = new HashSet<>();
            for (int[] aresta : arestas) {
                int u = aresta[0], v = aresta[1], p = aresta[2];
                if (distS[u] != INF && distD[v] != INF
                        && distS[u] + p + distD[v] == menorCaminho) {
                    proibidas.add((long) u * n + v); // codifica (u,v) como chave única
                }
            }

            // Monta grafo sem as arestas proibidas
            List<int[]>[] grafoFiltrado = new ArrayList[n];
            for (int i = 0; i < n; i++) grafoFiltrado[i] = new ArrayList<>();

            for (int[] aresta : arestas) {
                int u = aresta[0], v = aresta[1], p = aresta[2];
                if (!proibidas.contains((long) u * n + v)) {
                    grafoFiltrado[u].add(new int[]{v, p});
                }
            }

            int[] distQuase = dijkstra(grafoFiltrado, s, n);

            System.out.println(distQuase[d] == INF ? -1 : distQuase[d]);

            n = scanner.nextInt();
            m = scanner.nextInt();
        }

        scanner.close();
    }
}