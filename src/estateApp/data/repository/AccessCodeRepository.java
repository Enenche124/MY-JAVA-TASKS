package estateApp.data.repository;

import estateApp.data.models.AccessCode;

public interface AccessCodeRepository {
    AccessCode getAccessCode(String accessCode);
    AccessCode createAccessCode(AccessCode accessCode);
    void deleteAccessCode(String accessCode);
    AccessCode findAccessCode(String accessCode);
    long count();

}
