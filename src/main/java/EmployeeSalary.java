import java.util.*;

public class EmployeeSalary {
    public static void main(String args[]) {

        EmployeeSalary employeeSalary = new EmployeeSalary();
        ArrayList<Integer> dailyWorkingHours = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 7; i++) {
            int hours = scanner.nextInt();
            if(employeeSalary.validateHours(hours)){
                dailyWorkingHours.add(hours);
            }
            else{
                System.out.println("Invalid hours value");
            }
        }

        TrainerSalary trainerSalary = new TrainerSalary(dailyWorkingHours);
        System.out.println("Salary per week : " + trainerSalary.calculateSalary());

    }

    public boolean validateHours(int hours){
        return hours >= 0;
    }
}
