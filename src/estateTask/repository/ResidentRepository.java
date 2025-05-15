package estateTask.repository;

import estateTask.models.Resident;

import java.util.List;
import java.util.Optional;

public interface ResidentRepository {
    Resident save(Resident resident);
    Resident findById(long id);
    void delete(Resident resident);
    List<Resident> findAll();
    long count();
    List<Resident> findByResidentName(String residentName);
}
