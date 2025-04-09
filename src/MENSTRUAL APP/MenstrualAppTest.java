import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenstrualAppTest {

    @Test
    @DisplayName("Test to validate if name is empty")
    public void testToValidateIfNameIsEmpty() {
        Users user = new Users("Mary", "female", 11);
        assertEquals("Mary", user.getUserName());
    }

    @Test
    @DisplayName("Test that user must be female")
    public void testToValidateThatUserMustBeFemale() {
        Users user = new Users("Mary", "female", 11);
        assertEquals("female", user.getUserGender());
    }
    @Test
    @DisplayName("Test that users age can not be less than 10")
    public void testToValidateThatUserAgeLessThan10() {
        Users user = new Users("Mary", "female", 11);
        assertEquals(11, user.getAge());
    }

    @Test
    @DisplayName("Test for valid start date")
    public void testForValidStartDate() {
        int cycleLength = 28;
        LocalDate startDate = LocalDate.of(2025, 4, 17);
        LocalDate endDate = LocalDate.of(2025, 4, 22);

        Cycle cycle = new Cycle(startDate, endDate, cycleLength);
        assertEquals(startDate, cycle.getStartDate());
    }

    @Test
    @DisplayName("Test for valid end date")
    public void testForValidEndDate() {
        LocalDate startDate = LocalDate.of(2025, 4, 14);
        LocalDate endDate = LocalDate.of(2025, 4, 18);
        Cycle cycle = new Cycle(startDate, endDate, 28);
        assertEquals(endDate, cycle.getEndDate());
    }
    @Test
    @DisplayName("Test for valid cycle length")
    public void testForValidCycleLength() {
        int cycleLength = 28;
        LocalDate startDate = LocalDate.of(2025, 4, 18);
        LocalDate endDate = LocalDate.of(2025, 4, 22);
        Cycle cycle = new Cycle(startDate, endDate, cycleLength);
        assertEquals(cycleLength, cycle.getCycleLength());

    }
    @Test
    @DisplayName("Test for valid flow days")
    public void testForValidFlowDays() {
        int cycleLength = 28;
        LocalDate startDate = LocalDate.of(2025, 4, 19);
        LocalDate endDate = LocalDate.of(2025, 4, 21);
        Cycle cycle = new Cycle(startDate, endDate, cycleLength);
        System.out.println(cycle.getFlowDays());
        assertEquals(2, cycle.getFlowDays());
    }
    @Test
    @DisplayName("Test to validate prediction")
    public void testToValidatePrediction() {
        Users user = new Users("Mary", "female", 11);
        LocalDate startDate = LocalDate.of(2025, 4, 18);
        LocalDate endDate = LocalDate.of(2025, 4, 21);
        Cycle cycle = new Cycle(startDate, endDate, 31);
        LocalDate expectedDate = LocalDate.of(2025, 5, 19);
        assertEquals( expectedDate, cycle.prediction());
    }
    @Test
    @DisplayName("Test for safe period before ovulation days")
    public void testForSafePeriodDays() {
        Users user = new Users("Mary", "female", 11);
        LocalDate startDate = LocalDate.of(2025, 4, 18);
        LocalDate endDate = LocalDate.of(2025, 4, 21);
        Cycle cycle = new Cycle(startDate, endDate, 28);
        LocalDate expectedDate = LocalDate.of(2025, 4, 27);
        assertEquals( expectedDate, cycle.safePeriodBeforeOvulation());
    }
    @Test
    @DisplayName("Test for next ovulation")

    public void testForNextOvulation() {
        Users user = new Users("Mary", "female", 11);
        LocalDate startDate = LocalDate.of(2025, 4, 18);
        LocalDate endDate = LocalDate.of(2025, 4, 21);
        Cycle cycle = new Cycle(startDate, endDate, 28);
        LocalDate expectedDate = LocalDate.of(2025, 5, 2);
        assertEquals(expectedDate, cycle.nextOvulationDate());
    }
    @Test
    @DisplayName("Test for safe period after ovulation")
    public void testForSafePeriodAfterOvulation() {
        Users user = new Users("Mary", "female", 11);
        LocalDate startDate = LocalDate.of(2025, 4, 18);
        LocalDate endDate = LocalDate.of(2025, 4, 21);
        Cycle cycle = new Cycle(startDate, endDate, 28);
        LocalDate expectedDate = LocalDate.of(2025, 5, 7);
        assertEquals( expectedDate, cycle.safePeriodAfterOvulation());
    }


}
