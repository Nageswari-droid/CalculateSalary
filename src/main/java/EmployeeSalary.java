import java.util.*;

public class EmployeeSalary {
    public static void main(String args[]) {
        ArrayList<Integer> dailyWorkingHours = new ArrayList<>();

        System.out.println("Enter daily working hours : ");
        Scanner scanner = new Scanner(System.in);

        dailyWorkingHours = addWorkingHours(dailyWorkingHours, scanner);

        TrainerSalary trainerSalary = new TrainerSalary(dailyWorkingHours);
        System.out.println(trainerSalary.calculateSalary());
    }

    private static ArrayList<Integer> addWorkingHours(ArrayList<Integer> dailyWorkingHours, Scanner scanner) {
        for (int i = 0; i < 7; i++) {
            int hours = scanner.nextInt();
            if (hours < 0) {
                throw new IllegalArgumentException("Invalid hour value");
            }
            dailyWorkingHours.add(hours);
        }
        return dailyWorkingHours;
    }

}
