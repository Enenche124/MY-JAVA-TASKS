package estateApp.data.repository;

import estateApp.data.models.Resident;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ResidentsTest {
    private ResidentRepositoryImp residents;

    @BeforeEach
    public void setUp(){
        residents = new ResidentRepositoryImp();
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
    public void testThatFindByIdMethodWorks(){
        Resident resident1 = new Resident();
        Resident resident2 = new Resident();
        Resident resident3 = new Resident();
        Resident actual = residents.save(resident1);
        residents.save(resident2);
        residents.save(resident3);
        assertEquals(residents.findById(resident1.getResidentId()), actual);
    }
    @Test
    public void testThatDeleteMethodWorks(){
        Resident resident1 = new Resident();
        Resident resident2 = new Resident();
        Resident resident3 = new Resident();
        residents.save(resident1);
        residents.save(resident2);
        residents.save(resident3);
        residents.delete(resident1);
        assertEquals(2, residents.count());
        assertEquals(residents.findById(resident2.getResidentId()), resident2);
        assertEquals(residents.findById(resident3.getResidentId()), resident3);
        assertNull(residents.findById(resident1.getResidentId()));

    }

    @Test
    public void testThatFindAllMethodWorks(){
        Resident resident1 = new Resident();
        Resident resident2 = new Resident();
        Resident resident3 = new Resident();
        residents.save(resident1);
        residents.save(resident2);
        residents.save(resident3);
        assertEquals(3, residents.findAll().size());
    }

    @Test
    public void testThatFindByEmailMethodWorks(){
        Resident resident1 = new Resident();
        Resident resident2 = new Resident();
        Resident resident3 = new Resident();
        resident1.setEmail("Mike@gmail.com");
        resident2.setEmail("John@gmail.com");
        resident3.setEmail("Jane@gmail.com");
        residents.save(resident1);
        residents.save(resident2);
        residents.save(resident3);
        assertEquals(residents.findByEmail("John@gmail.com"), resident2);
        assertNull(residents.findByEmail("John@yahoo.com"));
    }

    @Test
    public void testThatFindByUsernameMethodWorks(){
        Resident resident1 = new Resident();
        Resident resident2 = new Resident();
        Resident resident3 = new Resident();
        resident1.setResidentName("Mike");
        resident2.setResidentName("John");
        resident3.setResidentName("Jane");
        residents.save(resident1);
        residents.save(resident2);
        residents.save(resident3);
        assertEquals(residents.findByResidentName("John"), resident2);
        assertNull(residents.findByResidentName("Johnson"));
        assertEquals(3, residents.findAll().size());

    }




}