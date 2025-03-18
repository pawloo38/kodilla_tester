import java.util.Scanner;

public class UserDialogs {
    private final Scanner scanner;

    public UserDialogs(Scanner scanner) {
        this.scanner = scanner;
    }


    public static String getUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username:");
        return scanner.nextLine();
    }

    public String getUserSelection() {
        System.out.println("Select calculation (A-add, S-subtract, D-divide, M-multiply):");
        return scanner.nextLine().toUpperCase();
    }

    public int getValue() {
        System.out.println("Enter a number:");
        return scanner.nextInt();
    }
}