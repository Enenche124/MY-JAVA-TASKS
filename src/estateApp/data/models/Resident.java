package estateApp.data.models;

public class Resident {

    private String residentName;
    private String residentHouseNo;
    private String phoneNumber;
    private String email;
    private long  residentId;
//    private Visitor visitor;

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public String getResidentHouseNo() {
        return residentHouseNo;
    }

    public void setResidentHouseNo(String residentHouseNo) {
        this.residentHouseNo = residentHouseNo;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getResidentId() {
        return residentId;
    }

    public void setResidentId(long residentId) {
        this.residentId = residentId;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
