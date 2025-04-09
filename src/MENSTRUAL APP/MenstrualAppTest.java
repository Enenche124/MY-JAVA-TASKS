import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenstrualAppTest {

    @Test
    @DisplayName("Test that validate user")
    public void testThatUsersCanInputTheirName() {
        Users user = new Users("Mary", "female", 4);
        assertEquals("Mary", user.getUserName());
        assertEquals("female", user.getUserGender());

        assertEquals(4, user.getAge());
    }

}
