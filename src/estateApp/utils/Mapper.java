package estateApp.utils;

import estateApp.data.models.Resident;
import estateApp.data.repository.ResidentRepository;
import estateApp.data.repository.ResidentRepositoryImp;
import estateApp.dtos.requests.ResidentServiceLoginRequest;
import estateApp.dtos.requests.ResidentServiceRegisterRequest;
import estateApp.dtos.responses.ResidentServiceLoginResponse;
import estateApp.dtos.responses.ResidentServiceRegisterResponse;

public class Mapper {

    private static ResidentRepository repository = new ResidentRepositoryImp();

    public static ResidentServiceRegisterResponse map(ResidentServiceRegisterRequest residentServiceRegisterRequest){String validEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+[a-zA-Z]{2,}$";
        String validPhoneNumber = "^(\\+234|0)[789][01]\\d{8}$";
        Resident resident = new Resident();
        resident.setResidentName(residentServiceRegisterRequest.getResidentName());
        resident.setResidentHouseNo(residentServiceRegisterRequest.getResidentPhone());
        resident.setEmail(residentServiceRegisterRequest.getResidentEmail());
        resident.setPhoneNumber(residentServiceRegisterRequest.getResidentPhone());

        boolean residentExists = repository.isEmailAlreadyExist(residentServiceRegisterRequest.getResidentEmail());
        if(residentExists){
            throw new IllegalArgumentException("Email already exists.");
        }
        if (!resident.getEmail().matches(validEmail)) {
            throw new IllegalArgumentException("Invalid email.");
        }
        if (!resident.getPhoneNumber().matches(validPhoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number.");
        }
        if (resident.getResidentName() == null || resident.getResidentName().isEmpty()) {
            throw new IllegalArgumentException("Resident name is empty.");
        }



    repository.save(resident);
    ResidentServiceRegisterResponse response = new ResidentServiceRegisterResponse();
    response.setResponseMessage(resident.getResidentName() + " has been registered successfully.");

    return response;
}

public static ResidentServiceLoginResponse map(ResidentServiceLoginRequest residentServiceLoginRequest){
        Resident confirmResidentLogin = repository.findByEmail(residentServiceLoginRequest.getEmail());
        if (confirmResidentLogin == null || confirmResidentLogin.getEmail() == null || confirmResidentLogin.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Invalid email.");
        }

           ResidentServiceLoginResponse residentServiceLoginResponse = new ResidentServiceLoginResponse();
           residentServiceLoginResponse.setUsername("Welcome " + confirmResidentLogin.getResidentName());
           return residentServiceLoginResponse;
}
}
