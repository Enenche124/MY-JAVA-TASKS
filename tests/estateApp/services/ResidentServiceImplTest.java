package estateApp.services;

import estateApp.data.models.Resident;
import estateApp.data.repository.ResidentRepository;
import estateApp.data.repository.ResidentRepositoryImp;
import estateApp.dtos.requests.ResidentServiceLoginRequest;
import estateApp.dtos.requests.ResidentServiceRegisterRequest;
import estateApp.dtos.responses.ResidentServiceLoginResponse;
import estateApp.dtos.responses.ResidentServiceRegisterResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class ResidentServiceImplTest {
    private ResidentRepository residentRepository;
    private ResidentService residentService;

    @BeforeEach
    public void setUp() {
        residentRepository = new ResidentRepositoryImp();
        residentService = new ResidentServiceImpl(residentRepository);
    }
    @Test
    public void testThatRegisterMethodWorks() {
        ResidentServiceRegisterRequest request = new ResidentServiceRegisterRequest();
        request.setResidentEmail("jerry@gmail.com");
        request.setResidentName("john adah");
        request.setResidentPhone("07087563402");

        ResidentServiceRegisterResponse response = residentService.register(request);
        assertNotNull(response);
        Resident residentEmail = residentRepository.findByEmail("jerry@gmail.com");
        assertNotNull(residentEmail);

        assertEquals(1, residentRepository.count());
        assertEquals( "jerry@gmail.com", residentEmail.getEmail());
        assertEquals( "john adah has been registered successfully.", response.getResponseMessage());
    }



    @Test
    public void testThatRegisterMethodThrowsExceptionForInvalidEmail() {
        ResidentServiceRegisterRequest request = new ResidentServiceRegisterRequest();
        request.setResidentEmail("johngmail.com");
        request.setResidentName("john adah");
        request.setResidentPhone("0708756342");
        assertThrows(IllegalArgumentException.class, () -> residentService.register(request));
    }

    @Test
    public void testThatRegisterMethodThrowsExceptionForInvalidPhoneNumber() {
        ResidentServiceRegisterRequest request = new ResidentServiceRegisterRequest();
        request.setResidentEmail("john@gmail.com");
        request.setResidentName("john adah");
        request.setResidentPhone("-2347087563424");
        assertThrows(IllegalArgumentException.class, () -> residentService.register(request));
    }


    @Test
    public void testThatRegisterMethodThrowsExceptionForDuplicateEmail() {
        ResidentServiceRegisterRequest request = new ResidentServiceRegisterRequest();
        request.setResidentEmail("mike@gmail.com");
        request.setResidentName("john adah");
        request.setResidentPhone("07087563427");
        residentService.register(request);
        assertThrows(IllegalArgumentException.class, () -> residentService.register(request));
    }

    @Test
    public void testThatLoginMethodWorks(){
        ResidentServiceRegisterRequest request = new ResidentServiceRegisterRequest();
        request.setResidentEmail("emma@gmail.com");
        request.setResidentName("john adah");
        request.setResidentPhone("07087563420");
        ResidentServiceRegisterResponse response = residentService.register(request);
        assertNotNull(response);

        Resident residentEmail = residentRepository.findByEmail("emma@gmail.com");
        ResidentServiceLoginRequest loginRequest = new ResidentServiceLoginRequest();
        loginRequest.setEmail(residentEmail.getEmail());

        ResidentServiceLoginResponse loginResponse = residentService.login(loginRequest);

        assertEquals( "Welcome john adah", loginResponse.getUsername());
//        assertEquals(1, residentRepository.count());
    }
}