public class Notebook {
    int weight;
    int price;
    int year;

    public Notebook(int weight, int price, int year) {
        this.weight = weight;
        this.price = price;
        this.year = year;
    }

    public void checkPrice() {
        if (this.price < 600) {
            System.out.println("This notebook is cheap.");
        } else {
            if (this.price >= 600 && this.price <= 1000) {
                System.out.println("This price is good.");
            } else {
                System.out.println("This notebook is expensive.");
            }
        }

    }

    public void checkWeight() {
        if (this.weight < 800) {
            System.out.println("This notebook is light.");
        } else {
            if (this.weight >= 800 && this.weight <= 1600) {
                System.out.println("This notebook is heavy.");
            } else {
                System.out.println("This notebook is very heavy.");
            }
        }
    }
    public void checkYear() {
        if (this.year < 2002 && this.price < 600) {
            System.out.println("This notebook is old and cheap.");
        } else {
            if (this.year < 2005 && this.price > 1000) {
                System.out.println("This notebook is old and expensive.");
            }
            if (this.year >= 2005 && this.year <= 2023 && this.price > 1000) {
                System.out.println("This notebook is middle aged and expensive.");

            }
            if (this.year >= 2024 && this.price > 2000) {
                System.out.println("This notebook is brand new.");
            }
        }
    }

}

