package apps.ali.com.wear;

/**
 * Created by Zohaib on 4/18/2018.
 */

public class UserModel {


    private String userFName;
    private String userLName;
    private String  phone;
    private String gender;
    private String username;
    private String userPassword;

    public UserModel(){}

    public UserModel(String userFName, String userLName, String  phone, String gender, String username, String userPassword) {
        this.userFName = userFName;
        this.userLName = userLName;
        this.phone = phone;
        this.gender = gender;
        this.username = username;
        this.userPassword = userPassword;
    }

    public String getUserFName() {
        return userFName;
    }

    public void setUserFName(String userFName) {
        this.userFName = userFName;
    }

    public String getUserLName() {
        return userLName;
    }

    public void setUserLName(String userLName) {
        this.userLName = userLName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


}
