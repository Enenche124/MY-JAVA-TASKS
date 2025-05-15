package estateTask.services;

import estateTask.dtos.requests.ResidentServiceRequest;
import estateTask.dtos.responses.ResidentServiceResponse;

public interface ResidentService {
    ResidentServiceResponse register(ResidentServiceRequest residentServiceRequest);
}
