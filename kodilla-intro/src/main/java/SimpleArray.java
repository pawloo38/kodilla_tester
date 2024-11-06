public class SimpleArray {
    public static void main(String[] args) {
        String[] carBrand = new String[5];
        carBrand[0] = "Audi";
        carBrand[1] = "BMW";
        carBrand[2] = "MB";
        carBrand[3] = "Volvo";
        carBrand[4] = "Ford";

        String car = carBrand[3];
        System.out.println(car);

        int numberOfElements = carBrand.length;
        System.out.println("Moja tablica zawiera " + numberOfElements + " elementów");
    }
}
