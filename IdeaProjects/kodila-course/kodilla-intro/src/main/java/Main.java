import java.util.SortedMap;

public class Main {
    public static void main(String[] args){
        String myName = "Maciej";
        int myAge = 22;
        double height = 1.78;
        char varClass = 'A';
        boolean isGoodProgrammer = true;
        System.out.println(myName);
        System.out.println(myAge);
        System.out.println(height);
        System.out.println(varClass);
        System.out.println(isGoodProgrammer);

        String hellow = "Hello from FirstClass!";
        System.out.println(hellow);

        System.out.println("Dziennik ocen");

        Grades studentGrades = new Grades();

        studentGrades.add(5);
        studentGrades.add(3);
        studentGrades.add(2);
        studentGrades.add(4);
        studentGrades.add(5);

        System.out.println("Ostatnio dodana ocena: " + studentGrades.getLastGrade());
        System.out.println("Średnia ocen studenta: " + studentGrades.getAverage());

        System.out.println("Zadanie: pętla z wykorzystaniem obiektów");

        User agata = new User("Agata", 18);
        User adam = new User("Adam", 25);
        User beata = new User("Beata", 41);
        User bogdan = new User("Bogdan", 58);
        User cecylia = new User("Cecylia", 22);
        User cezary = new User("Cezary", 36);

        User[] users = {agata, adam, beata, bogdan, cecylia, cezary};
        System.out.println(cecylia);
        System.out.println(cecylia.getName() + " " + cecylia.getAge());
        int sum = 0;
        for(int i = 0; i < users.length; i++){
            int age = users[i].getAge();
            sum = sum + age;
        }
    double avg = sum / (double) users.length;
        System.out.println("Sredni wiek uzytkownikow: " + avg);
        System.out.println("Uzytkownicy ktorych wiek jest ponizej sredniej:");

        for (int i = 0; i < users.length; i++) {
            if (users[i].getAge() < avg) {
                System.out.println(users[i].getName());
            }
        }
        System.out.println("Zadanie RandomeNumbers");

        RandomNumbers randomNumbers = new RandomNumbers();
        randomNumbers.generateNumbers();

        System.out.println("Suma wylosowanych liczb: " + randomNumbers.getSum());
        System.out.println("Najwieksza wylosowana liczba: " + randomNumbers.getMax());
        System.out.println("Najmniejsza wylosowana liczba: " + randomNumbers.getMin());

        System.out.println("Zadanie refaktoryzacja kodu");

        Person person = new Person("Adam", 40.5, 178);

        person.checkPersonStatus();
    }
}
