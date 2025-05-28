package estateApp.services;

import estateApp.data.repository.ResidentRepository;
import estateApp.dtos.requests.ResidentServiceLoginRequest;
import estateApp.dtos.requests.ResidentServiceRegisterRequest;
import estateApp.dtos.responses.ResidentServiceLoginResponse;
import estateApp.dtos.responses.ResidentServiceRegisterResponse;

import static estateApp.utils.Mapper.map;

public class ResidentServiceImpl implements ResidentService{

    public ResidentServiceImpl(ResidentRepository residentRepository) {

    }

    @Override
    public ResidentServiceRegisterResponse register(ResidentServiceRegisterRequest residentServiceRegisterRequest) {
       return map(residentServiceRegisterRequest);
    }

    @Override
    public ResidentServiceLoginResponse login(ResidentServiceLoginRequest residentServiceLoginRequest) {
        return map(residentServiceLoginRequest);
    }




}
