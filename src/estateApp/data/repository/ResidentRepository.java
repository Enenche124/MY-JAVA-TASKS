package estateApp.data.repository;

import estateApp.data.models.Resident;

import java.util.List;

public interface ResidentRepository {
    Resident save(Resident resident);
    Resident findById(long id);
    void delete(Resident resident);
    List<Resident> findAll();
    Resident findByResidentName(String residentName);
    Resident findByEmail(String email);
    long count();
    boolean isEmailAlreadyExist(String email);
}
