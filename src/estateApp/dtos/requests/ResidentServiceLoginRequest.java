package estateApp.dtos.requests;

public class ResidentServiceLoginRequest {
    private String logPassword;
    private String email;

    public String getLogPassword() {
        return logPassword;
    }

    public void setLogPassword(String logPassword) {
        this.logPassword = logPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
