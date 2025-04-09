import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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

        this.startDate = startDate;
        this.endDate = endDate;

        if(cycleLength < 21){
            throw new IllegalArgumentException("Cycle length cannot be less than 21");
        }else if(cycleLength > 35){
            throw new IllegalArgumentException("Cycle length must be less than or equal 35");
        }else {
            this.cycleLength = cycleLength;
        }

        //calculate difference between two days
        this.flowDays = (int) java.time.temporal.ChronoUnit.DAYS.between(this.startDate, this.endDate);
        if(flowDays < 2 || flowDays > 7){
            throw new IllegalArgumentException("Flow days must be between 2 and 7");
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

    public LocalDate nextCycleStartDate() {
        return startDate.plusDays(cycleLength);
    }
    public LocalDate nextOvulationDate() {
        LocalDate nextCycleStart = nextCycleStartDate();
        return nextCycleStart.minusDays(14);
    }

    public LocalDate safePeriodBeforeOvulation() {
        LocalDate ovulationDate = nextOvulationDate();
        return ovulationDate.minusDays(5);
    }


    public LocalDate safePeriodAfterOvulation() {
        LocalDate ovulationDate = nextOvulationDate();
        return ovulationDate.plusDays(5);
    }

}
