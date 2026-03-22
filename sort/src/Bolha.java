public class Bolha {

    public int[] sort(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            boolean trocou = false;
            for(int j = 0; j < n - i - 1; j++){
                if(arr[j] > arr[j + 1]) {
                    trocou = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!trocou) {
                break;
            }
        }
        
        
        return arr;
    }

    public static void main(String[] args) throws Exception {

    }
}
