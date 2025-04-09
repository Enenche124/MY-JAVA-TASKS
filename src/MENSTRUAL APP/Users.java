public class Users {
    private String userName;
    private String userGender;
    private int age;


    public Users(String userName, String userGender, int age) {
        if (userName == null || !userName.matches("^[a-zA-Z]+$\n")) {
            throw new IllegalArgumentException("Invalid user name, Please enter a valid name");
        }
        if (userGender == null || !userGender.equalsIgnoreCase("Female")) {
            throw new IllegalArgumentException("Invalid gender, Please enter a (female) valid gender");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Invalid age, Age must be a positive integer");
        }
        if(age < 10){
            throw new IllegalArgumentException("Invalid age, You can't see your period at this age");
        }
        this.userName = userName;
        this.userGender = userGender;
        this.age = age;
    }

public String getUserName() {
        return userName;
}
public String getUserGender() {
        return userGender;
}
public int getAge() {
        return age;
}
}
