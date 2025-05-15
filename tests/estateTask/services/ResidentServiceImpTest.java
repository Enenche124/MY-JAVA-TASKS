package estateTask.services;

import estateTask.dtos.requests.ResidentServiceRequest;
import estateTask.dtos.responses.ResidentServiceResponse;
import estateTask.repository.ResidentRepository;
import estateTask.repository.Residents;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResidentServiceImpTest {

    private ResidentRepository residentRepository;
    private ResidentService residentService;

    @BeforeEach
    void setUp() {
        residentRepository = new Residents();
        residentService = new ResidentServiceImp(residentRepository);
    }

    @Test
    public void testThatRegisterResidentMethodWorks() {
        ResidentServiceRequest request = new ResidentServiceRequest();
        request.setFullName("Mary Smith");
        request.setAddress("Semicolon Africa");
        request.setPhoneNumber("555-555-5555");

        ResidentServiceResponse response = residentService.register(request);

        assertNotNull(response);
        assertEquals("Mary Smith", response.getFullName());
       assertEquals(1, response.getId());

        assertEquals(1, residentRepository.count());
    }
}
