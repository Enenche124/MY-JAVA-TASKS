import java.util.Scanner;

public class MenstrualApp {
    private Users user;
    private Cycle cycle;


    public MenstrualApp(Users user, Cycle cycle) {
       this.user = user;
       this.cycle = cycle;
    }

    public Users getUsers() {
        return user;
    }
    public Cycle getCycle() {
        return cycle;
    }
    public void display() {
        System.out.println("Hello 👋: " + user.getUserName());
        System.out.println("Your Gender is: " + user.getUserGender());
        System.out.println("Your Age is: " + user.getAge());
        System.out.println("Your menstrual Cycle length is: " + cycle.getCycleLength());
        System.out.println("Your menstrual Cycle start date is: " + cycle.getStartDate());
        System.out.println("Your menstrual Cycle end date is: " + cycle.getEndDate());
        System.out.println("Your safe period after ovulation is: " + cycle.safePeriodAfterOvulation());
        System.out.println("Your safe period before ovulation is: " + cycle.safePeriodBeforeOvulation());
        System.out.println("Your next Ovulation date is: " + cycle.nextOvulationDate());
        System.out.println("Your next menstrual cycle is: " + cycle.prediction());
    }

    public static void main(String[] args) {;

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter  your name: ");
            String userName = input.nextLine();
        }
    }



}
