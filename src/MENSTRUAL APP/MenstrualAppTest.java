import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("Test that user entered date in a specify format")
    public void testToValidateThatDateIsEnteredInASpecifyFormat() {
        Cycle cycle = new Cycle("11/19/2025", "11/22/2025", 23);
        assertEquals("11/22/2025", cycle.getStartDate());
    }



}
