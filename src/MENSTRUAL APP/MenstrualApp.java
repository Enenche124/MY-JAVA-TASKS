import java.time.LocalDate;
import java.util.Date;

public class MenstrualApp {
    private String userName;
    private String userGender;
    private LocalDate startDate;
    private LocalDate endDate;
    private int flowDays;
    private int cycleLength;
    private int age;


    public MenstrualApp(String userName, String userGender, LocalDate startDate, LocalDate endDate, int cycleLength) {
        this.userName = userName;
        this.userGender = userGender;
        this.startDate = startDate;
        this.endDate = endDate;
        this.flowDays = 0;
        this.cycleLength = cycleLength;
        this.age = 0;
    }


}
