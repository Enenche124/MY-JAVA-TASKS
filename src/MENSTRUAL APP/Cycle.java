import java.time.LocalDate;

public class Cycle {
    private LocalDate startDate;
    private LocalDate endDate;
    private  int flowDays;
    private int cycleLength;

    public Cycle(LocalDate startDate, LocalDate endDate, int cycleLength) {
        if(startDate == null){
            throw new IllegalArgumentException("StartDate cannot be null");
        }
        if(endDate == null){
            throw new IllegalArgumentException("EndDate cannot be null");
        }
        if(startDate.isAfter(endDate)){
            throw new IllegalArgumentException("StartDate cannot be after EndDate");
        }

        if(cycleLength < 21){
            throw new IllegalArgumentException("Cycle length must be greater than 0");
        }
        if(cycleLength >= 35){
            throw new IllegalArgumentException("Cycle length must be less than or equal 35");
        }

        this.startDate = startDate;
        this.endDate = endDate;
        this.cycleLength = cycleLength;

        //calculate difference between two days
        this.flowDays = (int) java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate);
        if(flowDays < 2 || flowDays > 7){
            throw new IllegalArgumentException("Cycle length must be between 2 and 7");
        }

    }

    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public int getCycleLength() {
        return cycleLength;
    }
    public int getFlowDays() {
        return flowDays;
    }
    public LocalDate prediction(){
        return startDate.plusDays(cycleLength);

    }
}
