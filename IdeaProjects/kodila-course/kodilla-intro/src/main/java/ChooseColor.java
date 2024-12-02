import java.util.Scanner;
public class ChooseColor {
    public static String getUserSelection() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select the first letter of the color (A - antracyt, B - bialy, C - czarny):");
            String color = scanner.nextLine().trim().toUpperCase();
            switch (color) {
                case "A":
                    return "antracyt";
                case "B":
                    return "bialy";
                case "C":
                    return "czarny";
                default:
                    System.out.println("Wrong letter. Try again.");
            }
        }
    }
    public static void main(String[] args) {
        String selectedColor = getUserSelection();
        System.out.println("Selected color: " + selectedColor);
    }
}
