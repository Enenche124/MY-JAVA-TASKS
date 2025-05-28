package estateApp.services;

import estateApp.dtos.requests.ResidentServiceLoginRequest;
import estateApp.dtos.responses.ResidentServiceLoginResponse;
import estateApp.dtos.requests.ResidentServiceRegisterRequest;
import estateApp.dtos.responses.ResidentServiceRegisterResponse;

public interface ResidentService {
    ResidentServiceRegisterResponse register(ResidentServiceRegisterRequest residentServiceRegisterRequest);
    ResidentServiceLoginResponse login(ResidentServiceLoginRequest residentServiceLoginRequest);

}
