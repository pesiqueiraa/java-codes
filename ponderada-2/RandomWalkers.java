public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int totalSteps = 0;
        for (int i = 0; i < trials; i++) {
            int x = 0;
            int y = 0;
            int steps = 0;
            while (Math.abs(x) + Math.abs(y) < r) {
                int randomNumber = (int) (Math.random() * 4);
                if (randomNumber == 0) {
                    y += 1;
                    steps += 1;
                } else if (randomNumber == 1) {
                    y -= 1;
                    steps += 1;
                } else if (randomNumber == 2) {
                    x += 1;
                    steps += 1;
                } else if (randomNumber == 3) {
                    x -= 1;
                    steps += 1;
                }
            } 
            totalSteps += steps;
        }
        
        double media = (double) totalSteps / (double) trials;
        System.out.println("average number of steps = " + media);
    }
}

// Math.abs(x) + Math.abs(y) -> distancia Manhattan 