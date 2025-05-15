package estateTask.services;

import estateTask.dtos.requests.ResidentServiceRequest;
import estateTask.dtos.responses.ResidentServiceResponse;
import estateTask.models.Resident;
import estateTask.repository.ResidentRepository;
import estateTask.repository.Residents;

public class ResidentServiceImp implements ResidentService {
    private final ResidentRepository residentRepository;

    public ResidentServiceImp(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }


    @Override
    public ResidentServiceResponse register(ResidentServiceRequest request) {
        Resident resident = new Resident();
        resident.setResidentName(request.getFullName());
        resident.setResidentAddress(request.getAddress());
        resident.setPhoneNumber(request.getPhoneNumber());

        residentRepository.save(resident);

        ResidentServiceResponse response = new ResidentServiceResponse();
        response.setId(resident.getResidentId());
        response.setFullName(resident.getResidentName());

        return response;
    }
}
