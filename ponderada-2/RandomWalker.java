public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int steps = 0;
        int x = 0;
        int y = 0;
        
        System.out.println("(" + x + ", " + y + ")");
        
        while (Math.abs(x) + Math.abs(y) != r) {
            int randomNumber = (int) (Math.random() * 4);
            
            if (randomNumber == 0) {
                y += 1;  
            } else if (randomNumber == 1) {
                y -= 1;  
            } else if (randomNumber == 2) {
                x += 1;  
            } else {
                x -= 1;  
            }
            
            steps++;
            System.out.println("(" + x + ", " + y + ")");
        }
        
        System.out.println("steps = " + steps);
    }
}
