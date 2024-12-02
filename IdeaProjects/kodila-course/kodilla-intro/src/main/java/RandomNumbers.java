import java.util.Random;

public class RandomNumbers {
    private int sum = 0;
    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;

    public void generateNumbers(){
        Random random = new Random();

        while (sum <=5000) {
            int temp = random.nextInt(31);
            sum = sum + temp;
            if (temp > max){
                max = temp;
            }
            if (temp < min){
                min = temp;
            }
        }
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public int getSum() {
        return sum;
    }
}
