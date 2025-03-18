import java.util.Scanner;

public class AdvCalcApplication {
    public static void main(String[] args) {
        AdvCalcApplication app = new AdvCalcApplication();
        app.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        UserDialogs userDialogs = new UserDialogs(scanner);
        AdvCalculator calculator = new AdvCalculator(userDialogs);
        double result = calculator.calculate();
        System.out.println("Result: " + result);
    }
}