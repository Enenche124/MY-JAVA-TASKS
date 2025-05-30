package estateTask.repository;

import estateTask.models.Resident;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResidentsTest {
    private Residents residents;

    @BeforeEach
    void setUp() {
        residents = new Residents();
    }
    @Test
    public void testThatCountIsZeroBeforeAddingResident() {
        assertEquals(0, residents.count());
    }

    @Test
    public void testThatResidentsIsNotEmptyAfterSaveResident() {
        Resident resident = new Resident();
        residents.save(resident);
        assertEquals(1, residents.count());
    }

    @Test
    public void testThatUpdateResidentMethodWorks() {
        Resident residentOne = new Resident();
        residents.save(residentOne);
        assertEquals(1, residents.count());
        Resident residentTwo = new Resident();
        residentTwo.setResidentId(residentOne.getResidentId());
        residentTwo.setResidentName("John Doe");
        residents.save(residentTwo);
        assertEquals(1, residents.count());
        assertEquals("John Doe", residentTwo.getResidentName());
        assertEquals(residentOne.getResidentId(), residentTwo.getResidentId());

    }

    @Test
    public void testThatDeleteResidentMethodWorks() {
        Resident residentOne = new Resident();
        residents.save(residentOne);
        assertEquals(1, residents.count());
        residents.delete(residentOne);
        assertEquals(0, residents.count());
    }
    @Test
    public void testThatFindAllResidentMethodWorks() {
        Resident residentOne = new Resident();
        residents.save(residentOne);
        Resident residentTwo = new Resident();
        residents.save(residentTwo);
        List<Resident> allResidents = residents.findAll();
        assertEquals(2, allResidents.size());
    }

    @Test
    public void testThatFindResidentByIdMethodWorks() {
        Resident residentOne = new Resident();
        Resident actual = residents.save(residentOne);
       Resident expected = residents.findById(residentOne.getResidentId());
       assertEquals(expected, actual);
    }

    @Test
    public void testThatFindResidentByNameMethodWorks() {
        Resident residentOne = new Resident();
        residents.save(residentOne);
        residentOne.setResidentName("John Doe");
        Resident residentTwo = new Resident();
        residents.save(residentTwo);
        residentTwo.setResidentName("John Doe");
        Resident residentThree = new Resident();
        residents.save(residentThree);
        residentThree.setResidentName("Mary Smith");
        List<Resident> allResidents = residents.findByResidentName("John Doe");
        assertEquals(2, allResidents.size());


    }

}






























