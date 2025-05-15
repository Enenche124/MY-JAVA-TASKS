package estateTask.services;

import estateTask.dtos.requests.ResidentServiceRequest;
import estateTask.dtos.responses.ResidentServiceResponse;
import estateTask.models.Resident;
import estateTask.repository.ResidentRepository;
import estateTask.repository.Residents;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResidentServiceImpTest {

    private ResidentRepository residentRepository;
    private ResidentService residentServices;

    @BeforeEach
    void setUp() {
        residentRepository = new Residents();
        residentServices = new ResidentServiceImp();
    }

    @Test
    public void testThatRegisterResidentMethodWorks() {
        Resident resident = new Resident();
        ResidentServiceRequest residentServiceRequest = new ResidentServiceRequest();

        residentServiceRequest.setFullName("Mary Smith");
        residentServiceRequest.setAddress("Semicolon Africa");
        residentServiceRequest.setPhoneNumber("555-555-5555");

        resident.setResidentName(residentServiceRequest.getFullName());
        resident.setResidentAddress(residentServiceRequest.getAddress());
        resident.setPhoneNumber(residentServiceRequest.getPhoneNumber());

        residentRepository.save(resident);
        assertEquals(1, residentRepository.count());

    }
}