package estateTask.repository;

import estateTask.models.Resident;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Residents implements ResidentRepository {
    private List<Resident> residents = new ArrayList<>();
    private int currentId = 0;

    @Override
    public Resident save(Resident resident) {
        if(isNew(resident))saveNew(resident);else update(resident);
       return resident;
    }

    private void update(Resident resident) {
        for(int i = 0; i<residents.size(); i++){
            if(residents.get(i).getResidentId() == resident.getResidentId()){
                residents.set(i, resident);
                return;
            }
        }
    }

    private void saveNew(Resident resident) {
        resident.setResidentId(generateId());
        residents.add(resident);
    }

    private boolean isNew(Resident resident) {
        return resident.getResidentId() == 0;
    }

    @Override
    public Resident findById(long id) {
        return residents.stream().filter(e -> e.getResidentId() == id).findFirst().orElse(null);
    }

    @Override
    public void delete(Resident resident) {
        residents.removeIf(r -> r.getResidentId() == resident.getResidentId());


    }

    @Override
    public List<Resident> findAll() {
        return residents;
    }

    private long generateId() {
        return ++currentId;
    }

    @Override
    public long count() {
        return residents.size();
    }

    @Override
    public List<Resident> findByResidentName(String residentName) {
        return residents.stream().filter(e -> e.getResidentName().equals(residentName)).collect(Collectors.toList());
    }
}
