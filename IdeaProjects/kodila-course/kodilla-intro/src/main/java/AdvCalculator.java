public class AdvCalculator {
    private final UserDialogs userDialogs;

    public AdvCalculator(UserDialogs userDialogs) {
        this.userDialogs = userDialogs;
    }

    public double calculate() {
        String userSelected = userDialogs.getUserSelection();
        int a = userDialogs.getValue();
        int b = userDialogs.getValue();
        return switch (userSelected) {
            case "A" -> a + b;
            case "S" -> a - b;
            case "D" -> a / b;
            case "M" -> a * b;
            default -> 0;
        };
    }
}
