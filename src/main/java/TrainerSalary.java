import java.util.ArrayList;

public class TrainerSalary {

    ArrayList<Integer> dailyWorkingHours;
    private int salaryAmount;
    private int totalHours;
    private int workingHourLimit;
    private int basicPay;
    private int extraPay;
    private int sundayBonus;
    private int saturdayBonus;
    private int weeklyWorkingHourLimit;
    private int extraPayForWeeklyWorkingHour;

    public TrainerSalary(ArrayList<Integer> dailyWorkingHours) {
        this.dailyWorkingHours = dailyWorkingHours;
        this.salaryAmount = 0;
        this.totalHours = 0;
        this.workingHourLimit = 8;
        this.basicPay = 100;
        this.extraPay = basicPay + 15;
        this.weeklyWorkingHourLimit = 40;
        this.extraPayForWeeklyWorkingHour = 25;
        this.sundayBonus = 150;
        this.saturdayBonus = 125;
    }

    public int calculateSalary() {

        calculateWeekendSalary();

        for (int i = 1; i < dailyWorkingHours.size() - 1; i++) {
            int workingHours = dailyWorkingHours.get(i);
            calculateWeekdaysSalary(workingHours);
        }

        if (totalHours > weeklyWorkingHourLimit) {
            salaryAmount += (totalHours - weeklyWorkingHourLimit) * extraPayForWeeklyWorkingHour;
        }

        return salaryAmount;

    }

    public void calculateWeekendSalary() {
        salaryAmount += dailyWorkingHours.get(0) * sundayBonus;
        salaryAmount += dailyWorkingHours.get(6) * saturdayBonus;

        totalHours += dailyWorkingHours.get(0) + dailyWorkingHours.get(6);
    }

    public void calculateWeekdaysSalary(int workingHours) {
        totalHours += workingHours;

        if (workingHours <= workingHourLimit) {
            salaryAmount += workingHours * basicPay;
        } else {
            int extraHours = workingHours - workingHourLimit;
            salaryAmount += (extraHours * extraPay) + workingHourLimit * basicPay;
        }
    }

}
