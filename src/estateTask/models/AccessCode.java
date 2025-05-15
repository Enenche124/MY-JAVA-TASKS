package estateTask.models;

import java.time.LocalDateTime;

public class AccessCode {
    private int id;
    private String otpCode;
    private LocalDateTime optGenerateDate = LocalDateTime.now();
    private LocalDateTime otpExpiredOn;
    private Resident resident;
    private Visitor visitor;
}
