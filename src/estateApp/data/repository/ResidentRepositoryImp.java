package estateApp.data.repository;

import estateApp.data.models.Resident;

import java.util.ArrayList;
import java.util.List;

public class ResidentRepositoryImp implements ResidentRepository{

    private int currentID = 0;
    private static List<Resident> residents = new ArrayList<>();

    @Override
    public Resident save(Resident resident) {
        if(isNew(resident))saveNew(resident);else update(resident);
        return resident;
    }

    private void update(Resident resident) {
        for (int index = 0; index < residents.size(); index++) {
            if (residents.get(index).getResidentId() == resident.getResidentId()) {
                residents.set(index, resident);
                return;
            }
        }
        throw new IllegalArgumentException("Resident not found");
    }

    private boolean isNew(Resident resident) {
        return resident.getResidentId() == 0;
    }

    private void saveNew(Resident resident) {
        resident.setResidentId(generatedId());
        residents.add(resident);
    }

    private int generatedId() {
        return ++currentID;
    }

    @Override
    public Resident findById(long id) {
        if(id <= 0) throw new IllegalArgumentException("Invalid id");
        if(id > currentID) throw new IllegalArgumentException("Resident not found");
        return residents.stream().filter(r -> r.getResidentId() == id).findFirst().orElse(null);
    }

    @Override
    public void delete(Resident resident) {
        if(resident == null) throw new IllegalArgumentException("Resident cannot be null");
        if(resident.getResidentId() <= 0) throw new IllegalArgumentException("Invalid id");
        if(resident.getResidentId() > currentID) throw new IllegalArgumentException("Resident not found");
        residents.removeIf(reside -> reside.getResidentId() == resident.getResidentId());

    }

    @Override
    public List<Resident> findAll() {
        if(residents.isEmpty()) throw new IllegalArgumentException("No residents found");
        return residents;
    }

    @Override
    public Resident findByResidentName(String residentName) {
        if(residentName == null) throw new IllegalArgumentException("Resident name cannot be null");
        if(residentName.isEmpty()) throw new IllegalArgumentException("Resident name cannot be empty");
        if(residents.isEmpty()) throw new IllegalArgumentException("No residents found");
        return residents.stream().filter(resider -> resider.getResidentName().equals(residentName)).findFirst().orElse(null);
    }

    @Override
    public Resident findByEmail(String email) {
        if(email == null) throw new IllegalArgumentException("Email cannot be null");
        if(email.isEmpty()) throw new IllegalArgumentException("Email cannot be empty");
        if(residents.isEmpty()) throw new IllegalArgumentException("No residents found");
        return residents.stream()
                .filter(resider -> resider.getEmail()
                        .equals(email)).findFirst().orElse(null);
    }

    @Override
    public long count() {
        return residents.size();
    }

    @Override
    public boolean isEmailAlreadyExist(String email) {
        for(Resident resident : residents) {
            if(resident.getEmail().contains(email)) {
                return true;
            }
        }
        return false;

    }
    }


