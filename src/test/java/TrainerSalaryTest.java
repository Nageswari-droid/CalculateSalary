import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrainerSalaryTest {
    private static TrainerSalary trainerSalary;

    @BeforeAll
    public static void setup() {
        ArrayList<Integer> dailyWorkingHours = new ArrayList<>(Arrays.asList(0, 8, 8, 8, 10, 6, 0));
        trainerSalary = new TrainerSalary(dailyWorkingHours);
    }

    @Test
    public void checkSalaryAmount() {
        assertEquals(4030, trainerSalary.calculateSalary());
    }

    @Test
    public void checkWeekDaySalary() {
        assertEquals(4030, trainerSalary.weekdaySalary());
    }

    @Test
    public void checkWeekEndSalary() {
        assertEquals(0, trainerSalary.weekendSalary());
    }

    @Test
    public void checkWeeklyWorkingHours() {
        assertEquals(40, trainerSalary.totalHours());
    }
}
