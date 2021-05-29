import java.util.ArrayList;

public class TrainerSalary {

    ArrayList<Integer> dailyWorkingHours;
    private final int workingHourLimit = 8;
    private final int basicPay = 100;
    private final int extraPay = basicPay + 15;
    private final int sundayBonus = basicPay + (basicPay * (50 / 100));
    private final int saturdayBonus = basicPay + (basicPay * (25 / 100));
    private final int weeklyWorkingHourLimit = 40;
    private final int extraPayForWeeklyWorkingHour = 125;

    public TrainerSalary(ArrayList<Integer> dailyWorkingHours) {
        this.dailyWorkingHours = dailyWorkingHours;
    }

    public int calculateSalary() {
        int weekendSalary = weekendSalary();
        int weekdaySalary = weekdaySalary();
        int totalHours = totalHours();
        int salaryAmount = 0;

        if (totalHours > weeklyWorkingHourLimit) {
            salaryAmount += (totalHours - weeklyWorkingHourLimit) * extraPayForWeeklyWorkingHour;
        }

        salaryAmount += weekdaySalary + weekendSalary;

        return salaryAmount;
    }

    public int weekdaySalary() {
        int weekdaySalary = 0;

        for (int i = 1; i < dailyWorkingHours.size() - 1; i++) {
            int workingHours = dailyWorkingHours.get(i);

            if (workingHours <= workingHourLimit) {
                weekdaySalary += workingHours * basicPay;
            } else {
                int extraHours = workingHours - workingHourLimit;
                weekdaySalary += (extraHours * extraPay) + workingHourLimit * basicPay;
            }
        }

        return weekdaySalary;
    }

    public int weekendSalary() {
        int weekendSalary = 0;

        weekendSalary += dailyWorkingHours.get(0) * sundayBonus;
        weekendSalary += dailyWorkingHours.get(6) * saturdayBonus;

        return weekendSalary;
    }

    public int totalHours() {
        int totalHours = 0;
        for (int i = 0; i < dailyWorkingHours.size(); i++) {
            totalHours += dailyWorkingHours.get(i);
        }
        return totalHours;
    }
}
