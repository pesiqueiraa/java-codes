public class RightTriangle {
    public static void main(String[] args) {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = Integer.parseInt(args[2]);
            boolean result = ((a * a + b * b) == (c * c) || (a * a + c * c) == (b * b) || (b * b + c * c) == (a * a)) && (a > 0 && b > 0 && c > 0);
            System.out.println(result);

        } 
}
