public class ColorHSB {

    private final int matiz;
    private final int saturacao;
    private final int brilho;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        matiz = h;
        saturacao = s;
        brilho = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + matiz + ", " + saturacao + ", " + brilho + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return saturacao == 0 || brilho == 0;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        int diferencaMatiz = Math.abs(matiz - that.matiz);
        int distanciaMatiz = Math.min(
                diferencaMatiz * diferencaMatiz,
                (360 - diferencaMatiz) * (360 - diferencaMatiz)
        );
        int distanciaSaturacao = (saturacao - that.saturacao) * (saturacao - that.saturacao);
        int distanciaBrilho = (brilho - that.brilho) * (brilho - that.brilho);
        return distanciaMatiz + distanciaSaturacao + distanciaBrilho;
    }

    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB corAlvo = new ColorHSB(h, s, b);

        String nomeProximo = "";
        ColorHSB corProxima = null;
        int menorDistancia = Integer.MAX_VALUE;

        while (!StdIn.isEmpty()) {
            String nome = StdIn.readString();
            int matizLido = StdIn.readInt();
            int saturacaoLida = StdIn.readInt();
            int brilhoLido = StdIn.readInt();

            ColorHSB corAtual = new ColorHSB(matizLido, saturacaoLida, brilhoLido);
            int distancia = corAlvo.distanceSquaredTo(corAtual);

            if (distancia < menorDistancia) {
                menorDistancia = distancia;
                nomeProximo = nome;
                corProxima = corAtual;
            }
        }

        System.out.println(nomeProximo + " " + corProxima);
    }
}
