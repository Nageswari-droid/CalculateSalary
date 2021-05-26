import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeSalaryTest {
    private static EmployeeSalary employeeSalary;

    @BeforeAll
    public static void setup() {
        employeeSalary = new EmployeeSalary();
    }

    @Test
    public void checkHoursIsPositive(){
        assertEquals(true, employeeSalary.validateHours(5));
    }
}
